package com.mytests.spring.mongoDB.persistenteConstructorTest.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mytests.spring.mongoDB.persistenteConstructorTest.entity.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
	List<Person> findByFirstName(String firstName);
	
	List<Person> findByLastName(String lastName);
	
	List<Person> findByFirstNameAndLastName(String firstName, String lastName);
	
	@Query("{'firstName' : ?0}")
	Stream<Person> findAllByCustomQueryAndStream(String firstName);
}
