package org.tims.aliasnetwork.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tims.aliasnetwork.model.Contact;
import org.tims.aliasnetwork.service.ContactService;

import java.util.List;
import java.util.Optional;

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
    @PutMapping("/{id}")
    public ResponseEntity<Optional<Contact>> updateContact(@PathVariable(value="id") Long id, @RequestBody Contact contactDetails) {
        Optional<Contact> updatedContact = contactService.updateContact(id, contactDetails);
        if (updatedContact.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedContact);
    }

}




