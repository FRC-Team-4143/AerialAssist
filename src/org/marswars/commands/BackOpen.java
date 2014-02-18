package org.marswars.commands;

public class BackOpen extends CommandBase {
    
    private boolean isExecuted = false;

    public BackOpen() {
        requires(pickup);
    }

    protected void initialize() {
    }

    protected void execute() {
        if (!isExecuted)
            pickup.openBack();
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