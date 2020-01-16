package com.javaTests.IntegrationTests.repository_test;



import com.javaTests.models.Person;
import com.javaTests.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@DataJpaTest//import all components need for test jpa
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)//allow us to specify the test of database allow us to rollback database
@ActiveProfiles("test")//indicate profile
public class PersonRepositoryIntegrationTests {


    @Autowired
    private TestEntityManager entityManager;//help us to create an persis entity in DB

    @Autowired
    private PersonRepository personRepository;


    @Test
    public void testByEmail() {
        //create person
        Person person = new Person();
        person.setEmail("julya.turner@gmail.com");
        person.setFullName("Julia Turner");

        //directly save person in database
        entityManager.persist(person);

        //find person by email input
        Person foundPerson = personRepository.findByEmail("julya.turner@gmail.com");

        //check if it's equal
        Assert.assertThat(foundPerson.getEmail(), is(equalTo("julya.turner@gmail.com")));
    }





}
