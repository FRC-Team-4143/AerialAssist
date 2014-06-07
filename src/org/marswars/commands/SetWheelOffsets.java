package org.marswars.commands;

/**
 *
 * @author bradmiller
 */
public class SetWheelOffsets extends CommandBase {
    
    private boolean m_Executed = false;

    public SetWheelOffsets() {
        requires(drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (!m_Executed) {
            double FLOffset = drive.potSteerFL.getAverageVoltage() - 2.5;
            double FROffset = drive.potSteerFR.getAverageVoltage() - 2.5;
            double RLOffset = drive.potSteerRL.getAverageVoltage() - 2.5;
            double RROffset = drive.potSteerRR.getAverageVoltage() - 2.5;

            drive.setOffsets(FLOffset, FROffset, RLOffset, RROffset);
            m_Executed = true;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return m_Executed;
    }

    // Called once after isFinished returns true
    protected void end() {
        m_Executed = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
