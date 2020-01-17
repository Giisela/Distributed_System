/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.net.SocketTimeoutException;
import Communication.ServerComm;
import Stubs.GeneralInformationRepo;
import Locations.ServiceProvider;
import Locations.RepairArea;
import Locations.RepairAreaProxy;
import genclass.GenericIO;
/**
 *
 * @author danielmartins
 * @author giselapinto
 */
public class MainProgram {

    /**
     * Used to check if the service must terminate.
     */
    public static boolean serviceEnd = false;
    
    /**
     * Main betting center launcher
     * @param args args
     */
    public static void main(String [] args){
        /**
         * Communication channels.
         */
        ServerComm scon, sconi;
        ServiceProvider sp;
        
        /**
         * Stub initialization.
         */
        GeneralInformationRepo logger = new GeneralInformationRepo(Constants.LOGGER_HOST_NAME, Constants.LOGGER_PORT);
        
        /**
         * Shared region and proxy initialization.
         */
        RepairArea l = new RepairArea(logger);
        RepairAreaProxy rap = new RepairAreaProxy(l);
        
        /**
         * Start listening on the communication channel.
         */
        scon = new ServerComm(Constants.REPAIRAREA_PORT);
        scon.start();
        
        /**
         * While the service is not terminated, accept connections and send them
         * to the service provider.
         */
        while(!serviceEnd){
            try {
                sconi = scon.accept();
                sp = new ServiceProvider(sconi, rap);
                sp.start();
            } catch (SocketTimeoutException ex) {}    
        }
        GenericIO.writelnString("Repair Area it's over");
    }
    
}
