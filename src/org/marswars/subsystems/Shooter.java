package org.marswars.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.marswars.RobotMap;

public class Shooter extends PIDSubsystem {

    /////Motor and Potentiometer/////
    Talon motor = new Talon(RobotMap.portMotorShooter);/* <-<-<- REMEMBER TO SET IN ROBOTMAP!!!!!*/
    AnalogChannel pot = new AnalogChannel(RobotMap.portPotShooter);/* <-<-<- REMEMBER TO SET IN ROBOTMAP!!!!!*/

    /////Other Variables/////

    /////Set Potentiometer Stuff/////
    public Shooter() {
        super("Shooter", 1.0, 0.0, 0.2);
        this.setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(true);
        this.setInputRange(0.2, 4.8);
        LiveWindow.addSensor("Shooter", "Pot", pot);
        LiveWindow.addActuator("Shooter", "Motor", motor);
        LiveWindow.addActuator("Shooter", "PID", getPIDController());
        this.enable(); //enables the portPotShooter
        this.setSetpoint(pot.getVoltage()); //Sets the CAM to the ready position for launching when robot is  first enabled
    }

    /////Print out Position/////
    public void readPot() {
        System.out.println(this.getPosition());
    }

    /////Sets CAM to ready position for launching/////
    public void setReadyPosition(int position) {
        if (position == 1) {
            this.setSetpointRelative(Preferences.getInstance().getDouble("Position 1", 1.));/* <-<-<- THIS VALUE WILL CHANGE WHEN I CAN TEST ROBOT*/
        } else if (position == 2) {
            this.setSetpointRelative(Preferences.getInstance().getDouble("Position 2", 2.));/* <-<-<- THIS VALUE WILL CHANGE WHEN I CAN TEST ROBOT*/
        } else if (position == 3) {
            this.setSetpointRelative(Preferences.getInstance().getDouble("Position 3", 3.));/* <-<-<- THIS VALUE WILL CHANGE WHEN I CAN TEST ROBOT*/
        }
    }

    public void launch(double speed) {
        this.disable();
        motor.set(speed);/* <-<-<- THIS VALUE CONTROLS SPEED OF SHOOTER*/
        Timer.delay(Preferences.getInstance().getDouble("Launch time", 1.));
        motor.set(0.0);
        this.enable();
        this.setSetpoint(pot.getVoltage());
    }

    public void initDefaultCommand() {
    }

    //returnPIDInput and usePIDOutput are necessary for this subsystem, but are not used in commands
    public double returnPIDInput() {
        return pot.getAverageVoltage();
    }

    public void usePIDOutput(double output) {
        motor.pidWrite(output);
    }
}
