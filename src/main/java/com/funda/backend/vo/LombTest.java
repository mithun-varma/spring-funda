/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.vo;

import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 *
 * @author phanic
 */
@RequiredArgsConstructor
@Accessors(fluent = true) @Getter
public class LombTest {
 
    private final @NonNull Instant loginTs;
 
    private final @NonNull String authToken;
    private final @NonNull Duration tokenValidity;
     
    private final @NonNull URL tokenRefreshUrl;
    
    private @Setter String dumbProperty;
 
}
