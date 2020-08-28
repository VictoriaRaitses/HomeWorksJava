package telran.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    // properties container
    private Properties prop = new Properties();
    private InputStream inputStream;

    public PropertiesLoader(String confFile) throws IOException {
        //read properties file (config.properties)
        inputStream = getClass().getClassLoader().getResourceAsStream(confFile);
        if (inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + confFile + "' not found in the classpath");
        }
        inputStream.close();
    }

    public String getProperty(String propertyName) {
        return prop.getProperty(propertyName);

    }
}
