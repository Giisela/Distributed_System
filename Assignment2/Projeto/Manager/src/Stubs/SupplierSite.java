/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stubs;

import Communication.ClientCom;
import Communication.Message;
import Communication.MessageType;

import Interfaces.ManagerSupplierSite;
import genclass.GenericIO;

/**
 * Supplier Site stub. Class used to communicate with the Supplier Site
 * using TCP communication channels.
 * @author giselapinto
 * @author danielmartins
 */
public class SupplierSite implements ManagerSupplierSite {

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
    public SupplierSite(String server, int port) {
        this.server = server;
        this.port = port;
    }   
    
    /**
    * send message to go to supplier
    * @param peca piece in need
    * @param managerState current state of manager
    * @return number of pieces
    **/
    public int goToSupplier(String peca, String managerState){
        ClientCom com = new ClientCom (server, port);
        GenericIO.writelnString("Manager go to supplier");
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }    
        Message msg = new Message(MessageType.GO_TO_SUPPLIER,peca,managerState);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();

        if ( inMessage.getType() != MessageType.RETURN_GO_TO_SUPPLIER ){
            GenericIO.writelnString("goToSupplier - Manager thread was interrupted.");
            System.exit(1);                     
        }

        return inMessage.getInt1();
    }    
}
