/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example._ThaiHuyHoang_18074161.service;

import com.example._ThaiHuyHoang_18074161.entity.CreditCard;



/**
 *
 * @author Admin
 */
public interface CreditCardService {
    public CreditCard getCreditCard(int creditCardId);
    public void saveCreditCard(CreditCard theCard, int personId);
    public void updateCreditCard(CreditCard theCard, int personId);
    public void deleteCreditCard(int creditCardId);
    
}
