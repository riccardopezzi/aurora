package it.pezzi.aurora.controller;

import it.pezzi.aurora.Application;
import it.pezzi.aurora.domain.Contact;
import it.pezzi.aurora.service.ContactService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(ContactController.class)
@ContextConfiguration(classes={Application.class})
public class ContactControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactService contactService;

    @Test
    public void getContactSuccessful() throws Exception {
        Long contactId = 123L;

        Contact contact = new Contact();
        contact.setContactId(contactId);
        contact.setAddress("test address");
        contact.setFirstname("test firstname");
        contact.setLastname("test lastname");
        given(contactService.getContact(contactId)).willReturn(contact);

        mockMvc.perform(get("/contact/{contactId}", contactId))
                .andExpect(status().isOk());

      //  verify(contactService, times(1)).getContact(contactId);*/

    }
}
