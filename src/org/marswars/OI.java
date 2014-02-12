
package org.marswars;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.marswars.commands.ExampleCommand;
import org.marswars.utilities.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    private XboxController xbox = new XboxController(1);
    private double deadZone = 0.15;
    
    public OI() {
        new JoystickButton(xbox, XboxController.ButtonType.kStart.value).whileHeld(new ExampleCommand());
    }
    
    public double getJoystickLeftX() {
        if (Math.abs(xbox.getRawAxis(1)) < deadZone) {
            return 0;
        } else {
            return xbox.getRawAxis(1);
        }
    }

    public double getJoystickLeftY() {
        if (Math.abs(xbox.getRawAxis(2)) < deadZone) {
            return 0;
        } else {
            return xbox.getRawAxis(2);
        }
    }

    public double getJoystickRightX() {
        if (Math.abs(xbox.getRawAxis(4)) < deadZone) {
            return 0;
        } else {
            return xbox.getRawAxis(4);
        }
    }

    public double getTriggers() {
        if (Math.abs(xbox.getRawAxis(3)) < deadZone) {
            return 0;
        } else {
            return xbox.getRawAxis(3);
        }
    }
    
    public double getDPadX() {
        return xbox.getRawAxis(6);
    }
}

