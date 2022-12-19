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

public class Conveyor extends SubsystemBase {
  /**
   * Creates a new Conveyor.
   */

  CANSparkMax conveyor;
  
  public Conveyor() {
    conveyor = new CANSparkMax(Constants.CONVEYOR_SPARK_ID, MotorType.kBrushed);
    setDefaultCommand(Commands.conveyorStop);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void pull(){
    conveyor.set(Constants.MAX_CONVEYOR_INTAKE_SPEED);
  }

  public void eject(){
    conveyor.set(-Constants.MAX_CONVEYOR_EJECT_SPEED);
  }

  public void stop(){
    conveyor.stopMotor();
  }
}