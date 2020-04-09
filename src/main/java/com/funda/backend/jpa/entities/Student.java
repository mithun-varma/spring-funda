/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.jpa.entities;

import java.io.Serializable;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author phanic
 */
@Entity
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "enroll_id")
    private String enrollementId;
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "guide_id")
    private Guide guide;

    @OneToOne(fetch = FetchType.LAZY)
    private Passport passport;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "STUDENT_COURSE",
            joinColumns = @JoinColumn(name = "STUDENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
    private List<Course> courses = new ArrayList<>();

    public Student() {
    }   

    public Student(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEnrollementId() {
        return enrollementId;
    }

    public void setEnrollementId(String enrollementId) {
        this.enrollementId = enrollementId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

}
