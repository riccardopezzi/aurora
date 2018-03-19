package it.pezzi.aurora.controller;

import com.google.gson.Gson;
import it.pezzi.aurora.Application;
import it.pezzi.aurora.domain.Contact;
import it.pezzi.aurora.service.ContactService;
import javassist.NotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ContactControllerTest {

    @InjectMocks
    private ContactController contactController;

    private MockMvc mockMvc;

    @Mock
    private ContactService contactService;

    @Before
    public void setup() {
        mockMvc = standaloneSetup(contactController)
                .setControllerAdvice(new RestExceptionHandler())
                .build();
    }

    @Test
    public void getContactSuccessful() throws Exception {
        Long contactId = 123L;

        Contact contact = new Contact();
        contact.setContactId(contactId);
        contact.setAddress("test address");
        contact.setFirstname("test firstname");
        contact.setLastname("test lastname");

        given(contactService.getContact(contactId)).willReturn(contact);

        mockMvc.perform(get("/contact?contactId={contactId}", contactId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.address").value(contact.getAddress()))
                .andExpect(jsonPath("$.firstname").value(contact.getFirstname()))
                .andExpect(jsonPath("$.lastname").value(contact.getLastname()))
                .andExpect(jsonPath("$.contactId").value(contact.getContactId()));

        verify(contactService, times(1)).getContact(contactId);

    }

    @Test
    public void getContactNotFound() throws Exception {
        Long contactId = 123L;

        doThrow(new NotFoundException("Error")).when(contactService)
                .getContact(contactId);

        mockMvc.perform(get("/contact?contactId={contactId}", contactId))
                .andExpect(status().isNotFound());

    }

    @Test
    public void insertContactSuccess() throws Exception {

        Contact contact = new Contact();
        contact.setAddress("test address");
        contact.setFirstname("test firstname");
        contact.setLastname("test lastname");

        doNothing().when(contactService).insertContact(contact);

        Gson gson = new Gson();

        mockMvc.perform(post("/contact")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(contact)))
                .andExpect(status().isCreated());

    }

    @Test
    public void deleteContactSuccessful() throws Exception {
        Long contactId = 123L;

        doNothing().when(contactService).deleteContact(contactId);

        mockMvc.perform(delete("/contact?contactId={contactId}", contactId))
                .andExpect(status().isOk());

    }

    @Test
    public void updateContactSuccessful() throws Exception {
        Long contactId = 123L;

        Contact contact = new Contact();
        contact.setAddress("test address");
        contact.setFirstname("test firstname");
        contact.setLastname("test lastname");
        contact.setContactId(contactId);

        doNothing().when(contactService).updateContact(contact);

        mockMvc.perform(put("/contact?contactId={contactId}&firstname={firstname}&lastname={lastname}&address={address}", contact.getContactId(), contact.getFirstname(), contact.getLastname(), contact.getAddress()))
                .andExpect(status().isOk());

    }

}
