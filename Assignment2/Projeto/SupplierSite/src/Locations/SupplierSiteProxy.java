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
public class SupplierSiteProxy implements InterfaceLocation {
    /**
     * Lounge used to process the messages.
     */
    private final SupplierSite l;
    
    /**
     * Lounge Proxy constructor.
     * @param l betting center to process the messages
     */
    public SupplierSiteProxy(SupplierSite l){
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
            case GO_TO_SUPPLIER :
                int quantity = l.goToSupplier(inMessage.getStr1(), inMessage.getStr2());
                outMessage = new Message (MessageType.RETURN_GO_TO_SUPPLIER, quantity);
                break;
            case SERVICE_END :
                l.serviceEnd();
                outMessage = new Message(MessageType.STATUS_OK);
                break;                         
        }
        return outMessage;
    }    
}
