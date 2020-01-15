package com.javaTests.services;

import com.javaTests.exceptions.UserException;
import com.javaTests.models.Person;
import com.javaTests.repository.PersonRepository;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonService {

    List<Person> findAll();

    Object readPersonById(long id) throws UserException;

    void deletePerson(long id);

    ResponseEntity<Object> createPerson(Person person) throws UserException;

    ResponseEntity<Object> updatePerson(Person person,long id) throws UserException;


    Person findByEmail(String email) throws UserException;
}
