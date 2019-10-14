/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.jpa.repositories;

import com.funda.backend.jpa.entities.Todo;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 91984
 */
@Repository
interface TodoRepository extends CommonBaseRepository<Todo, Long> {
 
}
