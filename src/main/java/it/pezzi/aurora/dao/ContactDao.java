package it.pezzi.aurora.dao;

import it.pezzi.aurora.dao.repository.ContactRepository;
import it.pezzi.aurora.domain.Contact;
import it.pezzi.aurora.entities.Contacts;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContactDao {

    @Autowired
    private ContactRepository contactRepository;

    public Contact findByContactId(Long contactId) throws NotFoundException {

        Contacts contacts = getEntityById(contactId);

        Contact contact = new Contact();
        contact.setContactId(contacts.getContactId());
        contact.setFirstname(contacts.getFirstname());
        contact.setLastname(contacts.getLastname());
        contact.setAddress(contacts.getAddress());

        return contact;
    }

    private Contacts getEntityById(Long contactId) throws NotFoundException {
        Contacts entity = contactRepository.findByContactId(contactId);
        if (entity == null) {
            throw new NotFoundException("Contact not found");
        }
        return entity;
    }
}