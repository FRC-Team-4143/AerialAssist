package org.marswars.commands;

import com.sun.squawk.util.MathUtils;

/**
 *
 * @author bradmiller
 */
public class CrabDrive extends CommandBase {

    public CrabDrive() {
        // Use requires() here to declare subsystem dependencies
        requires(drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double twist = oi.getJoystickRightX();
        twist = twist / Math.abs(twist) * MathUtils.pow(twist, 2);
        drive.Crab(twist, -oi.getJoystickLeftY(),
                oi.getJoystickLeftX(), Math.abs(oi.getTriggers()));
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
