
package org.marswars.commands;

/**
 *
 * @author bradmiller
 */
public class UnwindRL extends CommandBase {
    
    boolean isFinished = false;

    public UnwindRL() {
        // Use requires() here to declare subsystem dependencies
        requires(drive);
        setRunWhenDisabled(true);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        isFinished = !drive.unwindRL();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
        isFinished = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
