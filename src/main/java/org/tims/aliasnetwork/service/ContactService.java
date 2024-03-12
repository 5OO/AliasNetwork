package org.tims.aliasnetwork.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tims.aliasnetwork.model.Contact;
import org.tims.aliasnetwork.repository.ContactRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

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

    public Contact updateContact(Long id, Contact updatedContact) {
        Contact existingContact = contactRepository.findById(id).orElse(null);
        if (existingContact != null) {
            existingContact.setFirstName(updatedContact.getFirstName());
            existingContact.setLastName(updatedContact.getLastName());
            existingContact.setCodeName(updatedContact.getCodeName());
            existingContact.setPhoneNumber(updatedContact.getPhoneNumber());
            return contactRepository.save(existingContact);
        } else {
            throw new EntityNotFoundException(" Contact with id:" + id + " not found");
        }
    }

    public void deleteContact(Long id) {
        if (!contactRepository.existsById(id)) {
            throw new EntityNotFoundException("Contact with id # " + id + " not found.");
        }
        contactRepository.deleteById(id);
    }
}
