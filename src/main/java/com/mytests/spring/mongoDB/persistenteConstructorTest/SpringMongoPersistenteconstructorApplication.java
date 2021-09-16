package com.mytests.spring.mongoDB.persistenteConstructorTest;

import com.mytests.spring.mongoDB.persistenteConstructorTest.entity.Person;
import com.mytests.spring.mongoDB.persistenteConstructorTest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringMongoPersistenteconstructorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMongoPersistenteconstructorApplication.class, args);
    }

    @Bean
    public Utils utils() {
        return new Utils();
    }
}
