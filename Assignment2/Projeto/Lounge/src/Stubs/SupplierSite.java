/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stubs;

import Communication.ClientCom;
import Communication.Message;
import Communication.MessageType;

/**
 * Logger stub. Class used to communicate with the logger
 * using TCP communication channels.
 * @author danielmartins
 * @author giselapinto
 */
public class SupplierSite {
    
    /**
     * Name of the computational system where it is located the server.
     */
    private final String server;

    /**
     * Number of server listening port.
     */
    private final int port;
    
    /**
     *  Stub instatiation.
     *
     *    @param hostName Name of the computational system where it is located the server.
     *    @param port Number of server listening port.
     */
    public SupplierSite (String hostName, int port)
    {
        this.server = hostName;
        this.port = port;
    }    

    /**
     * Terminate the service.
     */
    public void serviceEnd(){
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {
            }
        }
        Message msg = new Message(MessageType.SERVICE_END);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close ();
    }    
}