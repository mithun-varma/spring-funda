/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.jpa.services;

import com.funda.backend.jpa.entities.Book;
import com.funda.backend.jpa.entities.Guide;
import com.funda.backend.jpa.entities.MyProduct;
import com.funda.backend.jpa.entities.Pen;
import com.funda.backend.jpa.entities.Student;
import java.util.List;
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
    public void testSingleTableInhertance(){
        
        try{
            
            EntityManager enitityManager = em.createEntityManager();
            EntityTransaction txn = enitityManager.getTransaction();
            
            txn.begin();
            
            Book book = new Book();
            book.setName(" my dairies");
            book.setAuthor("phani");

            Pen pen = new Pen();
            pen.setName("reynolds");
            pen.setColor("white");
            enitityManager.persist(book);
            enitityManager.persist(pen);
            
            txn.commit();
            List<Book> books = enitityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
            List products = enitityManager.createQuery("SELECT b FROM MyProduct b" ,MyProduct.class).getResultList();
            System.out.println("the books obj "+books.get(0).getAuthor()+" size "+products.size());

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
