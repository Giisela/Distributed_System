/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locations;

import Communication.Message;
import Communication.MessageType;

/*
 * @author giselapinto
 * @author danielmartins
 */
public class GeneralInformationRepoProxy implements InterfaceLocation {
    /**
     * Lounge used to process the messages.
     */
    private final GeneralInformationRepo l;
    
    /**
     * Lounge Proxy constructor.
     * @param l betting center to process the messages
     */
    public GeneralInformationRepoProxy(GeneralInformationRepo l){
        this.l = l;
    }
    
    /**
     * Process and reply a message.
     * @param inMessage message received
     * @return message to be replied
     */
    @Override
    public Message processAndReply(Message inMessage){
        Message outMessage = null;
        
        switch(inMessage.getType()){
            
            /**
            * Function called by Lounge, Outside World,RepairArea and Supplier Site
            **/
            case SET_MANAGER_STATE : 
                l.setManagerState(inMessage.getStr1());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            /**
            * Function called by Lounge, Outside World and Park
            **/
            case SET_CUSTOMER_STATE :
                l.setCustomerState(inMessage.getInt1(), inMessage.getStr1());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            /**
            * Function called by Lounge and RepairArea
            **/    
            case SET_MECHANIC_STATE :
                l.setMechanicState(inMessage.getInt1(), inMessage.getStr1());
                outMessage = new Message(MessageType.STATUS_OK);
                break;           
            /**
             * Funtions called by Lounge
             */
            case SET_SIZE_QUEUE :
                l.setValueQueueIn(inMessage.getInt1());
                outMessage = new Message(MessageType.STATUS_OK);
                break;                
            case SET_FLAG_A :
                l.setFlagAPieces(inMessage.getStr1());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case SET_FLAG_B :
                l.setFlagBPieces(inMessage.getStr1());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case SET_FLAG_C :
                l.setFlagCPieces(inMessage.getStr1());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            /**
             * Functions called by Outside World        
             */    
            case SET_REPLACEMENT_CAR :
                l.setReplecementCar(inMessage.getInt1(), inMessage.getStr1());
                outMessage = new Message(MessageType.STATUS_OK);
                break;                 
            /**
             * Functions called by Park        
             */
            case SET_ALREADY_REPAIRED :
                l.setAlreadyRepaired(inMessage.getInt1(), inMessage.getArray());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
                
            case SET_WAITING_CARS :
                l.setNumberWaitingReplece(inMessage.getInt1());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
                
            case SET_NUMBER_REPAIR:
                l.setNumberRepair(inMessage.getInt1());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            
            case SET_NUMBER_PARKED_CARS:
                l.setNumberParkCars(inMessage.getInt1());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
                
            case SET_NUMBER_REPLACEMENT_CAR_PARKED:
                l.setNumberReplacementPark(inMessage.getInt1());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            /**
            * Function called by Park, Outside World and Lounge
            **/
            case SET_OWN_CAR :
                l.setOwnCar(inMessage.getInt1(), inMessage.getStr1());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            /**
             * Functions called by Repair Area
             */
            case SET_SERVICE:
                l.setNumberServiceRequest(inMessage.getInt1());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case SET_PIECE_AVAILABLE :
                l.setPiecesAvabal(inMessage.getStr1(), inMessage.getInt1());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case PIECES_A_STORED : 
                l.setPieces0Stored(inMessage.getInt1());
                outMessage = new Message(MessageType.STATUS_OK);
                break;                
            case PIECES_B_STORED : 
                l.setPieces1Stored(inMessage.getInt1());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case PIECES_C_STORED : 
                l.setPieces2Stored(inMessage.getInt1());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case PIECES_A_STORED_MANAGER :
                l.setPieces0Manager(inMessage.getInt1());
                outMessage = new Message(MessageType.STATUS_OK);
                break;                
            case PIECES_B_STORED_MANAGER :
                l.setPieces1Manager(inMessage.getInt1());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case PIECES_C_STORED_MANAGER :
                l.setPieces2Manager(inMessage.getInt1());
                outMessage = new Message(MessageType.STATUS_OK);
                break;                
            case SERVICE_END :
                l.serviceEnd();
                outMessage = new Message(MessageType.STATUS_OK);
                break;    
        }
        return outMessage;
    }    
}
