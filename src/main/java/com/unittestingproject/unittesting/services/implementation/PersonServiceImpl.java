package com.unittestingproject.unittesting.services.implementation;

import com.unittestingproject.unittesting.entities.Person;
import com.unittestingproject.unittesting.repo.PersonRepository;
import com.unittestingproject.unittesting.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    @Override
    public List<Person> getAllPerson() {
        return this.personRepository.findAll();
    }
}
