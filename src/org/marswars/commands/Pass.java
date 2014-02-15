
package org.marswars.commands;

import edu.wpi.first.wpilibj.Preferences;

public class Pass extends CommandBase {
    
    boolean isExecuted = false;

    public Pass() {
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (!isExecuted) {
            shooter.launch(Preferences.getInstance().getDouble("Passspeed", 0.3));
        }
        isExecuted = true;
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isExecuted;
    }

    // Called once after isFinished returns true
    protected void end() {
        isExecuted = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
