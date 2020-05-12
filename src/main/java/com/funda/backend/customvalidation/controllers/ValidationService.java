/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.customvalidation.controllers;

import java.time.LocalDateTime;
import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 *
 * @author phanic
 */

@Validated
@Component
public class ValidationService {
    
  public @Pattern(regexp = "[0-3]") String createReport(@NotNull @Size(min = 3, max = 20) String name,
                                                        @NotNull @FutureOrPresent LocalDateTime startDate) {
      return "-1";
  }
  
   public void registerUser(@NotNull @Valid UserVo user){
      System.out.println("registering user: "+ user);
  }
}
