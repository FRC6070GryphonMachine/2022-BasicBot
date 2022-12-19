// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  // Chassis (you might need to change these)
  // Talons are talons, slaves are VictorSPXs that are slaved to the Talons

  // === MOTOR PORT/ID CONFIGURATIONS ===
  public static final int leftSlave = 1;
  public static final int leftTalon = 0;
  public static final int rightSlave = 3;
  public static final int rightTalon = 2;

  public static final int CONVEYOR_SPARK_ID = 6;
  public static final int RIGHT_SHOOTER_SPARK_ID = 5;
  public static final int LEFT_SHOOTER_SPARK_ID = 7;

  // === JOYSTICK BUTTONS ===
  // TODO: Configure these
  public static final int BTN_A = 0;
  public static final int BTN_B = 1;
  public static final int BTN_X = 2;
  public static final int BTN_Y = 3;

  // === THRESHOLD VALUES ===
  public static final double MAX_CONVEYOR_SPEED = 0.5;
  public static final double MAX_SHOOTER_SPEED = 0.5;
}
