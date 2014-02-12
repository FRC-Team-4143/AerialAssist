
package org.marswars;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.marswars.commands.Launch;
import org.marswars.commands.ReadPot;
import org.marswars.commands.SetCamOne;
import org.marswars.commands.SetCamThree;
import org.marswars.commands.SetCamTwo;
import org.marswars.utilities.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    private XboxController xbox = new XboxController(1);
    private double deadZone = 0.15;
    
    public OI() {
        new JoystickButton(xbox, XboxController.ButtonType.kStart.value).whileHeld(new ReadPot());
        new JoystickButton(xbox, XboxController.ButtonType.kX.value).whileHeld(new SetCamOne());
        new JoystickButton(xbox, XboxController.ButtonType.kY.value).whileHeld(new SetCamTwo());
        new JoystickButton(xbox, XboxController.ButtonType.kB.value).whileHeld(new SetCamThree());
        new JoystickButton(xbox, XboxController.ButtonType.kA.value).whileHeld(new Launch());
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

