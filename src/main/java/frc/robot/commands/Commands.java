package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.Robot;

public class Commands {
  public static final Command conveyorPull = new RunCommand(() -> Robot.conveyorRunner.pull(), Robot.conveyorRunner);
  public static final Command conveyorEject = new RunCommand(() -> Robot.conveyorRunner.eject(), Robot.conveyorRunner);
  public static final Command conveyorStop = new InstantCommand(() -> Robot.conveyorRunner.stop(),
      Robot.conveyorRunner);
  public static final Command shooterStop = new InstantCommand(() -> Robot.shooterRunner.start(),
      Robot.shooterRunner);
  public static final Command shooterStart = new InstantCommand(() -> Robot.shooterRunner.stop(),
      Robot.shooterRunner);
}
