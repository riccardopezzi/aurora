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

    public Contact findByCode(String code) throws NotFoundException {

        Contacts contacts = getEntityByCode(code);

        Contact contact = new Contact();
        contact.setCode(contacts.getCode());
        return contact;
    }

    private Contacts getEntityByCode(String code) throws NotFoundException {
        Contacts entity = contactRepository.findByCode(code);
        if (entity == null) {
            throw new NotFoundException("Contact not found");
        }
        return entity;
    }
}