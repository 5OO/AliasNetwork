package org.tims.aliasnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tims.aliasnetwork.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
