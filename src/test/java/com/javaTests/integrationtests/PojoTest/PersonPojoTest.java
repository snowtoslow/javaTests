package com.javaTests.integrationtests.PojoTest;

import com.javaTests.models.Person;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;




public class PersonPojoTest {

    @Test
    public void create(){

        Person person = new Person();
        person.setFullName("Izbash Vitalie");
        person.setEmail("vitalie.izbash@gmail.com");

        Assert.assertEquals(person.getFullName(),"Izbash Vitalie");
        Assert.assertEquals(person.getEmail(),"vitalie.izbash@gmail.com");
        Assert.assertThat(person.getFullName(), Matchers.equalToIgnoringCase("Izbash Vitalie"));


    }



}
