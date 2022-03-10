// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/** This is a demo program showing how to use Mecanum control with the MecanumDrive class. */
public class Robot extends TimedRobot {
  private static final int kFrontLeftChannel = 4;
  private static final int kFrontRightChannel =5;
  private static final int kRearLeftChannel = 2;
  private static final int kRearRightChannel = 1;

  private static final int lJoystickChannel = 0;
  WPI_TalonSRX minicim;
 /* WPI_TalonSRX mytalon1 = new WPI_TalonSRX(1);
  WPI_TalonSRX mytalon2 = new WPI_TalonSRX(2);
  WPI_TalonSRX mytalon3 = new WPI_TalonSRX(3);
  WPI_TalonSRX mytalon4 = new WPI_TalonSRX(4);
  WPI_TalonSRX mytalon5 = new WPI_TalonSRX(5);*/
 // Joystick joystick1 = new Joystick(1);
 private static final int rJoystickChannel = 1;


  private MecanumDrive m_robotDrive;
  private Joystick l_stick;
 // private Joystick r_stick;

  @Override
  public void robotInit() {
    //mytalon1.set(ControlMode.PercentOutput, 0);
    WPI_TalonSRX frontLeft = new  WPI_TalonSRX(kFrontLeftChannel);
    WPI_TalonSRX rearLeft = new WPI_TalonSRX(kRearLeftChannel);
    WPI_TalonSRX frontRight = new WPI_TalonSRX(kFrontRightChannel);
    WPI_TalonSRX rearRight = new WPI_TalonSRX(kRearRightChannel);
    minicim = new WPI_TalonSRX(3);
    // Invert the right side motors.
    // You may need to change or remove this to match your robot.
    frontRight.setInverted(true);
    rearRight.setInverted(true);

    m_robotDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);

    l_stick = new Joystick(lJoystickChannel);
    //r_stick = new Joystick(rJoystickChannel);
    
    
  }
  @Override
  public void autonomousPeriodic(){
    minicim.set(0.5);
    m_robotDrive.driveCartesian(0.7, 0.0, 0.0, 0.0);
  }

  @Override
  public void teleopPeriodic() {
    boolean button1 = l_stick.getRawButton(1);
    if (button1){
        minicim.set(0.5);
      }
   /* double stick = joystick1.getRawAxis(1);
    mytalon2.set(ControlMode.PercentOutput, stick);
    mytalon3.set(ControlMode.PercentOutput, 0);
    mytalon4.set(ControlMode.PercentOutput, stick);
    mytalon5.set(ControlMode.PercentOutput, stick);
    mytalon1.set(ControlMode.PercentOutput, stick);*/
    // Use the joystick X axis for lateral movement, Y axis for forward
    // movement, and Z axis for rotation.
    m_robotDrive.driveCartesian(-l_stick.getX(), l_stick.getY(), -l_stick.getRawAxis(4), 0.0);
    //4 is the X axis of right Joystick
    //this is a test comment
    //test comment #2
    //test comment #1a
    //TEST COMMENT
  }


}
