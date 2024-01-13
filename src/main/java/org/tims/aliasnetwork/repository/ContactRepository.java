package org.tims.aliasnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tims.aliasnetwork.model.Contact;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findAllByCodeNameContainingIgnoreCase(String codeName);

    List<Contact> findAllByFirstNameContainingIgnoreCase(String firstName);

    List<Contact> findAllByLastNameContainingIgnoreCase(String lastName);

}
