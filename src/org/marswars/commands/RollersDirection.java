
package org.marswars.commands;


public class RollersDirection extends CommandBase {
    
    boolean isExecuted = false;
    
    public RollersDirection() {
        if (!isExecuted) {
            requires(pickup);   
            }
        isExecuted = true;
    }

    
    protected void initialize() {
    }

   
    protected void execute() {
        
        pickup.toggleForward();
    }
        
 
    protected boolean isFinished() {
        return false;
    }

    
    protected void end() {
        
    }

   
    protected void interrupted() {
        
    }
}