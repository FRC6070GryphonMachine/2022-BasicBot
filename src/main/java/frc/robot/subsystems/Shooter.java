/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

// import edu.wpi.first.wpilibj.Spark;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  /**
   * Creates a new Conveyor.
   */

  CANSparkMax leftShooter;
  CANSparkMax rightShooter;

  public Shooter() {
    leftShooter = new CANSparkMax(5, MotorType.kBrushed);
    rightShooter = new CANSparkMax(7, MotorType.kBrushed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void shoot() {
    leftShooter.set(0.75);
    rightShooter.set(0.75);
  }

  public void stop() {
    leftShooter.stopMotor();
    rightShooter.stopMotor();
  }
}