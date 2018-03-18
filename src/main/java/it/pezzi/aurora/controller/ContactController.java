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

    @ApiOperation(value = "Search contact by code")
    @RequestMapping(method = RequestMethod.GET)
    public Contact getContact(@RequestParam(value="code") String code) throws NotFoundException {
            return contactService.findByCode(code);
    }
}