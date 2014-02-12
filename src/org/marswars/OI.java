
package org.marswars;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.marswars.commands.Launch;
import org.marswars.commands.ReadPot;
import org.marswars.commands.ResetTurns;
import org.marswars.commands.RetrieveOffsets;
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
    private XboxController xbox = new XboxController(1);
    private double deadZone = 0.15;
    
    public OI() {
        new JoystickButton(xbox, XboxController.ButtonType.kY.value).whenPressed(new ToggleRobotFront());
        new JoystickButton(xbox, XboxController.ButtonType.kX.value).whileHeld(new ToggleLock());
        SmartDashboard.putData("Read Pot", new ReadPot());
        SmartDashboard.putData("Position 1", new SetCamOne());
        SmartDashboard.putData("Position 2", new SetCamTwo());
        SmartDashboard.putData("Position 3", new SetCamThree());
        SmartDashboard.putData("Launch", new Launch());
        SmartDashboard.putData("SetWheelOffsets", new SetWheelOffsets());
        SmartDashboard.putData("ResetTurns", new ResetTurns());
        SmartDashboard.putData("SMDB", new SMDB());
        SmartDashboard.putData("Unwind FL", new UnwindFL());
        SmartDashboard.putData("Unwind FR", new UnwindFR());
        SmartDashboard.putData("Unwind RL", new UnwindRL());
        SmartDashboard.putData("Unwind RR", new UnwindRR());
        SmartDashboard.putData("Retrieve Offsets", new RetrieveOffsets());
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

