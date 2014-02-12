package org.marswars.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.marswars.RobotMap;

public class Shooter extends PIDSubsystem {

    /////Motor and Potentiometer/////
    Talon motor = new Talon(RobotMap.potMotor);/* <-<-<- REMEMBER TO SET IN ROBOTMAP!!!!!*/

    AnalogChannel pot = new AnalogChannel(RobotMap.potentiometer);/* <-<-<- REMEMBER TO SET IN ROBOTMAP!!!!!*/

    /////Other Variables/////

    /////Set Potentiometer Stuff/////
    public Shooter() {
        super("Shooter", 1.0, 0.0, 0.0);
        this.setAbsoluteTolerance(0.1);
        getPIDController().setContinuous(false);
        this.setInputRange(0.0, 5.0);
        pot.startLiveWindowMode();
        LiveWindow.addSensor("Shooter", "pot", pot);
        LiveWindow.addActuator("Shooter", "Shooter Pot", pot);
        LiveWindow.run();
        this.enable(); //enables the potentiometer
        this.setSetpoint(0.0); //Sets the CAM to the ready position for launching when robot is  first enabled

    }

    /////Print out Position/////
    public void readPot() {
        System.out.println(this.getPosition());
    }

    /////Sets CAM to ready position for launching/////
    public void setReadyPosition(int position) {
        if (position == 1) {
            this.setSetpointRelative(-1.0);/* <-<-<- THIS VALUE WILL CHANGE WHEN I CAN TEST ROBOT*/

        } else if (position == 2) {
            this.setSetpointRelative(-1.0);/* <-<-<- THIS VALUE WILL CHANGE WHEN I CAN TEST ROBOT*/

        } else if (position == 3) {
            this.setSetpointRelative(-1.0);/* <-<-<- THIS VALUE WILL CHANGE WHEN I CAN TEST ROBOT*/

        }
    }

    public void launch() {
        double endPoint = 2.5;
        this.disable();

        try {
            this.wait(2);
        } catch (InterruptedException ex) {
            System.out.println("ERROR!");
        }

        motor.set(1.0);/* <-<-<- THIS VALUE CONTROLS SPEED OF SHOOTER*/

        try {
            this.wait(2);/* <-<-<- THIS VALUE CONTROLS HOW LONG THE MOTOR IS ACTIVE*/

        } catch (InterruptedException ex) {
            System.out.println("ERROR!");
        }

        motor.set(0.0);
        this.enable();
        this.setSetpointRelative(endPoint - this.getPosition());

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
