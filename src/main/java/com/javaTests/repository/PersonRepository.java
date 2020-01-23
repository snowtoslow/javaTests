package com.javaTests.repository;

import com.javaTests.models.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface PersonRepository extends ReactiveCrudRepository<Person,Long> {

}
