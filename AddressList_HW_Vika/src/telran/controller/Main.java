package telran.controller;

import telran.data.Address;
import telran.data.AddressBook;
import telran.data.Person;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Victoria",new Address("Eugen-Shonhaar",28)));
        persons.add(new Person("Kristina",new Address("Greifswalder",5)));
        persons.add(new Person("Pavel",new Address("Shonhauser Alee",37)));

        System.out.println(AddressBook.getAddresses(persons));
    }

}
