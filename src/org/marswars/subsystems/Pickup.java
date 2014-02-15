
package org.marswars.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.marswars.RobotMap;

public class Pickup extends Subsystem {

    private Talon motor = new Talon(RobotMap.portMotorPickup);
    //private Talon motorRight = new Talon(RobotMap.portMotorPickupR);
    private Relay rollerLeft = new Relay(RobotMap.portRelayPickupL);
    private Relay rollerRight = new Relay(RobotMap.portRelayPickupR);
    private int running = 0;

    public Pickup() {
        LiveWindow.addActuator("Pickup", "Left Motor", motor);
        //LiveWindow.addActuator("Pickup", "Right Motor", motorRight);
        LiveWindow.addActuator("Pickup", "Left Relay", rollerLeft);
        LiveWindow.addActuator("Pickup", "Right Relay", rollerRight);
    }

    public void initDefaultCommand() {

    }

    public void open() {
        motor.set(Preferences.getInstance().getDouble("Pickupspeed", 0.5));
        //motorRight.set(Preferences.getInstance().getDouble("Pickupspeed", 0.5));
        Timer.delay(Preferences.getInstance().getDouble("Pickuptime", 1.));
        stopMotors();
    }

    public void close() {
        motor.set(-1 * Preferences.getInstance().getDouble("Pickupspeed", 0.5));
        //motorRight.set(-1 * Preferences.getInstance().getDouble("Pickupspeed", 0.5));
        Timer.delay(Preferences.getInstance().getDouble("Pickuptime", 1.));
        stopMotors();
    }

    public void stopMotors() {
        motor.set(0.);
        //motorRight.set(0.);
    }

    public void stopRelays() {
        rollerLeft.set(Relay.Value.kOff);
        rollerRight.set(Relay.Value.kOff);
        running = 0;
    }

    public void in()  {
        rollerLeft.set(Relay.Value.kForward);
        rollerRight.set(Relay.Value.kForward);
        running = 1;
    }

    public void out()  {
        rollerLeft.set(Relay.Value.kReverse);
        rollerRight.set(Relay.Value.kReverse);
        running = -1;
    }

    public int isRunning() {
        return running;
    }
}

