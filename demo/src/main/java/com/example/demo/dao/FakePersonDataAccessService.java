package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        return 1;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Person> getAllPeople() {
        return DB;
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personOptional = selectPersonById(id);
        if(personOptional.isPresent()){
            DB.remove(personOptional.get());
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return selectPersonById(id)
                .map(p -> {
                    Optional<Person> personToUpdate = selectPersonById(id);
                    if(personToUpdate.isPresent()){
                        DB.set(DB.indexOf(personToUpdate.get()), person);
                        return 1;
                    }
                    return 0;
                }).orElse(0);
    }
}
