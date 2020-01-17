/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stubs;

import Communication.ClientCom;
import Communication.Message;
import Communication.MessageType;
import Interfaces.MechanicsLounge;
import genclass.GenericIO;

/**
 * @author danielmartins
 * @author giselapinto
 */
public class Lounge implements MechanicsLounge {
    
    private String server;
    private int port;
    
    /**
     * Constructor from lounge
     * @param server server name
     * @param port port in use
     **/
    public Lounge(String server, int port) {
        this.server = server;
        this.port = port;
    }
    
     
    /**
    * Let manager know that the mechanics needs more pieces from supplier site
    * @param peca the piece
    * @param mechanic mechanic's id
    * @param mechanicState mechanic's state
    **/
    public void letManagerKnow(String peca, int mechanic, String mechanicState) {
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Mechanic let manager know");
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }    
        Message msg = new Message(MessageType.LET_MANAGER_KNOW, peca, mechanic, mechanicState);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();

    }
    
    /**
    * Notify the repair is concluded
    * @param currentCar id of current car
    * @param mechanic mechanic's id
    * @param mechanicState mechanic's state
    **/
    public void repairConcluded(int currentCar, int mechanic, String mechanicState) {
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Mechanic repair concluded");
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }    
        Message msg = new Message(MessageType.REPAIR_CONCLUDED, currentCar, mechanic, mechanicState);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
        
    }
    
    /**
     * Check if the piece has already been ordered
     * @param peca the piece
     * @return true or false, if the piece has already been ordered
     */
    public boolean checkRequest(String peca){
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Mechanic check request");
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }    
        Message msg = new Message(MessageType.CHECK_REQUEST, peca);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
        return inMessage.isBoolean1();
    }

    /**
     * Alert Lounge that the service is finish
     */
    public void serviceEnd(){
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Mechanic alerts that the job is finished");
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        } 
        Message msg = new Message(MessageType.SERVICE_END);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        if ( inMessage.getType() != MessageType.STATUS_OK ){
            GenericIO.writelnString("serviceEnd - Mechanic thread was interrupted.");
            System.exit(1);                     
        }            
        
        com.close();         
    }    
}
