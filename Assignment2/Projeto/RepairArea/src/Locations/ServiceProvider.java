/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locations;

import Communication.Message;
import Communication.ServerComm;

/**
 * Service Provider implementation.
 * Processes and replies messages accordingly to the internal implementation
 * of a shared region.
 * @author danielmartins
 * @author giselapinto
 */
public class ServiceProvider extends Thread {
    
    /**
     * Communication channel with the server.
     **/
    private final ServerComm com;
    
    /**
     * Shared region implementation.
     **/
    private final InterfaceLocation il;
    
    /**
     * Service Provider constructor.
     * @param com communication channel with the server.
     * @param il shared region.
     **/
    public ServiceProvider(ServerComm com, InterfaceLocation il){
        this.com = com;
        this.il = il;
    }
    
    /**
     * Lifecycle of the service provider.
     **/
    @Override
    public void run(){
        /**
         * Read object from the communication channel.
         */
        Message inMessage = (Message) com.readObject();
        
        /**
         * Process and reply request.
         */
        Message outMessage = il.processAndReply(inMessage);
        /**
         * Send reply and close communication channel.
         */
        com.writeObject(outMessage);
        com.close();
    }
}
