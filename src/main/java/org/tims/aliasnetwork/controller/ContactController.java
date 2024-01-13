package org.tims.aliasnetwork.controller;

import org.springframework.web.bind.annotation.*;
import org.tims.aliasnetwork.model.Contact;
import org.tims.aliasnetwork.service.ContactService;

import java.util.List;

@RestController
@RequestMapping("api/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }
    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }
    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        return contactService.createContact(contact);
    }
    @GetMapping("/search/{codeName}")
    public List<Contact> getContactsByCodeName(@PathVariable String codeName) {
        return contactService.getContactsByCodeName(codeName);
    }
    @GetMapping("/search/firstName/{firstName}")
    public List<Contact> getContactsByFirstName(@PathVariable String firstName) {
        return contactService.getContactsByFirstName(firstName);
    }

}




