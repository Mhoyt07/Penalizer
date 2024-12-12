// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Claw;

public class CloseClaw extends Command {
  Claw claw;

  /** Creates a new CloseClaw. */
  public CloseClaw(Claw claw) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.claw = claw;
    addRequirements(this.claw);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double current_pos = this.claw.current_pos();
    claw.set_voltage(MathUtil.clamp(claw.claw_pid.calculate(current_pos, Constants.claw.close), -12, 12));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (claw.current_pos() != Constants.claw.close) {
      return false;
    } else {
      return true;
    }
  }
}
