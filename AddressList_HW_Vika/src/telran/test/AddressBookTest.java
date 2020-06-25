package telran.test;

import org.junit.Assert;
import org.junit.Test;
import telran.data.Address;
import telran.data.AddressBook;
import telran.data.Person;

import java.util.ArrayList;
import java.util.List;

public class AddressBookTest {
    @Test
    public void testGetAddresses() {
        List<Person> persons = new ArrayList<>();
        List<Address> addresses = new ArrayList<>();

        Address v = new Address("Eugen-Shonhaar", 28);
        Address k = new Address("Greifswalder", 5);
        Address p = new Address("Shonhauser Alee", 37);

        persons.add(new Person("Victoria", v));
        persons.add(new Person("Kristina", k));
        persons.add(new Person("Pavel", p));

        addresses.add(v);
        addresses.add(k);
        addresses.add(p);

        Assert.assertEquals(addresses, AddressBook.getAddresses(persons));
    }

}
