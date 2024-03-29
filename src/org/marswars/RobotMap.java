package org.marswars;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    public static final int motorShooter = 1;
    
    public static final boolean CONTINUOUS = true;
    public static final double P = 1.0;
    public static final double I = 0.0;
    public static final double D = 0.2;
    public static final double F = 0.0;
    public static final double POTMIN = 0.0;
    public static final double POTMAX = 5.0;
    public static final double STEERPOW = 1.0;
    public static final double TOLERANCE = 0.2;
    public static final double PERIOD = 0.02;
    
    public static final int portPotSteerFR = 1;
    public static final int portPotSteerRL = 4;
    public static final int portPotSteerRR = 2;
    public static final int portPotSteerFL = 3;
    
    public static final int portMotorDriveFL = 3;
    public static final int portMotorDriveFR = 4;
    public static final int portMotorDriveRR = 1;
    public static final int portMotorDriveRL = 2;
    
    public static final int portMotorSteerFR = 6;
    public static final int portMotorSteerRL = 8;
    public static final int portMotorSteerRR = 5;
    public static final int portMotorSteerFL = 7;
    
    public static final int portPotShooter = 5;
    public static final int portMotorShooter = 9;
    
    public final static int portRelayPickupL = 3;
    public final static int portRelayPickupR = 1;
    
    public final static int portSolenoidLeftRetract = 1;
    public final static int portSolenoidLeftExtend = 2;
    public final static int portSolenoidRightRetract = 3;
    public final static int portSolenoidRightExtend = 4;
    public final static int portSolenoidBackExtend = 5;
    public final static int portSolenoidBackRetract = 6;
    public final static int portCompressorPressure = 1;
    public final static int portCompressorRelay = 2;
    
    public final static int portPressureSwitch = 1;
}
