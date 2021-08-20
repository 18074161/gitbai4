/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example._ThaiHuyHoang_18074161.dao;

import com.example._ThaiHuyHoang_18074161.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;




/**
 *
 * @author Admin
 */
public interface CreditCardRepo extends JpaRepository<CreditCard, Integer>{
    
}
