package com.javaTests.controllers;


import com.javaTests.exceptions.UserException;
import com.javaTests.models.Person;
import com.javaTests.repository.PersonRepository;
import com.javaTests.services.serviceImpl.PersonServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController extends PersonServiceImpl{


    public PersonController(PersonRepository personRepository) {
        super(personRepository);
    }

    @Override
    @GetMapping("/persons")
    public List<Person> findAll(){
        return super.findAll();
    }

    @Override
    @GetMapping("person/{personId}")
    public Object readPersonById(@PathVariable long personId) throws UserException {
        return super.readPersonById(personId);
    }

    @Override
    @DeleteMapping("person/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePerson(@PathVariable long id) {
        super.deletePerson(id);
    }

    @Override
    @PostMapping("person/create")
    public Person createPerson(@RequestBody Person person) throws UserException {
        return super.createPerson(person);
    }

    @Override
    @PutMapping("person/update/{personId}")
    public ResponseEntity<Object> updatePerson(@RequestBody Person person,@PathVariable long personId) throws UserException {
        return super.updatePerson(person,personId);
    }
}
