/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example._ThaiHuyHoang_18074161.controller;




import com.example._ThaiHuyHoang_18074161.entity.CreditCard;
import com.example._ThaiHuyHoang_18074161.entity.Person;
import com.example._ThaiHuyHoang_18074161.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping("/person")
public class PersonController {
    private PersonService personService;
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    
    @GetMapping("/list")
    public String listPerson(Model model){
        List<Person> list = personService.getPersons();
        model.addAttribute("persons", list);
        return "list-persons";
    }
    
    @GetMapping("/delete")
    public String deletePerson(@RequestParam("personId") int theId ){
        personService.deletePerson(theId);
        return "redirect:/person/list";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Person thePerson = new Person();
        model.addAttribute("person", thePerson);
        return "person-form";
    }
    
    @PostMapping("/savePerson")
    public String savePerson(@ModelAttribute("person") Person thePerson){
        List<CreditCard> cards=null;
        if (thePerson.getId() != 0) {
            Person tempPerson = personService.getPerson(thePerson.getId());
            cards = tempPerson.getCreditCards();
        }
        thePerson.setCreditCards(cards);
        personService.savePerson(thePerson);
        return "redirect:/person/list";
    }
    
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(Model model,
            @RequestParam("personId") int thePersonId){
        Person thePerson = personService.getPerson(thePersonId);
        model.addAttribute("person", thePerson);
        return "person-form";
    }
    
}
