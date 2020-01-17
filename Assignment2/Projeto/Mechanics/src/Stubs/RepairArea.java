/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stubs;

import Communication.ClientCom;
import Communication.Message;
import Communication.MessageType;
import Interfaces.MechanicsRepairArea;
import genclass.GenericIO;
/**
 * @author danielmartins
 * @author giselapinto
 */
public class RepairArea implements MechanicsRepairArea {
    
    private String server;
    private int port;
    
    /**
     * Constructor from lounge
     * @param server server name
     * @param port port in use
     **/
    public RepairArea(String server, int port) {
        this.server = server;
        this.port = port;
    }
    
    /**
     * send message with the state of Mechanic
     * @param mechanic id of Mechanic
     * @param mechanicState current state of Mechanic
     * @return the service
     **/
    public String readThePaper(int mechanic, String mechanicState) {
    
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Mechanic read paper");
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }    
        Message msg = new Message(MessageType.READ_THE_PAPER, mechanic, mechanicState);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
        if ( inMessage.getType() != MessageType.RETURN_READ_THE_PAPER ){
            GenericIO.writelnString("readThePaper - Manager thread was interrupted.");
            System.exit(1);                     
        }
        
        return inMessage.getStr1();
    }


    /**
     * send message informing that they start Repair Procedure
     * @param mechanic id of Mechanic
     * @param mechanicState current state of Mechanic
     **/
    public void startRepairProcedure(int mechanic, String mechanicState) {
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Mechanic start repair procedure");
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }    
        Message msg = new Message(MessageType.START_REPAIR_PROCEDURE, mechanic, mechanicState);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
        
    }
    
     /**
     * send message informing that they start fix the car
     **/
    public void fixIt(){
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Mechanic fix it");
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }    
        Message msg = new Message(MessageType.FIX_IT);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
    }

    /**
    * send message informing that they need parts
    * @param mechanic id of Mechanic
    * @param mechanicState current state of Mechanic
    * @return required part
    **/
    public String getRequiredPart(int mechanic, String mechanicState) {       
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Mechanic get required part");
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }    
        Message msg = new Message(MessageType.GET_REQUIRED_PART, mechanic, mechanicState);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
        
        return inMessage.getStr1();
    }

    /**
    * Check the part that is available
    * @param piece piece that are in need
    * @param car car id that needs the part
    * @return true or false, if mechanics has parts with him or not
    **/
    public boolean partAvailable(String piece, int car) {       
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Mechanic part available");
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }    
        Message msg = new Message(MessageType.PART_AVAILABLE, car, piece);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
        return inMessage.isBoolean1();
    }
    
   /**
    * send message with resume repair
    * @param piece piece that are in need
    * @param mechanic id of mechanic
    * @param mechanicState current state of mechanic
    **/
    public void resumeRepairProcedure(String piece, int mechanic, String mechanicState) {
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Mechanic resume repair procedure");
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }    
        Message msg = new Message(MessageType.RESUME_REPAIR_PROCEDURE, piece, mechanic, mechanicState);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
       
    }
}
