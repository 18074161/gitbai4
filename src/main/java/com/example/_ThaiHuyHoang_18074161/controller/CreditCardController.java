/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example._ThaiHuyHoang_18074161.controller;

import com.example._ThaiHuyHoang_18074161.entity.CreditCard;
import com.example._ThaiHuyHoang_18074161.entity.Person;
import com.example._ThaiHuyHoang_18074161.service.CreditCardService;
import com.example._ThaiHuyHoang_18074161.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/creditcard")
public class CreditCardController {
    private PersonService personService;
    private CreditCardService cardService;
    
    public CreditCardController(PersonService personService, CreditCardService cardService) {
        this.personService = personService;
        this.cardService = cardService;
    }
    @GetMapping("/list")
    public String listCC(@RequestParam("personId") int thePersonId,
            Model model){
        Person thePerson = personService.getPerson(thePersonId);
        model.addAttribute("person",thePerson);
        return "list-cardview";
    }
    @GetMapping("/delete")
    public String deleteCC(@RequestParam("ccId") int theid,
            @RequestParam("personId") int thePersonId,
            Model model){
        cardService.deleteCreditCard(theid);
        Person thePerson = personService.getPerson(thePersonId);
        model.addAttribute("person",thePerson);
        return  "list-cardview";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel, @RequestParam("personId") int personId) {
        // create model attribute to bind form data
        CreditCard theCard = new CreditCard();
        theModel.addAttribute("creditCardAttribute", theCard);
        theModel.addAttribute("personId", personId);
        theModel.addAttribute("isUpdate", false);
        return "credit-form";  }
    @PostMapping("/saveCard")
    public String saveCreditCard(@ModelAttribute("creditCardAttribute") CreditCard theCard, 
            @RequestParam("personId") int personId,Model theModel) {
        // save the customer using our service
        cardService.saveCreditCard(theCard, personId);
         Person thePerson = personService.getPerson(personId);
         theModel.addAttribute("person",thePerson);
        return "list-cardview";
    }
    @GetMapping("/showFormForUpdate")
   public String showFormForUpdate( @RequestParam("personId") int personId,
           @RequestParam("creditCardId") int creditCardId,
           Model theModel) {
        CreditCard theCreditCard = cardService.getCreditCard(creditCardId);
        theModel.addAttribute("creditCardAttribute", theCreditCard);
         theModel.addAttribute("personId", personId);
        theModel.addAttribute("isUpdate", true);
        return "credit-form";    }  
   @PostMapping("/updateCard")
    public String updateCreditCard(@ModelAttribute("creditCardAttribute") CreditCard theCard,
            @RequestParam("personId") int personId,Model theModel)
    {
        cardService.updateCreditCard(theCard, personId);
        Person thePerson = personService.getPerson(personId);
         theModel.addAttribute("person",thePerson);
        return "list-cardview";
    }
}
