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
public interface MechanicsPark {
    
    /**
    * Mechanics finish de repair procedure and let the car in the park
    * (Class Park)
    * @param car customer's car
    */
    void returnVehicle(int car);
    
    /**
    * Mechanics get the car to repair
    * @param car customer's car
    * (Class Park)
    */
    void getVehicle(int car);  

    /**
    * Mechanics block the car
    * @param car customer's car
    * (Class Park)
    */    
    void blockVehicle(int car);
}
