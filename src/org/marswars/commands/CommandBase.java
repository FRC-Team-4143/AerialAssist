package org.marswars.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.marswars.OI;
import org.marswars.subsystems.Catcher;
import org.marswars.subsystems.Pickup;
import org.marswars.subsystems.Shooter;
import org.marswars.subsystems.SwerveDrive;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static SwerveDrive drive = new SwerveDrive();
    public static Shooter shooter = new Shooter();
    public static Catcher catcher = new Catcher();
    public static Pickup pickup = new Pickup();

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(drive);
        SmartDashboard.putData(shooter);
        SmartDashboard.putData(catcher);
        SmartDashboard.putData(pickup);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
