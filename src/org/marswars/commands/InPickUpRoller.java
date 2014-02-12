
package org.marswars.commands;  


public class InPickUpRoller extends CommandBase {

    public InPickUpRoller() {
     
    }

    
    protected void initialize() { 
        
    }

    
    protected void execute() {
        
        pickup.inPickupRoller();
        
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
