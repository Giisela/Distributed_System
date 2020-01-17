/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

/**
 * Contains the constants of the all system
 * @author giselapinto
 * @author danielmartins
 */
public class Constants {

    /**
     * Total number of Customers
     */
    public static final int NUM_CUSTOMERS = 30;

    /**
     * Total number of Mechanics
     */ 
    public static final int NUM_MECHANICS = 2;

    /**
     * Total replacement cars
     */     
    public static final int NUM_REP_VEH = 3;

    /**
     * Total part types    
     */
    public static final int TYPE_PARTS = 3;
    
    /**
     * number of A pieces
     */
    public static int pieceA = 5;
    /**
     * number of B pieces
     */
    public static int pieceB = 5;
    /**
     * number of C pieces
     */
    public static int pieceC = 5;
    
    
    /** 
     * Define Services
     */
    public static final String ATENDING_CUSTOMER = "1";
    public static final String ALERTING_CUSTOMER = "2";
    public static final String GETTING_NEW_PARTS = "3";

    /**
     * Name of the file used for the logger.
     */
    public static final String FILE_NAME = "log.txt";
    
/////////////////////////////// Server HOST NAME & PORT //////////////////////// 
    
    /**
     * General Repository server host name.
     */
    public static final String LOGGER_HOST_NAME = "localhost";
    
    /**
     * General Repository server port.
     */    
    public static final int LOGGER_PORT = 8081;
    
    /**
     * Lounge server host name.
     */    
    public static final String LOUNGE_HOST_NAME = "localhost";
    
    /**
     * Lounge server port.
     */
    public static final int LOUNGE_PORT = 8082;

    /**
     * Outside World server host name.
     */    
    public static final String OUTSIDEWORLD_HOST_NAME = "localhost";
    /**
     * Outside World server port.
     */
    public static final int OUTSIDEWORLD_PORT = 8083;    

    /**
     * Supplier Site server host name.
     */
    public static final String SUPPLIERSITE_HOST_NAME = "localhost";
    /**
     * Supplier Site server port.
     */
    public static final int SUPPLIERSITE_PORT = 8084;

    /**
     * Repair Area server host name.
     */    
    public static final String REPAIRAREA_HOST_NAME = "localhost";

    /**
     * Repair Area server port.
     */        
    public static final int REPAIRAREA_PORT = 8085;
    
    /**
     * Park server host name.
     */    
    public static final String PARK_HOST_NAME = "localhost";

    /**
     * Park server port.
     */        
    public static final int PARK_PORT = 8086;           

////////////////////////////////////////////////////////////////////////////////  
}
