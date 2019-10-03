/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.hibernate.services;

import com.funda.backend.hibernate.entities.Guide;
import com.funda.backend.hibernate.entities.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author phanic
 */
@Service
@Transactional
public class JPAService {
    
    //@PersistenceContext
    //private EntityManager em;
    
    @PersistenceUnit
    private EntityManagerFactory em;
    
    public void saveStudentAndGuide(){
        
        try{
            
            EntityManager enitityManager = em.createEntityManager();
            EntityTransaction txn = enitityManager.getTransaction();
            
            txn.begin();
            
            Student student = new Student();
            student.setName("phani");
            student.setEnrollementId("131");
            
            Guide guide = new Guide();
            guide.setName("ramarao");
            guide.setSalary("5000");
            
            student.setGuide(guide);
            //em.persist(student);
            enitityManager.persist(student);
            txn.commit();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
