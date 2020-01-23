package com.javaTests.models;



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
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private long personId;


    @Column(name = "person_full_name")
    private String fullName;

    @Column(name = "person_email")
    private String email;


    public Person(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }

    public Person() {
    }
}
