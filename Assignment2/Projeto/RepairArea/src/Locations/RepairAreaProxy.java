/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locations;

import Communication.Message;
import Communication.MessageType;

/*
 * @author danielmartins
 * @author giselapinto
 */
public class RepairAreaProxy implements InterfaceLocation {
    /**
     * Lounge used to process the messages.
     */
    private final RepairArea l;
    
    /**
     * Lounge Proxy constructor.
     * @param l betting center to process the messages
     */
    public RepairAreaProxy(RepairArea l){
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
             * Functions called by Manager
             **/            
            case REGISTER_SERVICE :
                l.registerService(inMessage.getStr1(), inMessage.getStr2());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case STORE_PART : 
                l.storePart(inMessage.getStr1(), inMessage.getInt1(), inMessage.getStr2());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case SHUTDOWN :
                l.shutdownNow(inMessage.getStr1());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            /**
             * Functions called by Mechanic
             **/                  
            case READ_THE_PAPER :
                String service = l.readThePaper(inMessage.getInt1(), inMessage.getStr1());
                outMessage = new Message (MessageType.RETURN_READ_THE_PAPER, service);
                break;
            case START_REPAIR_PROCEDURE :
                l.startRepairProcedure(inMessage.getInt1(), inMessage.getStr1());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case FIX_IT :
                l.fixIt();
                outMessage = new Message(MessageType.STATUS_OK);
                break;                                        
            case GET_REQUIRED_PART :
                String piece = l.getRequiredPart(inMessage.getInt1(), inMessage.getStr1());
                outMessage = new Message (MessageType.RETURN_GET_REQUIRED_PART, piece);
                break;
            case PART_AVAILABLE :
                boolean available = l.partAvailable(inMessage.getStr1(), inMessage.getInt1());
                outMessage = new Message (MessageType.RETURN_PART_AVAILABLE, available);
                break;
            case RESUME_REPAIR_PROCEDURE :
                l.resumeRepairProcedure(inMessage.getStr1(), inMessage.getInt1(), inMessage.getStr2());
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
