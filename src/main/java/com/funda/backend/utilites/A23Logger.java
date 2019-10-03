/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.utilites;

import org.apache.log4j.Logger;

/**
 *
 * @author phanic
 */
public class A23Logger {
    
    private static final Logger LOGGER = Logger.getLogger(A23Logger.class);

    public static class LogBuilder {
        
        private Exception ex;
        private String logBuilder;
        
        private LogBuilder(Class<?> className,String method){
            this.logBuilder = " CLASS  "+className+" METHOD "+method;
        }
        
        public LogBuilder defaultBuilder(Class<?> className,String method){
            LogBuilder builder = new LogBuilder(className, method);
            return builder;
        }
        
        public LogBuilder userId(String userid){
            this.logBuilder = this.logBuilder+" USER ID "+userid;
            return this;
        }
        
        public LogBuilder userCode(String userCode){
            this.logBuilder = this.logBuilder+" USERCODE "+userCode;
            return this;
        }
        
        public LogBuilder txnId(String txnId){
            this.logBuilder = this.logBuilder+" TXN ID "+txnId;
            return this;
        }
        
        public LogBuilder id(String id){
            this.logBuilder = this.logBuilder+" ID "+id;
            return this;
        }
        
        public LogBuilder Exception(Exception ex){
            this.ex = ex;
            if(ex != null){
                this.logBuilder = this.logBuilder+" ex message "+ex.getMessage();
            }
            return this;
        }
        
        public void build(String loggerLevel) {
            try{
                if("info".equalsIgnoreCase(loggerLevel)){
                    LOGGER.info(this.logBuilder);
                }else if("errror".equalsIgnoreCase(loggerLevel)){
                    LOGGER.error(this.logBuilder,ex);
                }
            }catch(Exception e){
                LOGGER.error(" Exception while generating logs ",e);
            }
        } 
    }
}
