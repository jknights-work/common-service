/*
 *  File: ServiceState.java
    Author: James Knights
    Date: 15th January 2018

    The initial version
 */
package com.jamesknights.common.service;

/**
 * This class describes the state of a service
 * @author James Knights <james@i-studio.co.uk>
 */
public final class ServiceState {
    
    static final String[] DESCRIPTIONS = {"Started", "Stopped", "Failed"};
    public static final ServiceState STARTED = new ServiceState(0);
    public static final ServiceState STOPPED = new ServiceState(1);
    public static final ServiceState FAILED = new ServiceState(2);
    private int stateId;
    
    ServiceState (int id) {
        stateId = id;
    }
    
    public int getInt () {
        return stateId;
    }
    
    public void setInt (int newInt) {
        stateId = newInt;
    }
    
    public String getDescription () {
        return DESCRIPTIONS[stateId];
    }
    
}
