
package org.marswars.commands;


public class PickupClose extends CommandBase {
    
    boolean isExecuted = false;
    
    public PickupClose() {
        
        requires(pickup);       
    }

    
    protected void initialize() {
    }

   
    protected void execute() {
        
        if (!isExecuted) {
            pickup.close();
        }
        isExecuted = true;  
    }
        
 
    protected boolean isFinished() {
        return isExecuted;
    }

    
    protected void end() {
        isExecuted = false;
    }

   
    protected void interrupted() {
    }
}