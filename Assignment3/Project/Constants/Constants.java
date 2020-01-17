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
       * Server registry host name.
       */
      public final static String REGISTRY_HOST_NAME = "l040101-ws01.ua.pt";

      /**
       * Server registry server port.
       */
      public final static int REGISTRY_PORT = 22410;

      /**
       * Registry name entry for the register.
       */
      public final static String REGISTRY_NAME_ENTRY = "RegisterHandler";


      /**
       * Server registry host name.
       */
      public final static String SERVER_REGISTRY_HOST_NAME = "l040101-ws01.ua.pt";

      /**
       * Server registry server port.
       */
      public final static int SERVER_REGISTRY_PORT = 22411;

      /**
       * General Repository server host name.
       */
      public static final String LOGGER_HOST_NAME = "l040101-ws01.ua.pt";

      /**
       * General Repository server port.
       */
      public static final int LOGGER_PORT = 22412;

      /**
       * General Repository server name entry for the register.
       */
      public final static String LOGGER_NAME_ENTRY = "LoggerHandler";

      /**
       * Repair Area server host name.
       */
      public static final String REPAIRAREA_HOST_NAME = "l040101-ws03.ua.pt";

      /**
       * Repair Area server port.
       */
      public static final int REPAIRAREA_PORT = 22413;

      /**
       * Repair Area server name entry for the register.
       */
      public final static String REPAIRAREA_NAME_ENTRY = "RepairAreaHandler";


      /**
       * Park server host name.
       */
      public static final String PARK_HOST_NAME = "l040101-ws05.ua.pt";

      /**
       * Park server port.
       */
      public static final int PARK_PORT = 22414;

      /**
       * Park server name entry for the register.
       */
      public final static String PARK_NAME_ENTRY = "ParkHandler";


      /**
       * Supplier Site server host name.
       */
      public static final String SUPPLIERSITE_HOST_NAME = "l040101-ws06.ua.pt";
      /**
       * Supplier Site server port.
       */
      public static final int SUPPLIERSITE_PORT = 22415;

      /**
       * Supplier Site server name entry for the register.
       */
      public final static String SUPPLIERSITE_NAME_ENTRY = "SupplierSiteHandler";

      /**
       * Outside World server host name.
       */
      public static final String OUTSIDEWORLD_HOST_NAME = "l040101-ws04.ua.pt";
      /**
       * Outside World server port.
       */
      public static final int OUTSIDEWORLD_PORT = 22416;

      /**
       * Outside World server name entry for the register.
       */
      public final static String OUTSIDEWORLD_NAME_ENTRY = "OutsideWorldHandler";


      /**
       * Lounge server host name.
       */
      public static final String LOUNGE_HOST_NAME = "l040101-ws02.ua.pt";

      /**
       * Lounge server port.
       */
      public static final int LOUNGE_PORT = 22417;

      /**
       * Lounge server name entry for the register.
       */
      public final static String LOUNGE_NAME_ENTRY = "LoungeHandler";


////////////////////////////////////////////////////////////////////////////////
}
