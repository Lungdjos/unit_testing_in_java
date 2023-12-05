package com.unittestingproject.unittesting.services.implementation;

import com.unittestingproject.unittesting.entities.Person;
import com.unittestingproject.unittesting.pojos.PersonDto;
import com.unittestingproject.unittesting.repo.PersonRepository;
import com.unittestingproject.unittesting.services.PersonService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    @Override
    public List<Person> getAllPerson() {
        return this.personRepository.findAll();
    }

    @Override
    @Transactional
    public Map<String, Object> creatPerson(PersonDto personDto) {
        Map<String, Object> map = new HashMap<>();
        var personObj =  new Person();
        if(Objects.nonNull(personDto)){
            Person person = personRepository.findDistinctByEmail(personDto.getEmail());

            // validations to avoid duplicates
            if(Objects.isNull(person)){
                // create person object
                personObj.setFName(personDto.getFName());
                personObj.setLName(personDto.getLName());
                personObj.setEmail(personDto.getEmail());
                personObj.setCityName(personDto.getCityName());

                personRepository.save(personObj);

                map.put("status", "SUCCESS");
                map.put("message", "User added successfully.");

                map.put("data", personObj);

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
}
