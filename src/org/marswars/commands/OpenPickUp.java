
package org.marswars.commands;  


public class OpenPickUp extends CommandBase {

    public OpenPickUp() {
     
    }

    
    protected void initialize() { 
        
    }

    
    protected void execute() {
        
        pickup.openPickup();
        
    }

    
    protected boolean isFinished() {
        return false;
    }

    
    protected void end() {
        
        pickup.offPickup();
        
    }

    
    protected void interrupted() {
        
        pickup.offPickup();
        
    }
}
