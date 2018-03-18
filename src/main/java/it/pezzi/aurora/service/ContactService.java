package it.pezzi.aurora.service;

import it.pezzi.aurora.dao.ContactDao;
import it.pezzi.aurora.domain.Contact;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    @Autowired
    private ContactDao contactDao;

    public Contact getContact(Long contactId) throws NotFoundException {
        return contactDao.findByContactId(contactId);
    }

    public void insertContact(Contact contact) {
        contactDao.insertContact(contact);
    }

    public void deleteContact(Long contactId) {
        contactDao.deleteContact(contactId);
    }

    public void updateContact(Contact contact) {
        contactDao.updateContact(contact);
    }

}
