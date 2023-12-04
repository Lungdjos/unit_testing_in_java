package com.unittestingproject.unittesting.services;

import com.unittestingproject.unittesting.entities.Person;
import com.unittestingproject.unittesting.repo.PersonRepository;

import java.util.List;

public interface PersonService {
    List<Person> getAllPerson();
}
