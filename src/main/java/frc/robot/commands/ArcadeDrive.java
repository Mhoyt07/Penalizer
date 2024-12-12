// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class ArcadeDrive extends Command {
  Drivetrain dt;
  private Joystick r_joystick;
  private Joystick l_joystick;

  /** Creates a new ArcadeDrive. */
  public ArcadeDrive(Drivetrain dt, Joystick l_joystick, Joystick r_joystick) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.dt = dt;
    addRequirements(this.dt);

    this.l_joystick = l_joystick;
    this.r_joystick = r_joystick;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    this.dt.arcade(this.l_joystick.getY(), this.r_joystick.getX());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
