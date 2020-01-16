package com.javaTests.services.serviceImpl;

import com.javaTests.exceptions.UserException;
import com.javaTests.models.Person;
import com.javaTests.repository.PersonRepository;
import com.javaTests.services.PersonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public List<Person> findAll(){

        return personRepository.findAll();
    }

    @Override
    public Object readPersonById(long personId) throws UserException {
       return personRepository.findById(personId).orElseThrow(()->new UserException("There is no person with such ID:"+personId));
    }

    @Override
    public void deletePerson(long personId) {
        personRepository.deleteById(personId);
    }

    @Override
    public Person createPerson(Person person) throws UserException {


        if (personRepository.findByEmail(person.getEmail())!=null){
            throw new UserException("There is already person with such email: "+person.getEmail());
        }else if (person.getEmail()==null){
            throw new UserException("You have missed EMAIL FIELD!!!!!!Please complete it!");
        }else if (person.getFullName()==null){
            throw new UserException("You have missed FULL NAME filed!Please complete it!");
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{personId}").buildAndExpand(personRepository.save(person).getPersonId()).toUri();

        ResponseEntity.created(location).build();

        return person;
    }

    @Override
    public ResponseEntity<Object> updatePerson(Person person,long personId) throws UserException {
        Optional.ofNullable(personRepository.findById(personId)
                .map(person1 -> {
                            log.info("Post with personId = '{}' faunded.", personId);
                            person.setPersonId(personId);
                            personRepository.save(person);
                            log.info("person updated:{}",person);
                            return person;
                        }
                ).orElseThrow(() -> new UserException("There is no user with such personId " + personId)));
        return ResponseEntity.noContent().build();
    }

    @Override
    public Person findByEmail(String email) throws UserException {
        return Optional.of(personRepository.findByEmail(email)).orElseThrow(()->new UserException("There is no user with such email: "+ email));
    }


}
