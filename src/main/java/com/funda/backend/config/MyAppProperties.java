/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.config;


public class MyAppProperties {
  private boolean exitOnErrors;
  private String tradeStartDate;

    public boolean isExitOnErrors() {
        return exitOnErrors;
    }

    public void setExitOnErrors(boolean exitOnErrors) {
        this.exitOnErrors = exitOnErrors;
    }

    public String getTradeStartDate() {
        return tradeStartDate;
    }

    public void setTradeStartDate(String tradeStartDate) {
        this.tradeStartDate = tradeStartDate;
    }
  
  
}
