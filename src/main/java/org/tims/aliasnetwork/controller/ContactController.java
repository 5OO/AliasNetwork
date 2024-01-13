package org.tims.aliasnetwork.controller;

import org.springframework.web.bind.annotation.*;
import org.tims.aliasnetwork.model.Contact;
import org.tims.aliasnetwork.repository.ContactRepository;

import java.util.List;

@RestController
@RequestMapping("api/contacts")
public class ContactController {

    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
    @GetMapping
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

}




