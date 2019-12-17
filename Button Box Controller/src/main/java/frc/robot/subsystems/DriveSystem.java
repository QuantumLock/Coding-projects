/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * Add your docs here.
 */
public class DriveSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private final WPI_TalonSRX frontRightDrive;
  private final WPI_TalonSRX frontLeftDrive;
  private final WPI_TalonSRX rearRightDrive;
  private final WPI_TalonSRX rearLeftDrive;

  private final SpeedControllerGroup leftMotors;
  private final SpeedControllerGroup rightMotors;
  private final DifferentialDrive rDrive;

  public DriveSystem() {
    frontRightDrive = new WPI_TalonSRX(0);
    frontLeftDrive = new WPI_TalonSRX(1);
    rearRightDrive = new WPI_TalonSRX(2);
    rearLeftDrive = new WPI_TalonSRX(3);

    leftMotors = new SpeedControllerGroup(frontRightDrive, frontLeftDrive);
    rightMotors = new SpeedControllerGroup(rearRightDrive, rearRightDrive);

    rDrive = new DifferentialDrive(leftMotors, rightMotors);
  }

  public void buttonArcadeDrive(Button buttonOne, Button buttonTwo, Joystick stick) {
  if (buttonOne.get()) {
    rDrive.arcadeDrive(0.50, 0);
    
  } else if (buttonTwo.get()) {
   rDrive.arcadeDrive(-0.50, 0);

  } 
  rDrive.arcadeDrive(0, stick.getRawAxis(4));
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
