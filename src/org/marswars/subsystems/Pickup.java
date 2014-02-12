
package org.marswars.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

    import edu.wpi.first.wpilibj.Jaguar;
    import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Timer;
import org.marswars.RobotMap;

public class Pickup extends Subsystem {
    
    private Relay leftPickup = new Relay(RobotMap.leftPickup);
    private Relay rightPickup = new Relay(RobotMap.rightPickup);
    
    private Relay leftPickupRoller = new Relay(RobotMap.leftPickupRoller);
    private Relay rightPickupRoller = new Relay(RobotMap.rightPickupRoller);

    public void initDefaultCommand() {
        
    }
    
    public void openPickup() {
        
        leftPickup.set(Relay.Value.kForward);
        rightPickup.set(Relay.Value.kForward);
        /*Timer.delay(1);
        leftPickup.set(Relay.Value.kOff);
        rightPickup.set(Relay.Value.kOff);*/
        
    }
    
    public void closePickup() {
        
        leftPickup.set(Relay.Value.kReverse);
        rightPickup.set(Relay.Value.kReverse);
        /*Timer.delay(1);
        leftPickup.set(Relay.Value.kOff);
        rightPickup.set(Relay.Value.kOff);*/
        
    }
    
    public void inPickupRoller()  {
        
        leftPickupRoller.set(Relay.Value.kForward);
        rightPickupRoller.set(Relay.Value.kForward);
        
    }
    
    public void outPickupRoller()  {
        
        leftPickupRoller.set(Relay.Value.kReverse);
        rightPickupRoller.set(Relay.Value.kReverse);
        
    }
    
    public void offPickupRoller() {
        
        leftPickupRoller.set(Relay.Value.kOff);
        rightPickupRoller.set(Relay.Value.kOff);
        
    }
    
    public void offPickup() {
        
        leftPickup.set(Relay.Value.kOff);
        rightPickup.set(Relay.Value.kOff);
        
    }
    
}

