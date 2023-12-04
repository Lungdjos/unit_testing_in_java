package com.unittestingproject.unittesting.controllers;

import com.unittestingproject.unittesting.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping("/person")
    public ResponseEntity<?> getAllPersons(){
        return ResponseEntity.ok(this.personService.getAllPerson());
    }
}
