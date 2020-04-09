package com.funda.backend.jpa.repositories;

import com.funda.backend.jpa.entities.Course;
import com.funda.backend.jpa.entities.Passport;
import com.funda.backend.jpa.entities.Student;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentRepository {

    @PersistenceContext
    EntityManager em;

    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    public Student save(Student student) {

        if (student.getId() == 0) {
            em.persist(student);
        } else {
            em.merge(student);
        }

        return student;
    }

    public void deleteById(Long id) {
        Student student = findById(id);
        em.remove(student);
    }

    public void saveStudentWithPassport() {
        Passport passport = new Passport("Z123456");
        em.persist(passport);

        Student student = new Student("Mike");

        student.setPassport(passport);
        em.persist(student);
    }

    public void someOperationToUnderstandPersistenceContext() {
        //Database Operation 1 - Retrieve student
        Student student = em.find(Student.class, 20001L);
        //Persistence Context (student)

        //Database Operation 2 - Retrieve passport
        Passport passport = student.getPassport();
        //Persistence Context (student, passport)

        //Database Operation 3 - update passport
        passport.setNumber("E123457");
        //Persistence Context (student, passport++)

        //Database Operation 4 - update student
        student.setName("Ranga - updated");
        //Persistence Context (student++ , passport++)
    }

    public void insertHardcodedStudentAndCourse() {
        Student student = new Student("Jack");
        Course course = new Course("Microservices in 100 Steps");
        em.persist(student);
        em.persist(course);

        student.addCourse(course);
        course.addStudent(student);
        em.persist(student);
    }

    public void insertStudentAndCourse() {
        Student studentFromDb = em.find(Student.class, 20009L);
        List<Student> students = em.createQuery("Select a From Student a",Student.class).getResultList();
        System.out.println("student is "+students.size());
        System.out.println("the course for student is "+studentFromDb.getCourses());
              
        //studentFromDb = new Student("Jack Reacher updated morning");
        Course course = studentFromDb.getCourses().get(0);
        course.setName(" dont know but updated");
//        Course course = new Course("Microservices in 100 Steps");
        studentFromDb.addCourse(course);
        
        //course.addStudent(studentFromDb);
        //merge no longer need added cascade persist , merge
        //em.merge(course);
        em.merge(studentFromDb);
        //em.persist(studentFromDb);
        System.out.println("the generated course id "+course.getId());
        Course courseFromDb = em.find(Course.class, 13L);
        System.out.println("the student for course is "+courseFromDb.getStudents().get(0).getName());
    }

}
