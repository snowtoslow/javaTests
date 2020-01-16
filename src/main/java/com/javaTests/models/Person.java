package com.javaTests.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "persons")
/*@JsonIgnoreProperties(value = "getPersonId(),setPersonId()")*/
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    @JsonIgnore
    private long personId;


    @Column(name = "person_full_name")
    private String fullName;

    @Column(name = "person_email")
    private String email;


}
