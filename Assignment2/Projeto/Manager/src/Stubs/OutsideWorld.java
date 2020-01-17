/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stubs;


import Communication.ClientCom;
import Communication.Message;
import Communication.MessageType;
import Interfaces.ManagerOutsideWorld;
import genclass.GenericIO;


/**
 * Outside World stub. Class used to communicate with the Outside World
 * using TCP communication channels.
 * @author giselapinto
 * @author danielmartins
 */
public class OutsideWorld implements ManagerOutsideWorld {

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
     *    @param server Name of the computational system where it is located the server.
     *    @param port Number of server listening port.
     */    
    public OutsideWorld(String server, int port) {
        this.server = server;
        this.port = port;
    }
    
    /**
     * The manager calls the customer to advise that the car is ready
     * @param info the information about customer
     * @param managerState the state of the manager
     */
    public void phoneCustomer(String info, String managerState){
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Manager phone customer "+info);
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        } 
        Message msg = new Message(MessageType.PHONE_CUSTOMER, info, managerState);
        com.writeObject(msg); 
        Message inMessage = (Message) com.readObject();
        
        if ( inMessage.getType() != MessageType.STATUS_OK ){
            GenericIO.writelnString("phoneCustomer - Manager thread was interrupted.");
            System.exit(1);                     
        }
        com.close();           
    }  
}
