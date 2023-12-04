package com.unittestingproject.unittesting.services;

import com.unittestingproject.unittesting.entities.Person;
import com.unittestingproject.unittesting.repo.PersonRepository;
import com.unittestingproject.unittesting.services.implementation.PersonServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    @Mock
    private PersonRepository personRepository;
    private PersonService personService;
    @BeforeEach
    void setUp(){
        this.personService = new PersonServiceImpl(personRepository);
    }
    @Test
    void getAllPersons(){
        personService.getAllPerson();

        // asserting the results
        verify(personRepository).findAll();
    }
}
