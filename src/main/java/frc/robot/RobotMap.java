package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;
import frc.robot.util.COTSFalconSwerveConstants;
import frc.robot.util.SwerveModuleConstants;

public class RobotMap {

  public static final class DriveMap {
    public static final int PIGEON_ID = 9;
    public static final boolean INVERT_GYRO = false; // Always ensure Gyro is CCW+ CW-

    public static final COTSFalconSwerveConstants MODULE_TYPE = // TODO: This must be tuned to specific robot
        COTSFalconSwerveConstants.SDSMK4(COTSFalconSwerveConstants.DriveGearRatios.SDSMK4_L1);

    /* Drivetrain Constants */
    public static final double TRACK_WIDTH = Units.inchesToMeters(21.73); // TODO: This must be tuned to specific robot
    public static final double WHEEL_BASE = Units.inchesToMeters(21.73); // TODO: This must be tuned to specific robot
    public static final double WHEEL_CIRCUMFERENCE = MODULE_TYPE.wheelCircumference;

    /* PixyCam Constants */
    public static final double PIXYCAM_ROTATION_IN_DEGREES = 0.002 * 0.2; // TODO: Tune constant
    public static final double PIXYCAM_RESOLUTION = 320;
    public static final double PIXYCAM_PID_POSITION_TOLERANCE = 2;
    public static final double PIXYCAM_PID_VELOCITY_TOLERANCE = 50;

    /* PhotonVision Constants */
    public static final double PHOTON_PID_POSITION_TOLERANCE = 2;
    public static final double PHOTON_PID_VELOCITY_TOLERANCE = 10;
    public static final double APRILTAG_Y_OFFSET = -1.5;
    public static final double XPID_POSITION_TOLERANCE = 0.05;
    public static final double XPID_VELOCITY_TOLERANCE = 1;
    public static final double YPID_POSITION_TOLERANCE = 0.05;
    public static final double YPID_VELOCITY_TOLERANCE = 1;
    public static final double THETAPID_POSITION_TOLERANCE = 5;
    public static final double THETAPID_VELOCITY_TOLERANCE = 1;

    /*
     * Swerve Kinematics
     * No need to ever change this unless you are not doing a traditional
     * rectangular/square 4 module swerve
     */
    public static final SwerveDriveKinematics KINEMATICS = new SwerveDriveKinematics(
        new Translation2d(WHEEL_BASE / 2.0, TRACK_WIDTH / 2.0),
        new Translation2d(WHEEL_BASE / 2.0, -TRACK_WIDTH / 2.0),
        new Translation2d(-WHEEL_BASE / 2.0, TRACK_WIDTH / 2.0),
        new Translation2d(-WHEEL_BASE / 2.0, -TRACK_WIDTH / 2.0));

    /* Module Gear Ratios */
    public static final double DRIVE_GEAR_RATIO = MODULE_TYPE.driveGearRatio;
    public static final double ANGLE_GEAR_RATIO = MODULE_TYPE.angleGearRatio;

    /* Motor Inverts */
    public static final boolean ANGLE_MOTOR_INVERT = MODULE_TYPE.angleMotorInvert;
    public static final boolean DRIVE_MOTOR_INVERT = MODULE_TYPE.driveMotorInvert;

    /* Angle Encoder Invert */
    public static final boolean CAN_CODER_INVERT = MODULE_TYPE.canCoderInvert;

    /* Swerve Current Limiting */
    public static final int ROTATOR_CONTINUOS_CURRENT_LIMIT = 25;
    public static final int ROTATOR_PEAK_CURRENT_LIMIT = 40;
    public static final double ROTATOR_PEAK_CURRENT_DURATION = 0.1;
    public static final boolean LIMIT_ROTATOR_CURRENT = true;

    public static final int DRIVE_CONTINUOS_CURRENT_LIMIT = 35;
    public static final int DRIVE_PEAK_CURRENT_LIMIT = 60;
    public static final double DRIVE_PEAK_CURRENT_DURATION = 0.1;
    public static final boolean LIMIT_DRIVE_CURRENT = true;

    /*
     * These values are used by the drive falcon to ramp in open loop and closed
     * loop driving.
     * We found a small open loop ramp (0.25) helps with tread wear, tipping, etc
     */
    public static final double OPEN_LOOP_RAMP = 0.25;
    public static final double CLOSED_LOOP_RAMP = 0.0;

    /* Angle Motor PID Values */
    public static final double ROTATOR_KP = MODULE_TYPE.angleKP;
    public static final double ROTATOR_KI = MODULE_TYPE.angleKI;
    public static final double ROTATOR_KD = MODULE_TYPE.angleKD;
    public static final double ROTATOR_KF = MODULE_TYPE.angleKF;

    /* Drive Motor PID Values */
    public static final double DRIVE_KP = 0.3; // TODO: This must be tuned to specific robot
    public static final double DRIVE_KI = 0.1;
    public static final double DRIVE_KD = 0.02;
    public static final double DRIVE_KF = 0.0;

    /*
     * Drive Motor Characterization Values
     * Divide SYSID values by 12 to convert from volts to percent output for CTRE
     */
    public static final double DRIVE_KS = (0.32 / 12); // TODO: This must be tuned to specific robot
    public static final double DRIVE_KV = (1.51 / 12);
    public static final double DRIVE_KA = (0.27 / 12);

    /* Swerve Profiling Values */
    /** Meters per Second */
    public static final double MAX_VELOCITY = 5.4864; // TODO: This must be tuned to specific robot
    /** Radians per Second */
    public static final double MAX_ANGULAR_VELOCITY = 10.0; // TODO: This must be tuned to specific robot

    /* Meteres per second squared */
    public static final double MAX_ACCELERATION = 3; // TODO: TUNE THIS

    /* Neutral Modes */
    public static final NeutralMode ROTATOR_NEUTRAL_MODE = NeutralMode.Coast;
    public static final NeutralMode DRIVE_NEUTRAL_MODE = NeutralMode.Brake;

    /* Module Specific Constants */
    /* Front Left Module - Module 0 */
    public static final class FrontLeft { // TODO: This must be tuned to specific robot
      public static final int DRIVE_ID = 5;
      public static final int ROTATOR_ID = 6;
      public static final int ENCODER_ID = 11;
      public static final Rotation2d OFFSET = Rotation2d.fromDegrees(201.6);
      public static final SwerveModuleConstants CONSTANTS = new SwerveModuleConstants(DRIVE_ID, ROTATOR_ID, ENCODER_ID,
          OFFSET);
    }

    /* Front Right Module - Module 1 */
    public static final class FrontRight { // TODO: This must be tuned to specific robot
      public static final int DRIVE_ID = 3;
      public static final int ROTATOR_ID = 4;
      public static final int ENCODER_ID = 13;
      public static final Rotation2d OFFSET = Rotation2d.fromDegrees(279.4);
      public static final SwerveModuleConstants CONSTANTS = new SwerveModuleConstants(DRIVE_ID, ROTATOR_ID, ENCODER_ID,
          OFFSET);
    }

    /* Back Left Module - Module 2 */
    public static final class BackLeft { // TODO: This must be tuned to specific robot
      public static final int DRIVE_ID = 7;
      public static final int ROTATOR_ID = 8;
      public static final int ENCODER_ID = 12;
      public static final Rotation2d OFFSET = Rotation2d.fromDegrees(254.3);
      public static final SwerveModuleConstants CONSTANTS = new SwerveModuleConstants(DRIVE_ID, ROTATOR_ID, ENCODER_ID,
          OFFSET);
    }

    /* Back Right Module - Module 3 */
    public static final class BackRight { // TODO: This must be tuned to specific robot
      public static final int DRIVE_ID = 1;
      public static final int ROTATOR_ID = 2;
      public static final int ENCODER_ID = 10;
      public static final Rotation2d OFFSET = Rotation2d.fromDegrees(16.5);
      public static final SwerveModuleConstants CONSTANTS = new SwerveModuleConstants(DRIVE_ID, ROTATOR_ID, ENCODER_ID,
          OFFSET);
    }
  }

  public static class CameraMap {
    // Rename the cameras in phtonvision dashboard to the corresponding camera name
    public static final String CAMERA_ONE = "camscanner";
    public static final String CAMERA_TWO = "camscanner2";
    public static final String DRIVER_CAMERA = "drivercam";
    public static final double CAMERA_HEIGHT_METRES = -0.15;
    public static final double CAMERA_HEIGHT_METRES2 = 0.17;
    public static final double CAMERA_DEPTH_METRES = 0.17;
    public static final double CAMERA_DEPTH_METRES2 = 0.24;
    public static final double CAMERA_WIDTH_METRES = 0.41;
    public static final double TARGET_HEIGHT_METRES = 3.0;
    public static final double CAMERA_PITCH_RADIANS = 0.0;
    public static final Transform3d ROBOT_TO_CAM = new Transform3d(
        new Translation3d(CAMERA_WIDTH_METRES, CAMERA_HEIGHT_METRES, CAMERA_DEPTH_METRES), // X, Y, Z
        new Rotation3d(
            0, 5,
            0));
    public static final Transform3d ROBOT_TO_CAM_TWO = new Transform3d(
        new Translation3d(CAMERA_WIDTH_METRES, CAMERA_HEIGHT_METRES2, CAMERA_DEPTH_METRES2),
        new Rotation3d(
            0, 10, 0));

  }

  public static class FieldMap {
    public static final double FIELD_LENGTH = Units.feetToMeters(54);
    public static final double FIELD_WIDTH = Units.inchesToMeters(27);
  }

  public static class ControllerMap {
    public static final int DRIVER_JOYSTICK = 0;
    public static final int OPERATOR_JOYSTICK = 1;
    public static final double STICK_DEADBAND = 0.1;
  }

  public static class ChargingStationMap {
    // TODO tune once robot complete
    public static final double kP = 0.05;
    public static final double kI = 0.0;
    public static final double kD = 0.0;
    public static final double MAX_VELOCITY = 2;
  }

  public static class IntakeMap {
    public static final int MOTOR_ID = -1;
    public static final double kP = 0.1;
    public static final double kI = 0.0;
    public static final double kD = 0.1;
    public static final double OPENANGLE = 100;
    public static final double CLOSEANGLE = 10;
    public static final double BUFFER = 5;
  }

  public static class MotorIntakeMap {
    public static final int MOTOR_ID = 2;
  }

  public static class ElevatorMap {
    public static final int ELEVATOR_MOTOR_ID = 1;
    public static final int BOTTOM_PORT = 0;
    public static final int TOP_PORT = 1;
    public static final double MIDPOINT1 = 20; // arbitrary

    public static final int PIVOT_MOTOR_ID = 3;
    public static final double PIVOT_BOTTOM = 10; // arbitrary
    public static final double PIVOT_TOP = 20; // arbitrary
    public static final double MIDPOINT2 = 15; // arbitrary

    public static final double PIVOT_KS = 0;
    public static final double PIVOT_KG = 0;
    public static final double PIVOT_KV = 0;
    public static final double PIVOT_KA = 0;

    public static final double ELEVATOR_KS = 0;
    public static final double ELEVATOR_KG = 0;
    public static final double ELEVATOR_KV = 0;
    public static final double ELEVATOR_KA = 0;
  }

  public static class FrictionPadMap {
    // TODO: Change these ports
    public static final int FOWARD_CHANNEL_1 = 0;
    public static final int REVERSE_CHANNEL_1 = 1;

    public static final int FORWARD_CHANNEL_2 = 2;
    public static final int REVERSE_CHANNEL_2 = 3;

  }

  public static class PinkArmMap {
    public static final int PIVOT_PORT = 0;
    public static final int TELESCOPE_PORT = 0;
    public static final int PIVOT_RATIO = 100;
    public static final double PIVOT_MIN = 0;
    public static final double PIVOT_MAX = .75;
    public static final int TELESCOPE_RATIO = 40;
    public static final double TELESCOPE_MIN = 0;// assuming it starts as spooled as possible
    public static final double TELESCOPE_MAX = 4;// should be in terms of rotations of the larger gear

  }
}
