// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.wheelIDs_and_controller;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;


public class RobotContainer {
  private final DriveTrain driveTrain = new DriveTrain();

  private final CommandXboxController m_driverController =
      new CommandXboxController(wheelIDs_and_controller.kDriverControllerPort);


  public RobotContainer() {
    configureBindings();
    driveTrain.setDefaultCommand(
      new RunCommand(() -> 
        driveTrain.Arcade_Drive(
        -m_driverController.getLeftY(), m_driverController.getRightX())
        , driveTrain)
    );  
  }

 
  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return new SequentialCommandGroup(
      new RunCommand(()-> driveTrain.Arcade_Drive(0.7, 0), driveTrain).withTimeout(10),
      new RunCommand(()-> driveTrain.Arcade_Drive(0, 0.5), driveTrain).withTimeout(2)
    );
  }
    
}
