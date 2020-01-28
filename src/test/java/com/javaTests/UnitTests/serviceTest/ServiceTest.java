package com.javaTests.UnitTests.serviceTest;


import com.javaTests.exceptions.UserException;
import com.javaTests.models.Person;
import com.javaTests.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;


@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest
public class ServiceTest {


    @Mock
    private PersonRepository personRepository;

    /*@InjectMocks
    private PersonServiceImpl personServiceImpl;*/

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void addPerson() throws UserException {

        Person jane = new Person("Jane Turner", "jane@gmail.com");

        Mockito.when(personRepository.save(any(Person.class))).thenReturn(jane);

       /* Person person = personServiceImpl.createPerson(null);

        Assert.assertEquals("Jane Turner",person.getFullName());*/



    }



}
