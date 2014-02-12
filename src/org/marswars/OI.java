
package org.marswars;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.marswars.commands.ClosePickUp;
import org.marswars.commands.ExampleCommand;
import org.marswars.commands.InPickUpRoller;
import org.marswars.commands.OpenPickUp;
import org.marswars.commands.OutPickUpRoller;
import org.marswars.utilities.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    private XboxController xbox = new XboxController(1);
    
    public OI() {
        new JoystickButton(xbox, XboxController.ButtonType.kL.value).whileHeld(new ClosePickUp());
        new JoystickButton(xbox, XboxController.ButtonType.kR.value).whileHeld(new OpenPickUp());
        new JoystickButton(xbox, XboxController.ButtonType.kB.value).whileHeld(new InPickUpRoller());
        new JoystickButton(xbox, XboxController.ButtonType.kA.value).whileHeld(new OutPickUpRoller());
    }
}

