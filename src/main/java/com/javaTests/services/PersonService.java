package com.javaTests.services;

import com.javaTests.exceptions.UserException;
import com.javaTests.models.Person;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;

import java.util.List;

public interface PersonService {

    Flux<Person> fluxFindAll();
}
