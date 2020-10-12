package de.telran.contacts.controller;

import de.telran.contacts.model.Contact;
import de.telran.contacts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//TODO use here ContactService
@Controller
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact/add")
    public String addContactPage(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact-form";
    }

    //TODO save the received contact
    @PostMapping("/contact/add")
    public String addContactPage(@ModelAttribute Contact contact) {
        contactService.add(contact);

        return "contact-form";
    }

}
