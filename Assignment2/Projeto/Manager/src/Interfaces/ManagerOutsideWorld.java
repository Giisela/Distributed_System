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
public interface ManagerOutsideWorld {

    /**
     * Call the Customer (Outside World)
     * @param info the information about customer
     * @param managerState the state of the manager
     */
    public void phoneCustomer(String info, String managerState);        
}
