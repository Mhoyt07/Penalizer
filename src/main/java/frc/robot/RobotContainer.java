// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.CamAllign;
import frc.robot.commands.CloseClaw;
import frc.robot.subsystems.CameraMotor;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final Claw claw = new Claw();
  private final Drivetrain dt = new Drivetrain();
  private final CameraMotor cam = new CameraMotor();

  //Joysticks
  private final Joystick joystick_1 = new Joystick(0);
  private final Joystick joystick_2 = new Joystick(1);

  //Joystick Buttons Joystick 1
  //button 1
  private final JoystickButton cam_allign_button = new JoystickButton(joystick_1, 1);
  //button 2
  private final JoystickButton open_claw_button = new JoystickButton(joystick_1, 2);
  //button 3
  private final JoystickButton close_claw_button = new JoystickButton(joystick_1, 3);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    dt.setDefaultCommand(new ArcadeDrive(dt, joystick_1, joystick_2));
    
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    
    close_claw_button.onTrue(new CloseClaw(claw));
    open_claw_button.onTrue(new CloseClaw(claw));
    cam_allign_button.whileTrue(new CamAllign(cam));
  }




  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomou
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
