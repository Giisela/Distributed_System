/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author giselapinto
 * @author danielmartins
 */
public interface MechanicsRepairArea {
    
    /**
     * when mechanics have a service to do, he starts the repair procedure
     * (Class RepairArea)
     * @param mechanic mechanic's id
     * @param mechanicState mechanic's state
     */
    void startRepairProcedure(int mechanic, String mechanicState);
    
 
    /**
     * Mechanics Fix the car
     * (Class RepairArea)
     */
    void fixIt();
 
    /**
     * If mechanics need a part, he goes to his supplier to get the required part
     * (Class RepairArea)
     * @param mechanic mechanic's id
     * @param mechanicState mechanic's state
     * @return the piece
     */
    String getRequiredPart(int mechanic, String mechanicState);
    
    /**
     * Mechanics check if the part is available on his supplier
     * (Class RepairArea)
     * @return if mechanics has parts with him or not
     * @param peca piece's type
     * @param car customer's car id
     */
    boolean partAvailable(String peca, int car);
    
    /**
     * if he has the part on his supplier he continues to finish repair procedure
     * (Class RepairArea)
     * @param piece piece's type
     * @param mechanic mechanic's id
     * @param mechanicState mechanic's state
     */
    void resumeRepairProcedure(String piece,int mechanic, String mechanicState);
    
    /**
     * Mechanics waits for service, reading the paper
     * (Class RepairArea)
     * @param mechanic mechanic's id
     * @param mechanicState mechanic's state
     * @return the service chosen
     */
    String readThePaper(int mechanic, String mechanicState);   
 
}
