package org.marswars.commands;

public class RollersDirection extends CommandBase {

    boolean isExecuted = false;

    public RollersDirection() {

        requires(pickup);
    }

    protected void initialize() {
    }

    protected void execute() {
        if (!isExecuted) {
            pickup.toggleForward();
        }
        isExecuted = true;
    }

    protected boolean isFinished() {
        return isExecuted;
    }

    protected void end() {
        isExecuted = false;
    }

    protected void interrupted() {
    }
}