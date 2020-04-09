//package com.funda.backend.tests;
//
//import com.funda.backend.DemoApplication;
//import com.funda.backend.config.H2DBConfig;
//import com.funda.backend.config.MysqlDBConfig;
//import com.funda.backend.jpa.entities.Passport;
//import com.funda.backend.jpa.entities.Student;
//import com.funda.backend.jpa.repositories.StudentRepository;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {DemoApplication.class})
//public class StudentRepositoryTest {
//
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    StudentRepository repository;
//
//    @PersistenceContext
//    EntityManager em;
//
//    // Session & Session Factory
//    // EntityManager & Persistence Context
//    // Transaction
//    @Test
//    public void someTest() {
//        repository.someOperationToUnderstandPersistenceContext();
//    }
//
//    @Test
//    @Transactional
//    public void retrieveStudentAndPassportDetails() {
//        Student student = em.find(Student.class, 20001L);
//        logger.info("student -> {}", student);
//        logger.info("passport -> {}", student.getPassport());
//    }
//
//    @Test
//    @Transactional
//    public void retrievePassportAndAssociatedStudent() {
//        Passport passport = em.find(Passport.class, 40001L);
//        logger.info("passport -> {}", passport);
//        logger.info("student -> {}", passport.getStudent());
//    }
//
//    @Test
//    @Transactional
//    public void retrieveStudentAndCourses() {
//        Student student = em.find(Student.class, 20001L);
//
//        logger.info("student -> {}", student);
//        logger.info("courses -> {}", student.getCourses());
//    }
//
//}
