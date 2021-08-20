/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example._ThaiHuyHoang_18074161.service;


import com.example._ThaiHuyHoang_18074161.dao.CreditCardRepo;
import com.example._ThaiHuyHoang_18074161.entity.CreditCard;
import com.example._ThaiHuyHoang_18074161.entity.Person;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Service
public class CreditCardServiceImpl implements CreditCardService{
    private CreditCardRepo cardRepo;
    private PersonService personService;
    @Autowired
    public CreditCardServiceImpl(CreditCardRepo cardRepo, PersonService personService) {
        this.cardRepo = cardRepo;
        this.personService = personService;
    }

    @Override
    public CreditCard getCreditCard(int creditCardId) {
        Optional<CreditCard> result = cardRepo.findById(creditCardId);
        CreditCard thePerson = null;
        if (result.isPresent()) {
           thePerson = result.get(); }
        else {
           throw new RuntimeException("Did not find employee id - " + creditCardId);
        }
        return thePerson;
    }
    @Override
    public void saveCreditCard(CreditCard theCard, int personId) {
        Person person = personService.getPerson(personId);
        person.addCreditCard(theCard);
        cardRepo.save(theCard);
    }
    @Override
    public void updateCreditCard(CreditCard theCard, int personId) {
        Person person = personService.getPerson(personId);
        CreditCard tempCard = person.getCreeditCard(theCard.getId());
        setValueCreditCard(tempCard, theCard);
        cardRepo.save(tempCard);
    }
    @Override
    public void deleteCreditCard(int creditCardId) {
        cardRepo.deleteById(creditCardId);
    }
    private void setValueCreditCard(CreditCard tempCard, CreditCard theCard)
    {
        tempCard.setNumber(theCard.getNumber());
        tempCard.setType(theCard.getType());
    }
    
}
