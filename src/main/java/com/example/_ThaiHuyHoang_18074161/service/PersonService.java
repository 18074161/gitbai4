/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example._ThaiHuyHoang_18074161.service;

import com.example._ThaiHuyHoang_18074161.entity.Person;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface PersonService {
    public List<Person> getPersons();
    public Person getPerson(int theId);
    public void savePerson(Person thePerson);
    public void deletePerson(int theId); 
}
