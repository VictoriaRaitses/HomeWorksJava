package de.telran.contacts.service;

import de.telran.contacts.model.Contact;
import de.telran.contacts.repository.IContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    final private IContactRepo contactRepo;

    @Autowired
    public ContactServiceImpl(IContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public void add(Contact contact) {
        contactRepo.add(contact);
    }

}
