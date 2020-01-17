/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author danielmartins
 * @author giselapinto
 */
public interface ManagerLounge {
    /**
     * Get a new Task for the Manager (Lounge)
     * @param managerState the state of the manager
     * @return boolean 
     */
    public boolean getNextTask(String managerState);
    
    /**
     * Choose what is the new task (Lounge)
     * @return int 
     */
    public String appraiseSit();
    
    /**
     * Talk to Customer (Lounge)
     * @param info the information about customer
     * @param managerState the state of the manager
     * 
     */
    public void talkToCustomer(String info, String managerState);
    
    /**
     * Receive Payment (Lounge)
     * @param info the information about customer 
     */
    public void receivePayment(String info);
    
    /**
     * Hand Car Key (Lounge)
     * @param info the information about customer 
     */
    public void handCarKey(String info);
    
}
