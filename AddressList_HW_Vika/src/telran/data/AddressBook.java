package telran.data;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    public static List getAddresses(List<Person> persons) {
        List<Address> addresses = new ArrayList<>();
        for(Person person : persons) {
            addresses.add(person.getAddress());
        }
        return addresses;
    }
}
