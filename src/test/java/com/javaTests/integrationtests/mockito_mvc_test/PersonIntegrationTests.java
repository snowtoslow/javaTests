package com.javaTests.integrationtests.mockito_mvc_test;


import com.javaTests.controllers.PersonController;
import com.javaTests.models.Person;
import com.javaTests.services.serviceImpl.PersonServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@ActiveProfiles("test")
@Slf4j
@WebMvcTest(PersonController.class )
public class PersonIntegrationTests {



    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonServiceImpl personServiceImpl;

    @InjectMocks
    private PersonController personController;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddPerson() throws Exception {
        //set up mock to return the mock service component

        Person mockPerson = new Person();

        mockPerson.setFullName("Jenny Turner");
        mockPerson.setEmail("jenny.turner@gmail.com");



        when(personServiceImpl.createPerson(any(Person.class))).thenReturn(mockPerson);

        //simulate the form bean that would post from web page
        Person person = new Person();
        person.setFullName("Jenny Turner");
        person.setEmail("jenny.turner@gmail.com");

        //simulate the form submit(POST)
        mockMvc
                .perform(post("/create/person",person))
                .andExpect(status().isOk()).andReturn();


    }
}
