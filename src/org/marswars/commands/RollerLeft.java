
package org.marswars.commands;


public class RollerLeft extends CommandBase {
 
    
    public RollerLeft() {
        
        requires(pickup);       
    }

    
    protected void initialize() {
    }

   
    protected void execute() {
        
        pickup.leftRoller();
    }
 
    protected boolean isFinished() {
        return false;
    }

    
    protected void end() {
        pickup.stopRelays();
    }

   
    protected void interrupted() {
        pickup.stopRelays();
    }
}