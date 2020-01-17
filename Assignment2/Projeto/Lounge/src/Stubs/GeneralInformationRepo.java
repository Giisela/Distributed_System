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
public class GeneralInformationRepo {
    
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
    public GeneralInformationRepo (String hostName, int port)
    {
        this.server = hostName;
        this.port = port;
    }    

    /**
     * Update the state of the manager
     * @param managerState the state of the manager
     */
    public void setManagerState(String managerState) {
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {
            }
        }
        Message msg = new Message(MessageType.SET_MANAGER_STATE, managerState);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close ();    
    }

    /**
     * Update the state of the customer
     * @param customer the id of the customer
     * @param customerState the state of the customer
     */  
    public void setCustomerState(int customer, String customerState) {
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {
            }
        }
        Message msg = new Message(MessageType.SET_CUSTOMER_STATE, customer, customerState);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close ();  
    }

    /**
     * Update the size of the queue
     * @param size the size of the queue in repair Area
     */
    public void setValueQueueIn(int size) {
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {
            }
        }
        Message msg = new Message(MessageType.SET_SIZE_QUEUE, size);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close (); 
    }

    /**
     * Update the state of the mechanic
     * @param mechanic the id of the mechanic
     * @param mechanicState the state of the mechanic
     */
    public void setMechanicState(int mechanic, String mechanicState) {
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }
        Message msg = new Message(MessageType.SET_MECHANIC_STATE, mechanic, mechanicState);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close (); 
    }

    /**
     * Warning of no C-type parts
     * @param peca piece's type
     */    
    public void setFlagAPieces(String peca) {
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }
        Message msg = new Message(MessageType.SET_FLAG_A, peca);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close (); 
    }

    /**
     * Warning of no C-type parts
     * @param peca piece's type
     */
    public void setFlagBPieces(String peca) {
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }
        Message msg = new Message(MessageType.SET_FLAG_B, peca);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close ();     }

    /**
     * Warning of no C-type parts
     * @param peca piece's type
     */
    public void setFlagCPieces(String peca) {
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }
        Message msg = new Message(MessageType.SET_FLAG_C, peca);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close ();     
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

    /**
     * Update the current car of the customer
     * @param parseInt customer's id
     * @param info customer's info
     */
    public void setOwnCar(int parseInt, String info) {
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {
            }
        }
        Message msg = new Message(MessageType.SET_OWN_CAR, parseInt, info);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close ();   
    }
}

