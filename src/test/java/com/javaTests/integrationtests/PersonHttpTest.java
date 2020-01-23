package com.javaTests.integrationtests;


import com.javaTests.models.Person;
import com.javaTests.configs.PersonHttpTestConfiguration;
import com.javaTests.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;


@WebFluxTest
@Import(PersonHttpTestConfiguration.class)
@RunWith(SpringRunner.class)
public class PersonHttpTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private PersonRepository personRepository;


    @Test
    public void getAllPerson(){

        Mockito
                .when(this.personRepository.findAll())
                .thenReturn((Flux.just(new Person("Jane","jane@gmail.com"))));


        this.webTestClient
                .get()
                .uri("http://localhost:8081/personsAll")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody().jsonPath("@.[0].fullName", "Jane").exists();
    }




}
