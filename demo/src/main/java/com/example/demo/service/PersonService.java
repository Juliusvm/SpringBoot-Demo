package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonRepository;
import com.example.demo.model.Person;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;


    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> getAllPeople(){
        return personRepository.findAll();
    }
//
    public Optional<Person> getPersonById(Long id){
        return personRepository.findById(id);
    }
//
//    public int deletePerson(UUID id){
//        return personRepository.deletePersonById(id);
//    }
//    public int updatePerson(UUID id, Person person){
//        return personRepository.updatePersonById(id, person);
//    }
}
