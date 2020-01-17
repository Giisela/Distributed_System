/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stubs;

import genclass.GenericIO;
import Communication.ClientCom;
import Communication.Message;
import Communication.MessageType;
import Interfaces.CustomerLounge;

/**
 * Lounge stub. Class used to communicate with the Lounge
 * using TCP communication channels.
 * @author giselapinto
 * @author danielmartins
 */
public class Lounge implements CustomerLounge {

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
    public Lounge(String server, int port) {
        this.server = server;
        this.port = port;
    }
    
    
    /**
     * The costumer go into the Lounge and waits for his turn
     * @param id customer's id
     * @param customerState customer's state
     */
    public void queueIn(String id, String customerState){
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Customer "+id+" queueIn");
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        } 
        Message msg = new Message(MessageType.QUEUE_IN, id, customerState);
        com.writeObject(msg);
        //GenericIO.writelnString("Find car "+id+" send Message");
        Message inMessage = (Message) com.readObject();
        if ( inMessage.getType() != MessageType.STATUS_OK ){
            GenericIO.writelnString("queueIn - Customer thread was interrupted.");
            System.exit(1);                     
        }
        //GenericIO.writelnString("Find car "+id+" receive Message - "+inMessage.getType());            
        com.close();  
    
    }
    
    /**
     * In theoretical terms, the client spends some time talking to the manager.
     * In practical terms, it is a synchronization point where the client updates the "talkBetweenManCust" 
     * variable to false if that client is the client that the manager initiated a conversation.
     * If the variable is already false, it means that the manager has not started a conversation 
     * yet and therefore expects the manager to respond.
     * @param customer customer's id
     */
    public void talkWithManager(int customer){
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Customer "+customer+" talk with manager");
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        } 
        Message msg = new Message(MessageType.TALK_WITH_MANAGER, customer);
        com.writeObject(msg);
      
        Message inMessage = (Message) com.readObject();
        if ( inMessage.getType() != MessageType.STATUS_OK ){
            GenericIO.writelnString("talkWithManager - Customer thread was interrupted.");
            System.exit(1);                     
        }

        com.close();    
    }
    
    /**
     * Synchronization point.
     * In theoretical terms, you will receive the key to the replacement car.
     * In practical terms, synchronization will only be done using the key variable.
     * @param customer customer's id
     * @param customerState customer's state
     */
    
    public void collectKey(int customer, String customerState){
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Customer "+customer+" collectKey");
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        } 
        Message msg = new Message(MessageType.COLLECT_KEY, customer, customerState);
        com.writeObject(msg);
        //GenericIO.writelnString("collectkey "+customer+" send Message");
        Message inMessage = (Message) com.readObject();
        if ( inMessage.getType() != MessageType.STATUS_OK ){
            GenericIO.writelnString("collectKey - Customer thread was interrupted.");
            System.exit(1);                     
        }            
        //GenericIO.writelnString("collectKey "+customer+" receice Message - "+inMessage.getType()); 
        com.close();    
    }

    /**
     * In theoretical terms will effect the payment.
     * In practical terms, it is just a state of transition.
     * @param customer customer's id
     */
    public void payForTheService(int customer){
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Customer "+customer+" pay for the service");
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        } 
        Message msg = new Message(MessageType.PAY_FOR_THE_SERVICE, customer);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();

        if ( inMessage.getType() != MessageType.STATUS_OK ){
            GenericIO.writelnString("payForTheService - Customer thread was interrupted.");
            System.exit(1);                     
        }            
        
        com.close();    
    
    }

    /**
     * Alert Lounge that the service is finish
     */
    public void serviceEnd(){
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Client serviceEnd");
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        } 
        Message msg = new Message(MessageType.SERVICE_END);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        
        if ( inMessage.getType() != MessageType.STATUS_OK ){
            GenericIO.writelnString("serviceEnd - Customer thread was interrupted.");
            System.exit(1);                     
        }            
        
        com.close();         
    }    

}
