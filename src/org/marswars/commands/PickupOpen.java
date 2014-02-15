package org.marswars.commands;

public class PickupOpen extends CommandBase {

    public PickupOpen() {
        requires(pickup);
    }

    protected void initialize() {
    }

    protected void execute() {
        pickup.out();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        pickup.stopMotors();
    }

    protected void interrupted() {
        pickup.stopMotors();
    }
}