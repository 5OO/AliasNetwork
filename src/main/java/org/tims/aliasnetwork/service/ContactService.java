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

}
