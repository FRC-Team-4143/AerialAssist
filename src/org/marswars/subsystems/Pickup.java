
package org.marswars.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.marswars.RobotMap;

public class Pickup extends Subsystem {

    private Solenoid wingBack = new Solenoid(RobotMap.portSolenoidBackExtend);
    private DoubleSolenoid wingLeft = new DoubleSolenoid(1, RobotMap.portSolenoidLeftExtend, RobotMap.portSolenoidLeftRetract);
    private DoubleSolenoid wingRight = new DoubleSolenoid(1, RobotMap.portSolenoidRightExtend, RobotMap.portSolenoidRightRetract);
    private Compressor compressor = new Compressor(RobotMap.portCompressorPressure, RobotMap.portCompressorRelay);
    
    private Relay rollerLeft = new Relay(RobotMap.portRelayPickupL, Relay.Direction.kBoth);
    private Relay rollerRight = new Relay(RobotMap.portRelayPickupR, Relay.Direction.kBoth);
    
    private boolean forward = true;
    private boolean left = false;
    private boolean right = false;
    
    public Pickup() {
        LiveWindow.addActuator("Pickup", "Left Wing", wingLeft);
        LiveWindow.addActuator("Pickup", "Right Wing", wingRight);
        LiveWindow.addActuator("Pickup", "Back Wing", wingBack);
        LiveWindow.addActuator("Pickup", "Compressor", compressor);
        LiveWindow.addActuator("Pickup", "Left Relay", rollerLeft);
        LiveWindow.addActuator("Pickup", "Right Relay", rollerRight);
    }

    public void initDefaultCommand() {

    }
    
    public void compressorStart() {
        compressor.start();
    }
    
    public void compressorStop() {
        compressor.stop();
    }

    public void open() {
        wingLeft.set(DoubleSolenoid.Value.kForward);
        wingRight.set(DoubleSolenoid.Value.kForward);
    }

    public void close() {
        wingLeft.set(DoubleSolenoid.Value.kReverse);
        wingRight.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void openBack() {
        wingBack.set(true);
    }

    public void stopWings() {
        wingLeft.set(DoubleSolenoid.Value.kOff);
        wingRight.set(DoubleSolenoid.Value.kOff);
    }

    public void stopLeft() {
        rollerLeft.set(Relay.Value.kOff);
    }
    
    public void stopRight() {
        rollerRight.set(Relay.Value.kOff);
    }
    
    public void toggleForward() {
        forward = !forward;
        setRoller(rollerLeft, true);
        setRoller(rollerRight, false);
    }
    
    private void setRoller(Relay roller, boolean forwardIsIn) {
        if ((forward && forwardIsIn) || (!forward && !forwardIsIn)) {
            roller.set(Relay.Value.kForward);
        } else {
            roller.set(Relay.Value.kReverse);
        }
    }
    
    public void leftRoller() {
        if (left) {
            rollerLeft.set(Relay.Value.kOff);
        } else {
            setRoller(rollerLeft, true);
        }
        left = !left;
    }
    
    public void rightRoller() {
        if (right) {
            rollerRight.set(Relay.Value.kOff);
        } else {
            setRoller(rollerRight, false);
        }
        right = !right;
    }
}

