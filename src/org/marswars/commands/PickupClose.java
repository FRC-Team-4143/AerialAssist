package org.marswars.commands;

public class PickupClose extends CommandBase {

    public PickupClose() {
        requires(pickup);
    }

    protected void initialize() {
    }

    protected void execute() {
        pickup.close();
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