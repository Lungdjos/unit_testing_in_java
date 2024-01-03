package com.unittestingproject.unittesting.controllers;

import com.unittestingproject.unittesting.pojos.PersonDto;
import com.unittestingproject.unittesting.repo.PersonRepository;
import com.unittestingproject.unittesting.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@AllArgsConstructor
@RequestMapping("/person-controller")
public class PersonController {
    private final PersonService personService;
    private final PersonRepository personRepository;

    @GetMapping("/")
    public ModelAndView signupPage(PersonDto personDto){
        ModelAndView modelAndView = new ModelAndView("login/signup");
        modelAndView.addObject("personDto", personDto);
        return modelAndView;
    }
    @PostMapping("/addPerson")
    public ModelAndView creatPerson(@Validated PersonDto personDto, BindingResult result, Model model){
        ModelAndView modelAndView = new ModelAndView("index");

        if(result.hasErrors()){
            modelAndView = new ModelAndView("/");
            return modelAndView;
        }
        var person = personService.creatPerson(personDto);

        if(person.get("status").equals("SUCCESS")){
            modelAndView.addObject("persons", person.get("personObjs"));
            return modelAndView;
        }else {
            modelAndView = new ModelAndView("/");
            return modelAndView;
        }
    }
    @GetMapping(value = "/home")
    public ModelAndView navigateHome(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("persons", personService.findAllPersons());
        return modelAndView;
    }
}
