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
public class LoungeProxy implements InterfaceLocation {
    /**
     * Lounge used to process the messages.
     */
    private final Lounge l;
    
    /**
     * Lounge Proxy constructor.
     * @param l betting center to process the messages
     */
    public LoungeProxy(Lounge l){
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
             * The functions called by Customer
             */
            case QUEUE_IN :
                l.queueIn(inMessage.getStr1(), inMessage.getStr2());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case TALK_WITH_MANAGER :
                l.talkWithManager(inMessage.getInt1());    
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case COLLECT_KEY :
                l.collectKey(inMessage.getInt1(),inMessage.getStr1());    
                outMessage = new Message(MessageType.STATUS_OK);
                break;                        
            case PAY_FOR_THE_SERVICE :
                l.payForTheService(inMessage.getInt1());    
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            /**
             * The functions called by Manager
             */
            case GET_NEXT_TASK :
                l.getNextTask(inMessage.getStr1());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case APRAISE_SIT :
                String choice = l.appraiseSit();
                outMessage = new Message(MessageType.RETURN_APRAISE_SIT, choice);
                break;
            case TALK_TO_CUSTOMER : 
                l.talkToCustomer(inMessage.getStr1(), inMessage.getStr2());  
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case RECEIVE_PAYMENT :
                l.receivePayment(inMessage.getStr1());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case HAND_CAR_KEY :
                l.handCarKey(inMessage.getStr1());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            /**
             * The functions called by Manager
             */
            case LET_MANAGER_KNOW :
                l.letManagerKnow( inMessage.getStr1(), inMessage.getInt1(), inMessage.getStr2());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case REPAIR_CONCLUDED :
                l.repairConcluded(inMessage.getInt1(), inMessage.getInt2(), inMessage.getStr1());                    
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case CHECK_REQUEST :
                boolean check = l.checkRequest(inMessage.getStr1());
                outMessage = new Message (MessageType.RETURN_CHECK_REQUEST, check);
                break;
            /**
             * Function called by all entities  
             */
            case SERVICE_END :
                l.serviceEnd();    
                outMessage = new Message(MessageType.STATUS_OK);
                break;                
        }
        return outMessage;
    }    
}
