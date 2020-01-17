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
public class OutsideWorldProxy implements InterfaceLocation {
    /**
     * Lounge used to process the messages.
     */
    private final OutsideWorld out;
    
    /**
     * OutsideWorld Proxy constructor.
     * @param out OutsideWorld to process the messages
     */
    public OutsideWorldProxy(OutsideWorld out){
        this.out = out;
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
             * Functions called by Customer
             */
            case DECIDE_ON_REPAIR :
                boolean decide = out.decideOnRepair(inMessage.getInt1(), inMessage.getStr1());
                outMessage = new Message(MessageType.RETURN_DECIDE_ON_REPAIR, decide);
                break;
            case BACK_TO_WORK_BY_BUS :
                out.backToWorkByBus(inMessage.getInt1(), inMessage.getStr1());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case BACK_TO_WORK_BY_CAR :
                out.backToWorkByCar(inMessage.getStr1(), inMessage.getStr2());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            /**
             * Functions called by Manager
             */
             case PHONE_CUSTOMER :
                out.phoneCustomer(inMessage.getStr1(), inMessage.getStr2());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case SERVICE_END :
                out.serviceEnd();
                outMessage = new Message(MessageType.STATUS_OK);
                break;                                                                         
        }
        return outMessage;
    }    
}
