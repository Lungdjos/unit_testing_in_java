package com.unittestingproject.unittesting.controllers;

import com.unittestingproject.unittesting.pojos.PersonDto;
import com.unittestingproject.unittesting.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/personController")
public class PersonController {
    private final PersonService personService;
    @PostMapping(value = "/addPerson")
    public ModelAndView creatPerson(@RequestBody PersonDto requestData){
        ModelAndView modelAndView = new ModelAndView("index");
        Map<String, Object> map = personService.creatPerson(requestData);

        modelAndView.addAllObjects(map);

        return modelAndView;
    }
}
