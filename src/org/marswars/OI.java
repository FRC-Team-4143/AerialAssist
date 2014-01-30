
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
    
    public OI() {
        new JoystickButton(xbox, XboxController.ButtonType.kStart.value).whileHeld(new ExampleCommand());
    }
}

