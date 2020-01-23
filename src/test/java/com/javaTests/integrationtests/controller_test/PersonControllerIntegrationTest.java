package com.javaTests.integrationtests.controller_test;

import com.javaTests.controllers.PersonController;
import com.javaTests.exceptions.UserException;
import com.javaTests.models.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest()
@ActiveProfiles("test")
@Slf4j
public class PersonControllerIntegrationTest {

    private final String MISSED_EMAIL_MESSAGE = "You have missed EMAIL FIELD!!!!!!Please complete it!";

    private final String MISSED_FULLNAME_MESSAGE = "You have missed FULL NAME filed!Please complete it!";

    @Autowired
    private PersonController personController;



    @Test
    public void testControllerAddPerson() throws UserException {

        Person jenny = new Person();

        jenny.setFullName("Jenny Turner");
        jenny.setEmail("turner.jenny@gmail.com");

        Person outcome = personController.createPerson(jenny);


        Assert.assertThat(outcome,is(equalTo(jenny)));

    }


    @Test(expected = UserException.class)
    public void forgetToAddFirstName() throws UserException {

        Person jenny = new Person();

        jenny.setEmail("turner.jenny@gmail.com");

        Person outcome = personController.createPerson(jenny);

        Assert.assertThat(outcome,is(equalTo(new UserException(MISSED_FULLNAME_MESSAGE))));
    }


    @Test(expected = UserException.class)
    public void forgetAddEmail() throws UserException{
        Person jenny = new Person();

        jenny.setFullName("Jenny Turner");

        Person outcome = personController.createPerson(jenny);

        Assert.assertThat(outcome,is(equalTo(new UserException(MISSED_EMAIL_MESSAGE))));

    }
}
