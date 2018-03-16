package it.pezzi.aurora.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import it.pezzi.aurora.domain.Contact;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
@Api(value = "Contact controller")
public class ContactController {

    @ApiOperation(value = "Search contact by code")
    @RequestMapping(method = RequestMethod.GET)
    public Contact getContact(@RequestParam(value="code") String code) {
        return new Contact();
    }
}