package org.tims.aliasnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tims.aliasnetwork.model.Contact;
import org.tims.aliasnetwork.repository.ContactRepository;

import java.util.List;

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

    public List<Contact> getContactsByCodeName(String codeName) {
        return contactRepository.findAllByCodeNameContainingIgnoreCase(codeName);
    }

public List<Contact> getContactsByFirstName(String firstName) {
        return contactRepository.findAllByFirstNameContainingIgnoreCase(firstName);
    }

    public List<Contact> getContactsByLastName(String lastName) {
        return contactRepository.findAllByLastNameContainingIgnoreCase(lastName);
    }

}
