package com.safetynet.safetynetalerts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.safetynet.safetynetalerts.dao.DatasDaoImpl;
import com.safetynet.safetynetalerts.model.Person;

//import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@WebMvcTest(DatasDaoImpl.class)
public class UpdateUserTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DatasDaoImpl service;
    /*
    @Test
    public void updateUser_whenPutUser() throws Exception {

    	Person person = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "johnboyd@email.com");
		

        given(service.updatePerson(person)).willReturn(person);

        mvc.perform(put("/person/" + person.getFirstName().toString())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("name", is(person.getFirstName())));
    }
    */
}