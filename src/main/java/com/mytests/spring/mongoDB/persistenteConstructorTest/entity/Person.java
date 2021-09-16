package com.mytests.spring.mongoDB.persistenteConstructorTest.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("persons")
@CompoundIndex(name = "cmp-idx-names", def = "{'firstName': 1, 'lastName': -1}")
@CompoundIndex(def = "#{T(org.bson.Document).parse(\"{ 'firstName': -1 }\")}")
public class Person {
	@Id
	private String id;

	@Field("person_first_name")
	@Indexed(name = "pers_first_name", direction = IndexDirection.ASCENDING)
	private String firstName;

	@Field("person_last_name")
	@Indexed(name="#{@utils.indexName}")
	private String lastName;

	@Transient
	private String fullName;

	public Person() {
	}
    @PersistenceConstructor
	public Person(@Value("#root.person_first_name") String name) {
		this.firstName = name;
	}

	@PersistenceConstructor
	public Person(@Value("#root.person_first_name") String firstName,
				  @Value("#root.person_last_name") String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = this.firstName + " " + this.lastName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [id=").append(id).append(": ").append(this.fullName).append("] ");
		return builder.toString();
	}

}
