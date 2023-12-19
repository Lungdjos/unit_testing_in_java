package com.unittestingproject.unittesting.services;

import com.unittestingproject.unittesting.entities.Person;
import com.unittestingproject.unittesting.pojos.PersonDto;

import java.util.List;
import java.util.Map;

public interface PersonService {
    List<Person> getAllPerson();
    Map<String, Object> creatPerson(PersonDto personDto);

    List<Person> updatePerson(long id, Person person);
    void deletePerson(long id);
    List<Person> findAllPersons();
}
