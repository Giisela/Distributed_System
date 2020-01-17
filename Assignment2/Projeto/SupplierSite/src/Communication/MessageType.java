/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Communication;

/**
 * 
 * @author danielmartins
 * @author giselapinto
 */
public enum MessageType {

    /**
     * When a shared region answers with an OK to a request made by an entity.
     */
    STATUS_OK,    
    
    /**
     * Call the function getNextTask
     */
    GET_NEXT_TASK,
    
    /**
     * Call the function apraiseSit
     */
    APRAISE_SIT,

    /**
     * return the result of fuction apraiseSit
     */
    RETURN_APRAISE_SIT,
    
    /**
     * Call the function talkToCustomer
     */    
    TALK_TO_CUSTOMER,

    /**
     * Call the function receivePayment
     */ 
    RECEIVE_PAYMENT,

    /**
     * Call the function handCarKey
     */   
    HAND_CAR_KEY,

    /**
     * Call the function registerService
     */    
    REGISTER_SERVICE,

    /**
     * Call the function phoneCustomer
     */    
    PHONE_CUSTOMER,

    /**
     * Call the function storePart
     */    
    STORE_PART,

    /**
     * Call the function goToSupplier
     */
    GO_TO_SUPPLIER,

    /**
     * return the result of fuction goToSupplier
     */    
    RETURN_GO_TO_SUPPLIER,
    
    /**
     * Call the function shutdown
     */    
    SHUTDOWN, 

    /**
     * Call the function setManagerState  (general Information)
     */    
    SET_MANAGER_STATE,

    /**
     * Call the function setCustomerState  (general Information)
     */        
    SET_CUSTOMER_STATE, 
    
    /**
     * Call the function setMechanicState  (general Information)
     */        
    SET_MECHANIC_STATE, 
    
    /**
     * Call the function setSizeQueue  (general Information)
     */        
    SET_SIZE_QUEUE, 

    /**
     * Call the function setWaitingCars  (general Information)
     */        
    SET_WAITING_CARS, 

    /**
     * Call the function setFlagA  (general Information)
     */    
    SET_FLAG_A, 

    /**
     * Call the function setFlagB  (general Information)
     */   
    SET_FLAG_B, 
    
    /**
     * Call the function setFlagC  (general Information)
     */    
    SET_FLAG_C, 
    
    /**
     * Call the function setNumberServiceRequest  (general Information)
     */
    SET_SERVICE, 
    
    /**
     * Call the function setPiecesAvabal  (general Information)
     */
    SET_PIECE_AVAILABLE, 
    
    /**
     * Call the function setPieces0Stored  (general Information)
     */
    PIECES_A_STORED, 

    /**
     * Call the function setPieces1Stored  (general Information)
     */    
    PIECES_B_STORED, 

    /**
     * Call the function setPieces2Stored  (general Information)
     */    
    PIECES_C_STORED,

    /**
     * Call the function setPieces0Manager  (general Information)
     */    
    PIECES_A_STORED_MANAGER, 

    /**
     * Call the function setPieces1Manager  (general Information)
     */        
    PIECES_B_STORED_MANAGER, 

    /**
     * Call the function setPieces2Manager  (general Information)
     */        
    PIECES_C_STORED_MANAGER,
    
    /**
     * Call the function returnVehicle
     */
    RETURN_VEHICLE,

    /**
     * Call the function getVehicle
     */    
    GET_VEHICLE,

    /**
     * Call the function talkWithManager
     */    
    TALK_WITH_MANAGER,

    /**
     * Call the function payForTheService
     */    
    PAY_FOR_THE_SERVICE,

    /**
     * Call the function blockVehicle
     */    
    BLOCK_VEHICLE,

    /**
     * Call the function checkRequest
     */    
    CHECK_REQUEST,
    
    /**
     * Result of the function checkRequest
     */
    RETURN_CHECK_REQUEST,
    
    /**
     * Call the function backToWorkByCar
     */    
    BACK_TO_WORK_BY_CAR,

    /**
     * Call the function queueIn
     */    
    QUEUE_IN,

    /**
     * Call the function decideOnRepair
     */    
    DECIDE_ON_REPAIR,
    
    /**
     * Result from the function decideOnRepair
     */
    RETURN_DECIDE_ON_REPAIR,

    /**
     * Call the function backToWorkByBus
     */    
    BACK_TO_WORK_BY_BUS,

    /**
     * Call the function findCar
     */    
    FIND_CAR,

    /**
     * Result from the findCar function
     */
    RETURN_FIND_CAR,
    /**
     * Call the function collectKey
     */    
    COLLECT_KEY,

    /**
     * Call the function readThePaper
     */    
    READ_THE_PAPER,
    
    /**
     * return the result of readThePaper function
     */    
    RETURN_READ_THE_PAPER,    

    /**
     * Call the function letManagerKnow
     */    
    LET_MANAGER_KNOW,
    
    /**
     * Call the function repairConcluded
     */    
    REPAIR_CONCLUDED, 
    
    /**
     * Call the function goToRepairShop
     */
    GO_TO_REPAIR_SHOP, 

    /**
     * Call the function collectCar
     */    
    COLLECT_CAR, 

    /**
     * Call the function fixIt
     */    
    FIX_IT, 

    /**
     * Call the function startRepairProcedure
     */    
    START_REPAIR_PROCEDURE, 

    /**
     * Call the function getRequiredPart
     */    
    GET_REQUIRED_PART,
    
    /**
     * Result from the function getRequiredPart
     */
    RETURN_GET_REQUIRED_PART,

    /**
     * Call the function partAvailable
     */    
    PART_AVAILABLE,
    
    /**
     * Result from the partAvailable function
     */
    RETURN_PART_AVAILABLE,

    /**
     * Call the function resumeRepairProcedure
     */    
    RESUME_REPAIR_PROCEDURE,
    
    /**
    * Call the function setReplacementCar (general Information)
    */  
    SET_REPLACEMENT_CAR,
    
    /**
    * Call the function setAlreadyRepaired (general Information)
    */  
    SET_ALREADY_REPAIRED,
    
    /**
    * Call the function setOwnCar (general Information)
    */
    SET_OWN_CAR,
    
    /**
    * Call the function setWaitReplacement (general Information)
    */
    SET_WAIT_REPLACEMENT,
    
    /**
    * Call the function setNumberRepair (general Information)
    */
    SET_NUMBER_REPAIR,
    
    /**
    * Call the function setNumberParkCars (general Information)
    */
    SET_NUMBER_PARKED_CARS,
    
    /**
    * Call the function setNumberReplacementPark (general Information)
    */
    SET_NUMBER_REPLACEMENT_CAR_PARKED,

    /**
    * Call the function serviceEnd (general Information)
    */
    SERVICE_END
}
