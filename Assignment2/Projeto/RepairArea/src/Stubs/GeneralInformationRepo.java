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
     * Update the number of service requested
     * @param size number of service
     **/
    public void setNumberServiceRequest(int size) {
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }
        Message msg = new Message(MessageType.SET_SERVICE, size);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close ();      
    }
    
    /**
     * Update of Avaible pieces
     * @param piece number of pieces
     * @param numberOfCustomersWaiting number of customer waiting for a piece
     **/
    public void setPiecesAvabal(String piece, int numberOfCustomersWaiting) {
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }
        Message msg = new Message(MessageType.SET_PIECE_AVAILABLE,numberOfCustomersWaiting, piece);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close ();  
    }
    
    /**
     * Update of Stored Pieces 0
     * @param pieceA number of pieces stored
     **/
    public void setPieces0Stored(int pieceA) {
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }
        Message msg = new Message(MessageType.PIECES_A_STORED, pieceA);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close ();      
    }
    
   /**
    * Update of Stored Pieces 1
    * @param pieceB number of pieces stored
    **/
    public void setPieces1Stored(int pieceB) {
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }
        Message msg = new Message(MessageType.PIECES_B_STORED, pieceB);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close ();  
    }
    
    /**
     * Update of Stored Pieces 2
     * @param pieceC number of pieces stored
     **/
    public void setPieces2Stored(int pieceC) {
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }
        Message msg = new Message(MessageType.PIECES_C_STORED, pieceC);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close ();      }

    /**
     * Update of Pieces 0 that manager stored
     * @param pieceA number of pieces stored
     **/
    public void setPieces0Manager(int pieceA) {
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }
        Message msg = new Message(MessageType.PIECES_A_STORED_MANAGER, pieceA);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close ();  
    }
    
    /**
     * Update of Pieces 1 that manager stored
     * @param pieceB number of pieces stored
     **/
    public void setPieces1Manager(int pieceB) {
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }
        Message msg = new Message(MessageType.PIECES_B_STORED_MANAGER, pieceB);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close ();  
    }
    
    /**
     * Update of Pieces 2 that manager stored
     * @param pieceC number of pieces stored
     **/
    public void setPieces2Manager(int pieceC) {
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }
        Message msg = new Message(MessageType.PIECES_C_STORED_MANAGER, pieceC);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close ();  
    }
}
