
package org.marswars.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.marswars.RobotMap;

/**
 *
 */
public class Shooter extends Subsystem {
    
    private Talon motorShooter = new Talon(RobotMap.motorShooter);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void shoot(double speed) {
        motorShooter.set(speed);
    }
    
    public void stop() {
        motorShooter.stopMotor();
    }
}

