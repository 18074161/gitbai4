/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example._ThaiHuyHoang_18074161.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Admin
 */
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private float money;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    List<CreditCard> creditCards;

    public Person(int id, String firstName, String lastNmae, float money, List<CreditCard> creditCards) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastNmae;
        this.money = money;
        this.creditCards = creditCards;
    }
    

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }
    
    public CreditCard getCreeditCard(int theId){
        if (creditCards != null) {
            for (CreditCard cc : creditCards) {
                if (cc.getId() == theId) {
                    return cc;
                }
            }
        }
        return null;
        
    }
    public void addCreditCard(CreditCard cc){
        if (creditCards == null) {
            creditCards = new ArrayList<>();
        }
        creditCards.add(cc);
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", money=" + money + ", creditCards=" + creditCards + '}';
    }
    
    
    
}
