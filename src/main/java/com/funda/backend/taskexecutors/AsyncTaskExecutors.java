/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.taskexecutors;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncListenableTaskExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author phanic
 */

@RestController
public class AsyncTaskExecutors {
    
    @Autowired
    private AsyncListenableTaskExecutor executor;
    @Autowired
    private ListenableFutureCallback threadListenableCallback;
    
    
    @GetMapping("/asyncTaskCallback")
    void asyncTaskCallback() {
        try {
            runTasks();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    

    private void runTasks () throws Exception {
        for (int i = 0; i < 10; i++) {
            ListenableFuture<String> f = executor.submitListenable(getTask(i));
            f.addCallback(threadListenableCallback);
        }
    }

    private Callable<String> getTask (int i) {
        return () -> {
            System.out.printf("running task %d. Thread: %s%n",
                              i,
                              Thread.currentThread().getName());
            return String.format("Task finished %d", i);
        };
    }
}
