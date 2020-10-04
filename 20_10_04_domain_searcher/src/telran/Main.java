package telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static final String ZONES_FILENAME = "zones.txt";

    public static void main(String[] args) throws IOException {
        FileOperations fo = new FileOperations();

        List<String> zones = fo.readFileToList(ZONES_FILENAME);
        System.out.println(zones);

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        String hostName;
        while ((hostName = consoleReader.readLine()) != null && !hostName.equals("exit")) {
            List<String> hostList = new ArrayList<>();
            for (String firstLevelDomainName : zones) {
                hostList.add(checkURL("http", hostName, firstLevelDomainName));
                hostList.add(checkURL("https", hostName, firstLevelDomainName));
            }
            fo.writeListToFile(hostList, hostName + ".txt");
            System.out.println("scan is done for: " + hostName);
        }
    }

    private static String checkURL(String protocolName, String hostName, String firstLevelDomainName) throws MalformedURLException {
        String urlName = protocolName + "://" + hostName + "." + firstLevelDomainName;
        System.out.println("requesting :" + urlName);
        URL url = new URL(urlName);
        try {
            url.openStream();
        } catch (UnknownHostException e) {
            return urlName + " does not exist";
        } catch (IOException e) {
        }
        return urlName + "  exist";
    }
}
