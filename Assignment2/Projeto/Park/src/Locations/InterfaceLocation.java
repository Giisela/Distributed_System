/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locations;

import Communication.Message;

/**
 * This interface represents a location interface
 * It has a method to process and reply messages.
 * @author danielmartins
 * @author giselapinto
 */
public interface InterfaceLocation {
    /**
     * Process and reply a message
     * @param inMessage message to be processed
     * @return message to be replied
     */
    public Message processAndReply(Message inMessage);    
}
