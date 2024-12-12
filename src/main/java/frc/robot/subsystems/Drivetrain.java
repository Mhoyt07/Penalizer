// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */

  CANSparkMax front_right;
  CANSparkMax front_left;
  CANSparkMax back_right;
  CANSparkMax back_left;
  
  public Drivetrain() {
    front_right = new CANSparkMax(Constants.dt.fr_id, MotorType.kBrushless);
    back_right = new CANSparkMax(Constants.dt.br_id, MotorType.kBrushless);
    front_left = new CANSparkMax(Constants.dt.fl_id, MotorType.kBrushless);
    back_left = new CANSparkMax(Constants.dt.bl_id, MotorType.kBrushless);

    //tells back motors to follow front motors
    back_right.follow(front_right);
    back_left.follow(front_left);

    back_right.setInverted(false);
    back_left.setInverted(false);
  }

  public double[] get_current_power() {
    return new double[] {
      front_right.get(),
      back_right.get(),
      front_left.get(),
      back_left.get()
    };
  }

  public void arcade(double ly, double rx) {
    front_right.set(-ly + rx);
    front_left.set(ly + rx);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //put current set power info for motors in smart dashboard
    SmartDashboard.putNumberArray("Motor Speeds(fr,br,fl,bl)", this.get_current_power());
  }
}
