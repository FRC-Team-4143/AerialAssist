
package org.marswars.commands;


public class PickupOpen extends CommandBase {
    
    boolean isExecuted = false;
    
    public PickupOpen() {
        
        requires(pickup);       
    }

    
    protected void initialize() {
    }

   
    protected void execute() {
        
        if (!isExecuted) {
            pickup.out();
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