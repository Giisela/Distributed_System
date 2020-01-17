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
import Interfaces.ManagerLounge;

/**
 * Lounge stub. Class used to communicate with the Lounge
 * using TCP communication channels.
 * @author giselapinto
 * @author danielmartins
 */
public class Lounge implements ManagerLounge {

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
     * Send a message with the state of the manager, and waits when the queues aren't empty
     * @param managerState , the state of the manager 
     */
    public boolean getNextTask(String managerState){
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Manager get next task");
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }
        
        Message msg = new Message(MessageType.GET_NEXT_TASK, managerState);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        
        if ( inMessage.getType() != MessageType.STATUS_OK ){
            GenericIO.writelnString("getNextTask - Manager thread was interrupted.");
            System.exit(1);                     
        }        
        
        com.close ();
        return true;
    }
    
    /**
     * Choose what is the new task (Lounge)
     * @return the service chosen 
     */
    public String appraiseSit(){
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Manager apraise sit");
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }    
        Message msg = new Message(MessageType.APRAISE_SIT);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
        return inMessage.getStr1();
    }
    
    /**
     * Talk to Customer (Lounge)
     * @param info the information about customer
     * @param managerState the state of the manager
     */
    public void talkToCustomer(String info, String managerState){
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Manager talk to customer "+info);
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        } 
        Message msg = new Message(MessageType.TALK_TO_CUSTOMER, info, managerState);
        com.writeObject(msg); 
        Message inMessage = (Message) com.readObject();
        if ( inMessage.getType() != MessageType.STATUS_OK ){
            GenericIO.writelnString("talkToCustomer - Manager thread was interrupted.");
            System.exit(1);                     
        }
        com.close();                        
    }
    
    /**
     * Receive Payment (Lounge)
     * @param info the information about customer     
     */
    public void receivePayment(String info){
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Manager receive payment");
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        } 
        Message msg = new Message(MessageType.RECEIVE_PAYMENT, info);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        
        if ( inMessage.getType() != MessageType.STATUS_OK ){
            GenericIO.writelnString("receivePayment - Manager thread was interrupted.");
            System.exit(1);                     
        }            
        
        com.close();        
    }
    
    /**
     * Hand Car Key (Lounge)
     * @param info the information about customer     
     */
    public void handCarKey(String info){
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Manager hand car key");
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        } 
        Message msg = new Message(MessageType.HAND_CAR_KEY, info);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        
        if ( inMessage.getType() != MessageType.STATUS_OK ){
            GenericIO.writelnString("handCarKey - Manager thread was interrupted.");
            System.exit(1);                     
        }            
        
        com.close();           
    }

    /**
     * Alert Lounge that the service is finish
     */
    public void serviceEnd(){
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Manager end service");
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        } 
        Message msg = new Message(MessageType.SERVICE_END);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        if ( inMessage.getType() != MessageType.STATUS_OK ){
            GenericIO.writelnString("serviceEnd - Manager thread was interrupted.");
            System.exit(1);                     
        }            
        
        com.close();         
    }
}
