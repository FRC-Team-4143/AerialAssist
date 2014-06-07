package org.marswars.commands;

import com.sun.squawk.util.MathUtils;

/**
 *
 * @author bradmiller
 */
public class PickupDefault extends CommandBase {

    public PickupDefault() {
        // Use requires() here to declare subsystem dependencies
        requires(pickup);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
       double left = oi.getImplementJoystickLeftX();
       double right = oi.getImplementJoystickRightX();
       if(left < -0.1) {
           pickup.openLeftWing();
       } else if (left > 0.1) {
           pickup.closeLeftWing();
       }
       else {
           pickup.stopLeftWing();
       }
       
       if(right < -0.1) {
           pickup.closeRightWing();
       } else if (right > 0.1) {
           pickup.openRightWing();
       }
       else {
           pickup.stopRightWing();
       }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
