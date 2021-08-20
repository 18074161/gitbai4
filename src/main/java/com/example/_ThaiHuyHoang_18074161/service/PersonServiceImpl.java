/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example._ThaiHuyHoang_18074161.service;


import com.example._ThaiHuyHoang_18074161.dao.PersonRepo;
import com.example._ThaiHuyHoang_18074161.entity.Person;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Service
public class PersonServiceImpl implements PersonService{
    private PersonRepo personRepo;
    @Autowired
    public PersonServiceImpl(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }
    @Override
    public List<Person> getPersons() {
        return personRepo.findAll();
    }

    @Override
    public Person getPerson(int theId) {
         Optional<Person> result = personRepo.findById(theId);
        Person thePerson = null;
        if (result.isPresent()) {
           thePerson = result.get(); }
        else {
           throw new RuntimeException("Did not find employee id - " + theId);
        }
        return thePerson;
    }

    @Override
    public void savePerson(Person theEmployee) {
        personRepo.save(theEmployee);
    }

    @Override
    public void deletePerson(int theId) {
        personRepo.deleteById(theId);
    }
    
    
}
