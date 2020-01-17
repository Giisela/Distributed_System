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

    public void setAlreadyRepaired(int car, int[] repairedCars) {
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {
            }
        }
        Message msg = new Message(MessageType.SET_ALREADY_REPAIRED, car, repairedCars);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close ();         
    }

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
     * Updating number of customer waiting for a replacement vehicle
     * @param wait number of replacement car
     */
    public void setNumberWaitingReplece(int wait) {
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {
            }
        }
        Message msg = new Message(MessageType.SET_WAITING_CARS, wait);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close ();          
    }
    
    
    /**
     * Updating number of cars that have already been repaired
     * @param numberRepair number of cars repaired
     */
    public void setNumberRepair(int numberRepair) {
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {
            }
        }
        Message msg = new Message(MessageType.SET_NUMBER_REPAIR, numberRepair);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close (); 
    }
    
    
    /**
     * update number of customer vehicles presently parked at the repair shop park
     * @param numberParkCars number of cars in the park
     */
    public void setNumberParkCars(int numberParkCars) {
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {
            }
        }
        Message msg = new Message(MessageType.SET_NUMBER_PARKED_CARS, numberParkCars);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close (); 
    }
    
    /**
     * Update number of replacement vehicles presently parked at the repair shop park
     * @param numberReplacementPark number of replacement cars in the park
     */
    public void setNumberReplacementPark(int numberReplacementPark) {
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {
            }
        }
        Message msg = new Message(MessageType.SET_NUMBER_REPLACEMENT_CAR_PARKED, numberReplacementPark);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close (); 
    }
}
