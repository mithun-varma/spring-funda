/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.jpa.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@NamedQueries(value = {
    @NamedQuery(name = "query_get_all_courses",
            query = "Select  c  From Course c"),
    @NamedQuery(name = "query_get_100_Step_courses",
            query = "Select  c  From Course c where name like '%100 Steps'")})

public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

    @UpdateTimestamp
    @Column(name="last_updated_date")
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    @Column(name="created_date")
    private LocalDateTime createdDate;

    protected Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void removeReview(Review review) {
        this.reviews.remove(review);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Course[%s]", name);
    }
}
