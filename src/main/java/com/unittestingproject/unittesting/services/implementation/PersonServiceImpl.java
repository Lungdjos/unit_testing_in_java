package com.unittestingproject.unittesting.services.implementation;

import com.unittestingproject.unittesting.entities.Person;
import com.unittestingproject.unittesting.pojos.PersonDto;
import com.unittestingproject.unittesting.repo.PersonRepository;
import com.unittestingproject.unittesting.services.PersonService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
@Log4j2
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    @Override
    public List<Person> getAllPerson() {
        return this.personRepository.findAll();
    }

    /**
     *  the method that creates a person and saves to the DB
     * @param personDto
     * @return
     */
    @Override
    @Transactional
    public Map<String, Object> creatPerson(PersonDto personDto) {
        Map<String, Object> map = new HashMap<>();
        var personObj =  new Person();
        if(Objects.nonNull(personDto)){
            Person person = personRepository.findDistinctByEmail(personDto.getEmail());

            // validations to avoid duplicates
            if(Objects.isNull(person)){
                log.info("Creating a User object");
                // create person object
                personObj.setFName(personDto.getFName());
                personObj.setLName(personDto.getLName());
                personObj.setEmail(personDto.getEmail());
                personObj.setCityName(personDto.getCityName());

                personRepository.save(personObj);

                map.put("status", "SUCCESS");
                map.put("message", "User added successfully.");

                List<Person> personObjs = personRepository.findAll();
                map.put("personObjs", personObjs);

                log.info("Successfully created a user.");
            } else {
                map.put("status", "ERROR");
                map.put("message", "User with this email address " + personDto.getEmail() + " already exists.");
            }
            return map;
        } else {
            map.put("status", "ERROR");
            map.put("message", "You cannot save a null object of a person.");
            return map;
        }
    }

    @Override
    @Transactional
    public List<Person> updatePerson(long id, Person person) {
        // finding the object by id
        var personToUpdate = personRepository.findById(id);
        personRepository.save(person);
        return findAllPersons();
    }

    @Override
    public void deletePerson(long id) {
        var personToDelete = personRepository.findById(id);
        if(Objects.nonNull(personToDelete)){
            personRepository.deleteById(id);
        }else {
            throw new ObjectNotFoundException(personToDelete, "The object is not available in the database.");
        }
    }

    @Override
    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }
}
