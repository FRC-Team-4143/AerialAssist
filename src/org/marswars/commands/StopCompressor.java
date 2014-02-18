package org.marswars.commands;

public class StopCompressor extends CommandBase {
    
    private boolean isExecuted = false;

    public StopCompressor() {
        requires(pickup);
    }

    protected void initialize() {
    }

    protected void execute() {
        if (!isExecuted)
            pickup.compressorStop();
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