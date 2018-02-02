/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jamesknights.common.service;

import java.io.Serializable;

/**
 *
 * @author James Knights <james@i-studio.co.uk>
 */
public class ServiceException extends RuntimeException implements Serializable {

    public ServiceException(String message) {
        super(message);
    }

}
