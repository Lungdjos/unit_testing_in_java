package com.unittestingproject.unittesting.repo;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.booleanThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PersonRepositoryTest {

    private PersonRepository personRepository;
    @Before("")
    public void setUp(){
        // implementation
        personRepository = (PersonRepository) MockitoAnnotations.openMocks(this);
    }
    @Test
    void verifyMethod(){
        var id = 1;
        verify(personRepository).isPersonExistById(id);
    }
}
