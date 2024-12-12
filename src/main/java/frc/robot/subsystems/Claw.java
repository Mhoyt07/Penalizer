// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Claw extends SubsystemBase {
  /** Creates a new claw. */
  CANSparkMax motor;
  RelativeEncoder claw_encoder;

  public PIDController claw_pid;
  
  public Claw() {
    //motor stuff
    motor = new CANSparkMax(Constants.claw.motor_id, MotorType.kBrushless);

    motor.setIdleMode(IdleMode.kBrake);

    motor.setInverted(false);

    //encoder
    claw_encoder = motor.getEncoder();


    //pid stuff
    claw_pid = new PIDController(Constants.claw.kP, Constants.claw.kI, Constants.claw.kD);



  }

  public void set_voltage(double voltage) {
    motor.setVoltage(voltage);
  }

  public void reset_encoder() {
    claw_encoder.setPosition(0);
  }

  public double current_pos() {
    return claw_encoder.getPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
