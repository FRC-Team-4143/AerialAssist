package org.marswars.commands;

/**
 *
 * @author bradmiller
 */
public class ToggleRobotFront extends CommandBase {
    
    private boolean executed = false;

    public ToggleRobotFront() {
        // Use requires() here to declare subsystem dependencies
        requires(drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(!executed) {
            drive.toggleFrontBack();
            executed = true;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return executed;
    }

    // Called once after isFinished returns true
    protected void end() {
        executed = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
