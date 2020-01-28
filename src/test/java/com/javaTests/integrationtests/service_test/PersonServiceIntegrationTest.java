package com.javaTests.integrationtests.service_test;


import com.javaTests.exceptions.UserException;
import com.javaTests.models.Person;
import com.javaTests.services.serviceImpl.PersonServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PersonServiceIntegrationTest {

    @Autowired
    private PersonServiceImpl personServiceImpl;


    @Test
    public void testAddPerson() throws UserException {

        //Create a person;
        Person fred = new Person();

        fred.setEmail("fred.galagher@gmail.com");
        fred.setFullName("Fred Galagher");

        log.info("jenny:{}",fred);

        //Test adding the person
        Person newPerson = personServiceImpl.createPerson(fred);

        //Verify the addition
        Assert.assertNotNull(newPerson);

        Assert.assertNotNull(newPerson.getPersonId());

        Assert.assertNotNull("Fred Galagher",fred.getFullName());
    }


}
