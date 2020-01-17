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
public interface ManagerRepairArea {
    /**
     * Register a Service (RepairArea)
     * @param info the information about customer
     * @param managerState the state of the manager
     */
    public void registerService(String info, String managerState);  
    
    /**
     * Replace the pieces (RepairArea)
     * @param peca, string argument, type of the piece
     * @param quantidade, integer argument, number os pieces
     * @param managerState the state of the manager
     * 
     */
    public void storePart(String peca, int quantidade, String managerState);
    
    /**
     * Role responsible for telling mechanics that work is over (RepairArea)
     * @param managerState the state of the manager
     */
    public void shutdownNow(String managerState);
}
