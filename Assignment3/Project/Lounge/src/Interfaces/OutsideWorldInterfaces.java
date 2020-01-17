/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author danielmartins
 * @author giselapinto
 */
public interface OutsideWorldInterfaces extends Remote{
   
    /**
     * Terminate the outsideWorld service.
     * @throws java.rmi.RemoteException
     */
    public void serviceEnd() throws RemoteException;
}
