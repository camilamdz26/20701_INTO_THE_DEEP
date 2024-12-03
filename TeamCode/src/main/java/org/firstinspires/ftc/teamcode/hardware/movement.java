package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class movement {
    
    static double rotations;
    static double ticks;


    public static void left(double distance, Telemetry telemetry, DcMotor BL, DcMotor BR, DcMotor FL, DcMotor FR) {
        reset_encoders(BL, BR, FL, FR);
        rotations = distance * 21.74;
        // SET TARGET POSITION
        FR.setTargetPosition((int) rotations);
        FL.setTargetPosition((int) -rotations);
        BL.setTargetPosition((int) rotations);
        BR.setTargetPosition((int) -rotations);
        // RUN TO POSITION
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        // POWER (left slide)
        ((DcMotorEx) FR).setVelocity(1000);
        ((DcMotorEx) FL).setVelocity(-1000);
        ((DcMotorEx) BL).setVelocity(1000);
        ((DcMotorEx) BR).setVelocity(-1000);
        while (BL.isBusy() && BR.isBusy() && FL.isBusy() && FR.isBusy()) {
            telemetry.addData("function", "left");
            motor_telemetry(telemetry, BL, BR, FL, FR);
            telemetry.update();
        }
    }

    /**
     * Describe this function...
     */
    public static void forward(int distance, Telemetry telemetry, DcMotor BL, DcMotor BR, DcMotor FL, DcMotor FR) {
        reset_encoders(BL, BR, FL, FR);
        rotations = distance * 21.74;
        // SET TARGET POSITION
        FR.setTargetPosition((int) rotations);
        FL.setTargetPosition((int) rotations);
        BL.setTargetPosition((int) rotations);
        BR.setTargetPosition((int) rotations);
        // RUN TO POSITION
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        // POWER (left slide)
        ((DcMotorEx) FR).setVelocity(1000);
        ((DcMotorEx) FL).setVelocity(1000);
        ((DcMotorEx) BL).setVelocity(1000);
        ((DcMotorEx) BR).setVelocity(1000);
        while (BL.isBusy() && BR.isBusy() && FL.isBusy() && FR.isBusy()) {
            telemetry.addData("function", "forward...");
            motor_telemetry(telemetry, BL, BR, FL, FR);
            telemetry.update();
        }
    }


    /**
     * Describe this function...
     */
    public static void backward(double distance, Telemetry telemetry, DcMotor BL, DcMotor BR, DcMotor FL, DcMotor FR) {
        reset_encoders(BL, BR, FL, FR);
        rotations = distance * 21.74;
        // SET TARGET POSITION
        FR.setTargetPosition((int) -rotations);
        FL.setTargetPosition((int) -rotations);
        BL.setTargetPosition((int) -rotations);
        BR.setTargetPosition((int) -rotations);
        // RUN TO POSITION
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        // POWER (left slide)
        ((DcMotorEx) FR).setVelocity(-1000);
        ((DcMotorEx) FL).setVelocity(-1000);
        ((DcMotorEx) BL).setVelocity(-1000);
        ((DcMotorEx) BR).setVelocity(-1000);
        while (BL.isBusy() && BR.isBusy() && FL.isBusy() && FR.isBusy()) {
            telemetry.addData("function", "backward");
            motor_telemetry(telemetry, BL, BR, FL, FR);
            telemetry.update();
        }
    }

    /**
     * Describe this function...
     */
    public static void right(double distance, Telemetry telemetry, DcMotor BL, DcMotor BR, DcMotor FL, DcMotor FR) {
        reset_encoders(BL, BR, FL, FR);
        rotations = distance * 21.74;
        // SET TARGET POSITION
        FR.setTargetPosition((int) -rotations);
        FL.setTargetPosition((int) rotations);
        BL.setTargetPosition((int) -rotations);
        BR.setTargetPosition((int) rotations);
        // RUN TO POSITION
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        // POWER (left slide)
        ((DcMotorEx) FR).setVelocity(-1000);
        ((DcMotorEx) FL).setVelocity(1000);
        ((DcMotorEx) BL).setVelocity(-1000);
        ((DcMotorEx) BR).setVelocity(1000);
        while (BL.isBusy() && BR.isBusy() && FL.isBusy() && FR.isBusy()) {
            telemetry.addData("function", "right");
            motor_telemetry(telemetry, BL, BR, FL, FR);
            telemetry.update();
        }
    }

    /**
     * Describe this function...
     */
    public static void reset_encoders(DcMotor BL, DcMotor BR, DcMotor FL, DcMotor FR) {
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public static void reset_linear_encoders(DcMotor motorLinearSlideLeft, DcMotor motorLinearSlideRight) {
        motorLinearSlideLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorLinearSlideRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    /**
     * Describe this function...
     */
    public static void motor_telemetry(Telemetry telemetry, DcMotor BL, DcMotor BR, DcMotor FL, DcMotor FR) {
        telemetry.addData("back left pos", BL.getCurrentPosition());
        telemetry.addData("back right pos", BR.getCurrentPosition());
        telemetry.addData("front left pos", FL.getCurrentPosition());
        telemetry.addData("front right pos", FR.getCurrentPosition());
        telemetry.update();


    }

    //rotation right
    public static void rotationRight(double degrees, Telemetry telemetry, DcMotor BL, DcMotor BR, DcMotor FL, DcMotor FR) {
        reset_encoders(BL, BR, FL, FR);
        rotations = degrees * 14;
        // SET TARGET POSITION
        FR.setTargetPosition((int) -rotations);
        FL.setTargetPosition((int) rotations);
        BL.setTargetPosition((int) rotations);
        BR.setTargetPosition((int) -rotations);
        // RUN TO POSITION
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        // POWER (left slide)
        ((DcMotorEx) FR).setVelocity(-1000);
        ((DcMotorEx) FL).setVelocity(1000);
        ((DcMotorEx) BL).setVelocity(1000);
        ((DcMotorEx) BR).setVelocity(-1000);
        while (BL.isBusy() && BR.isBusy() && FL.isBusy() && FR.isBusy()) {
            telemetry.addData("function", "rotation right");
            motor_telemetry(telemetry, BL, BR, FL, FR);
            telemetry.update();
        }
    }

    public static void rotationLeft(double degrees, Telemetry telemetry, DcMotor BL, DcMotor BR, DcMotor FL, DcMotor FR) {
        reset_encoders(BL, BR, FL, FR);
        rotations = degrees * 14;
        // SET TARGET POSITION
        FR.setTargetPosition((int) rotations);
        FL.setTargetPosition((int) -rotations);
        BL.setTargetPosition((int) -rotations);
        BR.setTargetPosition((int) rotations);
        // RUN TO POSITION
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        // POWER (left slide)
        ((DcMotorEx) FR).setVelocity(1000);
        ((DcMotorEx) FL).setVelocity(-1000);
        ((DcMotorEx) BL).setVelocity(-1000);
        ((DcMotorEx) BR).setVelocity(1000);
        while (BL.isBusy() && BR.isBusy() && FL.isBusy() && FR.isBusy()) {
            telemetry.addData("function", "rotation right");
            motor_telemetry(telemetry, BL, BR, FL, FR);
            telemetry.update();
        }
    }
}

