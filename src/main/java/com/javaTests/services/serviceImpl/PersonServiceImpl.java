package com.javaTests.services.serviceImpl;


import com.javaTests.models.Person;
import com.javaTests.repository.PersonRepository;
import com.javaTests.services.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;



@Service
@Slf4j
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Flux<Person> fluxFindAll() {
        return personRepository.findAll();
    }
}
