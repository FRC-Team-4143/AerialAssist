
package org.marswars.commands;  


public class OutPickUpRoller extends CommandBase {

    public OutPickUpRoller() {
     
    }

    
    protected void initialize() { 
        
    }

    
    protected void execute() {
        
        pickup.outPickupRoller();
        
    }

    
    protected boolean isFinished() {
        return false;
    }

    
    protected void end() {
        
        pickup.offPickupRoller();
        
    }

    
    protected void interrupted() {
        
        pickup.offPickupRoller();
        
    }
}
