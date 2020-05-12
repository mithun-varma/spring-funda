/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.taskexecutors;

import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 *
 * @author phanic
 */
public class MyListenableFutureCallback implements ListenableFutureCallback<String>{

    @Override
    public void onSuccess(String t) {
        System.out.println("success object: " + t);
    }

    @Override
    public void onFailure(Throwable thrwbl) {
        thrwbl.printStackTrace();
    }
    
}
