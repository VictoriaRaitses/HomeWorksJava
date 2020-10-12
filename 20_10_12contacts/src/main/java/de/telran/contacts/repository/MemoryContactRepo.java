package de.telran.contacts.repository;

import de.telran.contacts.model.Contact;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//TODO implement and write tests
@Repository
public class MemoryContactRepo implements IContactRepo {
    List<Contact> source = new ArrayList<>();
    private static int sourceId = 0;

    @Override
    public synchronized void add(Contact contact) {
        contact.setId(++sourceId);
        source.add(contact);
    }

    @Override
    public Contact getById(int id) {
        return source.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void edit(int id, Contact contact) {
        Contact c = getById(id);
        if (c != null) {
            c.setName(contact.getName());
            c.setNumber(contact.getNumber());
            source.add(c);
        }
    }

    @Override
    public List<Contact> getAll() {
        return source;
    }

    @Override
    public void remove(int id) {
        Contact contact = getById(id);
        if (contact != null)
            source.remove(contact);
    }
}
