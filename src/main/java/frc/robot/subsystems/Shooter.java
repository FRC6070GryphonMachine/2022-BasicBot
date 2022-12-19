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
import frc.robot.Constants;
import frc.robot.commands.Commands;

public class Shooter extends SubsystemBase {
  /**
   * Creates new shooter mechanism (right and left SparkMaxes).
   */

  CANSparkMax shooterLeft;
  CANSparkMax shooterRight;

  public Shooter() {
    shooterLeft = new CANSparkMax(Constants.LEFT_SHOOTER_SPARK_ID, MotorType.kBrushed);
    shooterRight = new CANSparkMax(Constants.RIGHT_SHOOTER_SPARK_ID, MotorType.kBrushed);
    setDefaultCommand(Commands.shooterStop);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void start() {
    shooterLeft.set(Constants.MAX_SHOOTER_SPEED);
    shooterRight.set(-Constants.MAX_SHOOTER_SPEED);
  }

  public void stop() {
    shooterRight.stopMotor();
    shooterLeft.stopMotor();
  }
}