package com.example.demo.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

@RequestMapping("/api/v1/persons")
@RestController()
public class PersonController {

    @Autowired
    private PersonService personService;


    @PostMapping
    private Person addPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }

    @GetMapping("/all")
    private List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Optional<Person> getPersonById(@PathVariable("id") Long id){
        return personService.getPersonById(id);
    }
//
//    @DeleteMapping(path = "{id}")
//    public int deletePerson(@PathVariable("id") UUID id){
//        return personService.deletePerson(id);
//    }
//
//    @PutMapping(path = "{id}")
//    public int updatePerson(@PathVariable("id") UUID id, @RequestBody Person person){
//        return personService.updatePerson(id, person);
//    }
}
