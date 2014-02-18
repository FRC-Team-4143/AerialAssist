package org.marswars.commands;

public class PickupOpen extends CommandBase {

    public PickupOpen() {
        requires(pickup);
    }

    protected void initialize() {
    }

    protected void execute() {
        pickup.open();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        pickup.stopWings();
    }

    protected void interrupted() {
        pickup.stopWings();
    }
}