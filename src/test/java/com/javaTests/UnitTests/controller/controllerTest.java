package com.javaTests.UnitTests.controller;

import com.javaTests.controllers.PersonController;
import com.javaTests.models.Person;
import com.javaTests.repository.PersonRepository;
import com.javaTests.services.serviceImpl.PersonServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@Slf4j
@WebMvcTest(PersonController.class)
@RunWith(SpringRunner.class)
public class controllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PersonServiceImpl personServiceImpl;

    @Test
    public void getAllPersons() throws Exception {
        Person jane = new Person("Jane Turner","jane@gmail.com");
        Person greg = new Person("Greg Winston","winston.greg@gmail.com");
        personServiceImpl.createPerson(jane);
        personServiceImpl.createPerson(greg);

        List<Person> persons = Arrays.asList(jane,greg);

        when(personServiceImpl.findAll()).thenReturn(persons);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/persons").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
        log.info(mvcResult.toString());

        String expected = "["+"{"+"personId: 0, fullName: Jane Turner, email: jane@gmail.com}" + "," + "{personId: 0, fullName: Greg Winston, email: winston.greg@gmail.com}"+"]";

        JSONAssert.assertEquals(expected,mvcResult.getResponse().getContentAsString(),false);

    }


}
