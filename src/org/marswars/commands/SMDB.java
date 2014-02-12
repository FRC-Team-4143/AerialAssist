
package org.marswars.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author bradmiller
 */
public class SMDB extends CommandBase {

    public SMDB() {
        // Use requires() here to declare subsystem dependencies
         setRunWhenDisabled(true);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        SmartDashboard.putNumber("FrontLeftVolt", drive.potSteerFL.getVoltage());
        SmartDashboard.putNumber("FrontRightVolt", drive.potSteerFR.getVoltage());
        SmartDashboard.putNumber("RearLeftVolt", drive.potSteerRL.getVoltage());
        SmartDashboard.putNumber("RearRightVolt", drive.potSteerRR.getVoltage());
        SmartDashboard.putNumber("FrontLeftturns", drive.potSteerFL.getTurns());
        SmartDashboard.putNumber("FrontRightturns", drive.potSteerFR.getTurns());
        SmartDashboard.putNumber("RearLeftturns", drive.potSteerRL.getTurns());
        SmartDashboard.putNumber("RearRightturns", drive.potSteerRR.getTurns());
        SmartDashboard.putNumber("StickX", oi.getJoystickLeftX());
        SmartDashboard.putNumber("StickY", oi.getJoystickLeftY());
        SmartDashboard.putNumber("StickZ", oi.getJoystickRightX());
        SmartDashboard.putData("FLpid", drive.pidFL);
        SmartDashboard.putNumber("FLError", drive.pidFL.getError());
        SmartDashboard.putNumber("FLoutput", drive.pidFL.get());
        SmartDashboard.putData("FRpid", drive.pidFR);
        SmartDashboard.putNumber("FRError", drive.pidFR.getError());
        SmartDashboard.putNumber("FRoutput", drive.pidFR.get());
        SmartDashboard.putData("RLpid", drive.pidRL);
        SmartDashboard.putNumber("RLError", drive.pidRL.getError());
        SmartDashboard.putNumber("RLoutput", drive.pidRL.get());
        SmartDashboard.putData("RRpid", drive.pidRR);
        SmartDashboard.putNumber("RRError", drive.pidRR.getError());
        SmartDashboard.putNumber("RRoutput", drive.pidRR.get());
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
