package com.javaTests.controllers;


import com.javaTests.exceptions.UserException;
import com.javaTests.models.Person;
import com.javaTests.services.serviceImpl.PersonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import reactor.core.publisher.Flux;


import java.util.List;

@RestController
public class PersonController{


    @Autowired
    private PersonServiceImpl personServiceImpl;

    @GetMapping("/persons")
    public List<Person> findAll(){
        return personServiceImpl.findAll();
    }


    @GetMapping("person/{personId}")
    public Object readPersonById(@PathVariable long personId) throws UserException {
        return personServiceImpl.readPersonById(personId);
    }


    @DeleteMapping("person/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePerson(@PathVariable long id) {
        personServiceImpl.deletePerson(id);
    }


    @PostMapping("person/create")
    public Person createPerson(@RequestBody Person person) throws UserException {
        return personServiceImpl.createPerson(person);
    }


    @PutMapping("person/update/{personId}")
    public ResponseEntity<Object> updatePerson(@RequestBody Person person,@PathVariable long personId) throws UserException {
        return personServiceImpl.updatePerson(person,personId);
    }



}
