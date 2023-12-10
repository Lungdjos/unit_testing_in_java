package com.unittestingproject.unittesting.services;

import com.unittestingproject.unittesting.entities.Person;
import com.unittestingproject.unittesting.pojos.PersonDto;
import com.unittestingproject.unittesting.repo.PersonRepository;

import java.util.List;
import java.util.Map;

public interface PersonService {
    List<Person> getAllPerson();
    Map<String, Object> creatPerson(PersonDto personDto);

    List<Person> updatePerson(long id, Person person);
}
