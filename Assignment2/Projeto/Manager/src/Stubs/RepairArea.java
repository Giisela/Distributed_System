/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stubs;

import Communication.ClientCom;
import Communication.Message;
import Communication.MessageType;

import Interfaces.ManagerRepairArea;
import genclass.GenericIO;

/**
 * Repair Area stub. Class used to communicate with the Repair Area
 * using TCP communication channels.
 * @author giselapinto
 * @author danielmartins
 */
public class RepairArea implements ManagerRepairArea {

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
    public RepairArea(String server, int port) {
        this.server = server;
        this.port = port;
    }   
    
    /**
     * 
     * @param info the information about custumer
     * @param managerState the state of the manager
     */
    public void registerService(String info, String managerState){
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Manager register service");
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        } 
        Message msg = new Message(MessageType.REGISTER_SERVICE, info, managerState);
        com.writeObject(msg); 
        Message inMessage = (Message) com.readObject();
        if ( inMessage.getType() != MessageType.STATUS_OK ){
            GenericIO.writelnString("registerService - Manager thread was interrupted.");
            System.exit(1);                     
        }
        com.close();        
    }
    
    /**
     * Replace the pieces (RepairArea)
     * @param peca the piece who'll be stored
     * @param quantidade the quantity of that piece
     * @param managerState the state of the manager
     */
    public void storePart(String peca, int quantidade, String managerState){
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Manager store part");
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        } 
        Message msg = new Message(MessageType.STORE_PART, peca, quantidade, managerState);
        com.writeObject(msg); 
        Message inMessage = (Message) com.readObject();
        if ( inMessage.getType() != MessageType.STATUS_OK ){
            GenericIO.writelnString("storePart - Manager thread was interrupted.");
            System.exit(1);                     
        }
        com.close();          
    }
    
    /**
     * Role responsible for telling mechanics that work is over (RepairArea)
     */
    public void shutdownNow(String managerState){
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Manager alert to stop mechanics work");
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        } 
        Message msg = new Message(MessageType.SHUTDOWN, managerState);
        com.writeObject(msg); 
        Message inMessage = (Message) com.readObject();
        
        if ( inMessage.getType() != MessageType.STATUS_OK ){
            GenericIO.writelnString("shutdownNow - Manager thread was interrupted.");
            System.exit(1);                     
        }
        
        com.close();          
    }
}
