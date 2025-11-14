package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends SubsystemBase {

    private final SparkMax M_LeftFront = 
    new SparkMax(Constants.wheelIDs_and_controller.LeftFrontID, MotorType.kBrushless);
    private final SparkMax M_RightFront = 
    new SparkMax(Constants.wheelIDs_and_controller.RightFrontID, MotorType.kBrushless);
    private final SparkMax M_LeftBack = 
    new SparkMax(Constants.wheelIDs_and_controller.LeftBackID, MotorType.kBrushless);
    private final SparkMax M_RightBack = 
    new SparkMax(Constants.wheelIDs_and_controller.RightBackID, MotorType.kBrushless);

    private final MotorControllerGroup left_wheels = new MotorControllerGroup(M_LeftFront,M_LeftBack);
    private final MotorControllerGroup right_wheels = new MotorControllerGroup(M_RightFront,M_RightBack);

    private final DifferentialDrive wheels = new DifferentialDrive(left_wheels, right_wheels);

    public DriveTrain(){
        right_wheels.setInverted(true);
    }
    public void Arcade_Drive(double speed, double rotation){
        wheels.arcadeDrive(speed, rotation);
    }

}
