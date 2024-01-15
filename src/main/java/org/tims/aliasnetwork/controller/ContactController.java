package org.tims.aliasnetwork.controller;

import org.springframework.web.bind.annotation.*;
import org.tims.aliasnetwork.model.Contact;
import org.tims.aliasnetwork.service.ContactService;

import javax.validation.Valid;
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
    public Contact createContact(@Valid @RequestBody Contact contact) {
        return contactService.createContact(contact);
    }
    @GetMapping("/search/codeName/{codeName}")
    public List<Contact> getContactsByCodeName(@PathVariable String codeName) {
        return contactService.getContactsByCodeName(codeName);
    }
    @GetMapping("/search/firstName/{firstName}")
    public List<Contact> getContactsByFirstName(@PathVariable String firstName) {
        return contactService.getContactsByFirstName(firstName);
    }
    @GetMapping("/search/lastName/{lastName}")
    public List<Contact> getContactsByLastName(@PathVariable String lastName) {
        return contactService.getContactsByLastName(lastName);
    }

    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable Long id, @RequestBody Contact updatedContact) {
        return contactService.updateContact(id, updatedContact);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
    }

}




