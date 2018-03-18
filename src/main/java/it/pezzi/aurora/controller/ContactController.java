package it.pezzi.aurora.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import it.pezzi.aurora.domain.Contact;
import it.pezzi.aurora.service.ContactService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
@Api(value = "Contact controller")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @ApiOperation(value = "Search contact by id")
    @RequestMapping(method = RequestMethod.GET)
    public Contact getContact(@RequestParam(value="contactId") Long contactId) throws NotFoundException {
            return contactService.getContact(contactId);
    }

    @ApiOperation(value = "Insert a new contact")
    @RequestMapping(method = RequestMethod.POST)
    public void insertContact(@RequestParam(value="firstname") String firstname,
                                 @RequestParam(value="lastname") String lastname,
                                 @RequestParam(value="address") String address)  {

        Contact contact = new Contact();
        contact.setFirstname(firstname);
        contact.setLastname(lastname);
        contact.setAddress(address);

        contactService.insertContact(contact);
    }

    @ApiOperation(value = "Delete a contact")
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteContact(@RequestParam(value="contactId") Long contactId)  {
        contactService.deleteContact(contactId);
    }

    @ApiOperation(value = "Update a contact")
    @RequestMapping(method = RequestMethod.PUT)
    public void updateContact(@RequestParam(value="contactId") Long contactId,
                              @RequestParam(value="firstname") String firstname,
                              @RequestParam(value="lastname") String lastname,
                              @RequestParam(value="address") String address
                              ) {

        Contact contact = new Contact();
        contact.setContactId(contactId);
        contact.setFirstname(firstname);
        contact.setLastname(lastname);
        contact.setAddress(address);

        contactService.updateContact(contact);
    }

}