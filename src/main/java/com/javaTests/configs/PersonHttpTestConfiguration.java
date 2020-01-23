package com.javaTests.configs;

import com.javaTests.models.Person;
import com.javaTests.repository.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class PersonHttpTestConfiguration {

    @Bean
    RouterFunction<ServerResponse> routes(PersonRepository personRepository) {
        return route()
                .GET("/personsAll", request -> ok().body(personRepository.findAll(), Person.class))
                .build();
    }
}
