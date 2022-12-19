// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Commands;
// import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.commands.StartDriving;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static Chassis chassis;
  public static Conveyor conveyor;
  public static Shooter shooter;
  public static XboxController xbox;
  public static JoystickButton conveyorPullButton;
  public static JoystickButton conveyorEjectButton;
  public static JoystickButton shootersOn;
  public static JoystickButton shootersOff;

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    chassis = new Chassis();
    conveyor = new Conveyor();
    shooter = new Shooter();
    configureButtonBindings();

    chassis.setDefaultCommand(new StartDriving());

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    xbox = new XboxController(0);
    conveyorEjectButton = new JoystickButton(xbox, Constants.BTN_B);
    conveyorPullButton = new JoystickButton(xbox, Constants.BTN_Y);
    shootersOff = new JoystickButton(xbox, Constants.BTN_A);
    shootersOn = new JoystickButton(xbox, Constants.BTN_B);

    conveyorEjectButton.whenPressed(Commands.conveyorEject);
    conveyorEjectButton.whenReleased(Commands.conveyorStop);
    conveyorPullButton.whenPressed(Commands.conveyorPull);
    conveyorPullButton.whenReleased(Commands.conveyorStop);
    shootersOn.whenPressed(Commands.shooterStart);
    shootersOff.whenPressed(Commands.shooterStop);
  }

  public static double getYLeft() {
    double kleft = xbox.getLeftY();
    if (Math.abs(kleft) <= 0.1) {
      return 0;
    } else {
      return -kleft * Math.abs(kleft); // Math.abs to preserve sign
    }
  }

  public static double getYRight() {
    double kright = xbox.getRightY();
    if (Math.abs(kright) <= 0.1) {
      return 0;
    } else {
      return kright * Math.abs(kright); // Math.abs to preserve sign
    }
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new StartDriving();
  }
}