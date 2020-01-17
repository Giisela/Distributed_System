/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stubs;

import Communication.ClientCom;
import Communication.Message;
import Communication.MessageType;
import Interfaces.CustomerPark;
import genclass.GenericIO;


/**
 * @author danielmartins
 * @author giselapinto
 */
public class Park implements CustomerPark{
    
    /**
     * Name of the computational system where it is located the server.
     */
    private final String server;

    /**
     * Number of server listening port.
     */
    private final int port;
    

    public Park(String server, int port) {
        this.server = server;
        this.port = port;
    }
    
    /**
     * The customer park the car in the park.
     * In this state you can get in, 
     * customers who will repair a car, 
     * customers who will get the car after repair and who has a replacement car.
     * @param info customer's info
     * @param customerState customer's state
     */
    public void goToRepairShop(String info, String customerState) {
        
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Customer "+info+" go to repair shop");
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }
        
        Message msg = new Message(MessageType.GO_TO_REPAIR_SHOP, info, customerState);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        
        if ( inMessage.getType() != MessageType.STATUS_OK ){
            GenericIO.writelnString("goToRepairShop - Manager thread was interrupted.");
            System.exit(1);                     
        }        
        
        com.close ();
       
    }

    /**
     * Method used by the customer to search for a replacement car
     * Each customer will poll the list of replacement cars, and 
     * if there are no cars, they wait.
     * @param id customer's id
     * @param customerState customer's state
     * @return Each customer will poll the list of replacement cars, and 
     * if there are no cars, they wait.
     */
    public int findCar(int id, String customerState) {
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Customer "+id+" find car");
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }    
        Message msg = new Message(MessageType.FIND_CAR, id, customerState);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
        return inMessage.getInt1();
       
       
    }

    /**
     * Method to signal when a car is repaired, signaling the position 
     * with the index equal to the car id, with a value of 1.
     * @param info customer's info
     * @param customerState customer's state
     */
    public void collectCar( String info , String customerState ) {
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Customer "+info+" collect car");
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }    
        Message msg = new Message(MessageType.COLLECT_CAR, info, customerState);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        if ( inMessage.getType() != MessageType.STATUS_OK ){
            GenericIO.writelnString("collectCar - Manager thread was interrupted.");
            System.exit(1);                     
        }  
        com.close();
        
    }
}
