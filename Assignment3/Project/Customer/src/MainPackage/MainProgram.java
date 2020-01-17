/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import Interfaces.*;
import static MainPackage.Constants.NUM_CUSTOMERS;
import genclass.GenericIO;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author giselapinto
 * @author danielmartins
 */
public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        long startTime = System.nanoTime();
        
        /* get location of the generic registry service */
        String rmiRegHostName = Constants.REGISTRY_HOST_NAME;
        int rmiRegPortNumb = Constants.REGISTRY_PORT;

        /* look for the remote object by name in the remote host registry */
        String nameEntry = Constants.REGISTRY_NAME_ENTRY;
        Registry registry = null;
        
        ILounge loungeInt = null;
        IOutside outsideworldInt = null;
        IPark parkInt = null;
       
        try
        {
            registry = LocateRegistry.getRegistry (rmiRegHostName, rmiRegPortNumb);
        }
        catch (RemoteException e)
        { GenericIO.writelnString ("RMI registry creation exception: " + e.getMessage ());
          e.printStackTrace ();
          System.exit (1);
        }
        GenericIO.writelnString ("RMI registry was created!");
        
        try
        {
            outsideworldInt = (IOutside) registry.lookup (Constants.OUTSIDEWORLD_NAME_ENTRY);
        }
        catch (NotBoundException ex) {
            System.out.println("Outside World is not registered: " + ex.getMessage () );
            ex.printStackTrace ();
            System.exit(1);
        } catch (RemoteException ex) {
            System.out.println("Exception thrown while locating Outside World : " + ex.getMessage () );
            ex.printStackTrace ();
            System.exit (1);
        }
        
        try
        {
            parkInt = (IPark) registry.lookup (Constants.PARK_NAME_ENTRY);
        }
        catch (NotBoundException ex) {
            System.out.println("Park is not registered: " + ex.getMessage ());
            ex.printStackTrace ();
            System.exit(1);
        } catch (RemoteException ex) {
            System.out.println("Exception thrown while locating Park: " + ex.getMessage () );
            ex.printStackTrace ();
            System.exit (1);
        }
 
        /* Look for the other entities in the registry */
        try
        {
            loungeInt = (ILounge) registry.lookup (Constants.LOUNGE_NAME_ENTRY);
        }
        catch (NotBoundException ex) {
            System.out.println("Lounge is not registered: " + ex.getMessage () );
            ex.printStackTrace ();
            System.exit(1);
        } catch (RemoteException ex) {
            System.out.println("Exception thrown while locating Lounge: " + ex.getMessage () );
            ex.printStackTrace ();
            System.exit (1);
        }        
        
        GenericIO.writelnString ("Starting Customer...");
        
        /**
         * Customer lifecycle start.
         */        
        Customer[] customer = new Customer[NUM_CUSTOMERS];
 

        for(int i = 0; i<NUM_CUSTOMERS; i++){
            customer[i] = new Customer(i, outsideworldInt, i,  parkInt,  loungeInt);
            customer[i].start();
        }
        for (int i = 0; i<NUM_CUSTOMERS; i++) {
            try{
                customer[i].join();
            }
            catch(InterruptedException e){
                GenericIO.writelnString("Customer was interrupted - "+e);
            }
            GenericIO.writelnString("Customer: "+i+" ended lifecycle.");

        }
        
        try {
            loungeInt.serviceEnd();
        } catch (RemoteException ex) {
            System.out.println("Exception thrown while calling service end: " + ex.getMessage () );
            ex.printStackTrace ();
            System.exit (1);
        }
        
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Run time :"+(double)(totalTime/1000000000));
    }
}
