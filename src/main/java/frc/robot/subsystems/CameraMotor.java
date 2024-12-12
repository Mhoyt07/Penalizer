// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.LimelightHelpers;

public class CameraMotor extends SubsystemBase {
  /** Creates a new CameraMotor. */
  CANSparkMax motor;
  double x_off;
  PIDController pid;
  double voltage;
  public CameraMotor() {
    motor = new CANSparkMax(Constants.cam.id, MotorType.kBrushless);
    motor.setSmartCurrentLimit(Constants.cam.current_limit);

    this.x_off = 0;
    
    pid = new PIDController(Constants.cam.kp, Constants.cam.ki, Constants.cam.kd);
  }

  public void reset_x() {
    this.x_off = 0;
  }

  public void allign() {
    this.x_off = LimelightHelpers.getTX("");
    voltage = pid.calculate(this.x_off, Constants.cam.x_target);
    motor.setVoltage(MathUtil.clamp(voltage, -12, 12));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
