
package org.marswars.commands;


public class RollerRight extends CommandBase {
    
    
    public RollerRight() {
        requires(pickup);       
    }

    
    protected void initialize() {
    }

   
    protected void execute() {
        pickup.rightRoller();
    }
        
 
    protected boolean isFinished() {
        return false;
    }

    
    protected void end() {
        pickup.stopRight();
    }

   
    protected void interrupted() {
        pickup.stopRight();
    }
}