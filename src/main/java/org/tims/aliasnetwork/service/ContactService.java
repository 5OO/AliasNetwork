package org.tims.aliasnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.tims.aliasnetwork.model.Contact;
import org.tims.aliasnetwork.repository.ContactRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Optional<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contact) {

        Contact existingContact = contactRepository.findById(id).orElse(null);
        if (existingContact != null) {
            existingContact.setFirstName(contact.getFirstName());
            existingContact.setLastName(contact.getLastName());
            existingContact.setCodeName(contact.getCodeName());
            existingContact.setPhoneNumber(contact.getPhoneNumber());
            return Optional.of(contactRepository.save(existingContact));
        }
        return Optional.empty();
        }

    }
