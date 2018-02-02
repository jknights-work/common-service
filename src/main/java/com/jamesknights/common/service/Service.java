/*
 *  File: Service.java
    Author: James Knights
    Date: 15th January 2018

    The initial version
 */
package com.jamesknights.common.service;

/**
 * This interface describes the common components of any service
 * this is implemented by classes that provide a service
 */
public interface Service {
    
    String getName();
    
    void start();
    
    void stop();
    
    boolean isRunning();
    
    ServiceState getState();
    
}
