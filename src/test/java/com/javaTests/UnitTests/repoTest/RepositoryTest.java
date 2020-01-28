package com.javaTests.UnitTests.repoTest;



import com.javaTests.models.Person;
import com.javaTests.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
public class RepositoryTest {

    @MockBean
    private PersonRepository personRepository;

    @Test
    public void finBYEmail() {

        Person person = new Person("vova","vova@gmail.com");

        when(personRepository.findByEmail(person.getEmail())).thenReturn(person);

    }

}
