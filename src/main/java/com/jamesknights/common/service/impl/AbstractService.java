/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jamesknights.common.service.impl;

import com.jamesknights.common.service.Service;
import com.jamesknights.common.service.ServiceState;
import org.apache.log4j.Logger;

/**
 *
 * @author James Knights <james@i-studio.co.uk>
 */
public abstract class AbstractService implements Service {
    
    private static final Logger LOG = Logger.getLogger(AbstractService.class);
    private String name;
    private volatile ServiceState state;
    private boolean isRunning;

    public AbstractService(String newName) {
        if (newName.isEmpty()) {
            throw new IllegalArgumentException("Cannot start a service without a name!");
        }
        
        this.name = newName;
        this.state = ServiceState.STOPPED;
    }
    
    @Override
    public final synchronized void start() {
        if (this.state != ServiceState.STOPPED) {
            LOG.error("Service" + name + "has not been stopped, but trying to start");
            throw new UnsupportedOperationException("Unable to start");
        } else {
            this.state = ServiceState.STARTED;
            this.state.setInt(0);
            this.isRunning = true;
        }
    }
    
    @Override
    public final synchronized void stop() {
        if (this.state != ServiceState.STARTED) {
            LOG.error("Service" + name + "has not been started, but trying to stop");
            throw new UnsupportedOperationException("Unable to stop! " + this.state.getDescription());
        } else {
            this.state.setInt(1);
            this.state = ServiceState.STOPPED;
            this.isRunning = false;
        }
    }
    
    @Override
    public boolean isRunning() {
        return this.isRunning;
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public ServiceState getState() {
        return this.state;
    }
    
    
}
