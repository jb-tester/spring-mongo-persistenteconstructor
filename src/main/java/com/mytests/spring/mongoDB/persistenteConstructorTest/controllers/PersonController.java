package com.mytests.spring.mongoDB.persistenteConstructorTest.controllers;

import com.mytests.spring.mongoDB.persistenteConstructorTest.entity.Person;
import com.mytests.spring.mongoDB.persistenteConstructorTest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * *
 * <p>Created by irina on 9/16/2021.</p>
 * <p>Project: spring-mongo-persistenteconstructor</p>
 * *
 */
@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/all")
    public String all() {
        personRepository.deleteAll();
        Person emp1 = new Person("ivan", "ivanov");
        Person emp2 = new Person("petr", "petrov");
        Person emp3 = new Person("alexandr", "alexandrov");
        Person emp4 = new Person("aleksey", "alekseev");
        personRepository.saveAll(Arrays.asList(emp1, emp2, emp3, emp4));
        String rez = "all persons: \n";
        for (Person person : personRepository.findAll()) {
            rez = rez + person;
        }
        return rez;
    }
}
