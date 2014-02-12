
package org.marswars.commands;  


public class ClosePickUp extends CommandBase {

    public ClosePickUp() {
     
    }

    
    protected void initialize() { 
        
    }

    
    protected void execute() {
        
        pickup.closePickup();
        
    }

    
    protected boolean isFinished() {
        return false;
    }

    
    protected void end() {
        
        pickup.closePickup();
        
    }

    
    protected void interrupted() {
        
        pickup.offPickup();
        
    }
}
