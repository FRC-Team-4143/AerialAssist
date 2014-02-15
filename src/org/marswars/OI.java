
package org.marswars;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.marswars.commands.Launch;
import org.marswars.commands.Pass;
import org.marswars.commands.PickupClose;
import org.marswars.commands.PickupOpen;
import org.marswars.commands.ReadPot;
import org.marswars.commands.ResetTurns;
import org.marswars.commands.RetrieveOffsets;
import org.marswars.commands.RollerLeft;
import org.marswars.commands.RollerRight;
import org.marswars.commands.RollersDirection;
import org.marswars.commands.SMDB;
import org.marswars.commands.SetCamOne;
import org.marswars.commands.SetCamThree;
import org.marswars.commands.SetCamTwo;
import org.marswars.commands.SetWheelOffsets;
import org.marswars.commands.ToggleLock;
import org.marswars.commands.ToggleRobotFront;
import org.marswars.commands.UnwindFL;
import org.marswars.commands.UnwindFR;
import org.marswars.commands.UnwindRL;
import org.marswars.commands.UnwindRR;
import org.marswars.utilities.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    private XboxController xbox1 = new XboxController(1);
    private XboxController xbox2 = new XboxController(2);
    private double deadZone = Preferences.getInstance().getDouble("Deadzone", 0.15);
    
    public OI() {
        // Controller 1
        new JoystickButton(xbox1, XboxController.ButtonType.kY.value).whenPressed(new ToggleRobotFront());
        new JoystickButton(xbox1, XboxController.ButtonType.kX.value).whileHeld(new ToggleLock());
        new JoystickButton(xbox1, XboxController.ButtonType.kA.value).whenPressed(new Launch());
        new JoystickButton(xbox1, XboxController.ButtonType.kB.value).whenPressed(new Pass());
        
        // Controller 2
        new JoystickButton(xbox2, XboxController.ButtonType.kL.value).whileHeld(new RollerLeft());
        new JoystickButton(xbox2, XboxController.ButtonType.kR.value).whileHeld(new RollerRight());
        new JoystickButton(xbox2, XboxController.ButtonType.kY.value).whenPressed(new RollersDirection());
        new JoystickButton(xbox2, XboxController.ButtonType.kA.value).whileHeld(new PickupOpen());
        new JoystickButton(xbox2, XboxController.ButtonType.kB.value).whileHeld(new PickupClose());
        
        // Smart Dashboard
        SmartDashboard.putData("Read Pot", new ReadPot());
        SmartDashboard.putData("Position 1", new SetCamOne());
        SmartDashboard.putData("Position 2", new SetCamTwo());
        SmartDashboard.putData("Position 3", new SetCamThree());
        SmartDashboard.putData("Launch", new Launch());
        SmartDashboard.putData("SetWheelOffsets", new SetWheelOffsets());
        SmartDashboard.putData("ResetTurns", new ResetTurns());
        //SmartDashboard.putData("SMDB", new SMDB());
        SmartDashboard.putData("Unwind FL", new UnwindFL());
        SmartDashboard.putData("Unwind FR", new UnwindFR());
        SmartDashboard.putData("Unwind RL", new UnwindRL());
        SmartDashboard.putData("Unwind RR", new UnwindRR());
        SmartDashboard.putData("Retrieve Offsets", new RetrieveOffsets());
    }
    
    public double getJoystickLeftX() {
        if (Math.abs(xbox1.getRawAxis(1)) < deadZone) {
            return 0;
        } else {
            return xbox1.getRawAxis(1);
        }
    }

    public double getJoystickLeftY() {
        if (Math.abs(xbox1.getRawAxis(2)) < deadZone) {
            return 0;
        } else {
            return xbox1.getRawAxis(2);
        }
    }

    public double getJoystickRightX() {
        if (Math.abs(xbox1.getRawAxis(4)) < deadZone) {
            return 0;
        } else {
            return xbox1.getRawAxis(4);
        }
    }

    public double getTriggers() {
        if (Math.abs(xbox1.getRawAxis(3)) < deadZone) {
            return 0;
        } else {
            return xbox1.getRawAxis(3);
        }
    }
    
    public double getDPadX() {
        return xbox1.getRawAxis(6);
    }
}

