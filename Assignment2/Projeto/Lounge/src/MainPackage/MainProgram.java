/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.net.SocketTimeoutException;
import Communication.ServerComm;
import Locations.Lounge;
import Locations.ServiceProvider;
import Locations.LoungeProxy;

import Stubs.GeneralInformationRepo;
import Stubs.OutsideWorld;
import Stubs.Park;
import Stubs.RepairArea;
import Stubs.SupplierSite;
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
        OutsideWorld outsideWorld = new OutsideWorld ( Constants.OUTSIDEWORLD_HOST_NAME, Constants.OUTSIDEWORLD_PORT );
        SupplierSite supplierSite = new SupplierSite ( Constants.SUPPLIERSITE_HOST_NAME, Constants.SUPPLIERSITE_PORT );        
        RepairArea repairArea = new RepairArea ( Constants.REPAIRAREA_HOST_NAME, Constants.REPAIRAREA_PORT );          
        Park park = new Park(Constants.PARK_HOST_NAME, Constants.PARK_PORT);

        /**
         * Shared region and proxy initialization.
         */
        Lounge l = new Lounge(logger,outsideWorld, supplierSite, repairArea, park);
        LoungeProxy lp = new LoungeProxy(l);
        
        /**
         * Start listening on the communication channel.
         */
        scon = new ServerComm(Constants.LOUNGE_PORT);
        scon.start();
        
        /**
         * While the service is not terminated, accept connections and send them
         * to the service provider.
         */
        while(!serviceEnd){
            try {
                sconi = scon.accept();
                sp = new ServiceProvider(sconi, lp);
                sp.start();
            } catch (SocketTimeoutException ex) {}    
        }
        GenericIO.writelnString("Lounge it's over");
    }
    
}
