package org.firstinspires.ftc.teamcode.hardware; //MOVEMENT CODE IMPLEMENTING TRACYS EDITS

import static org.firstinspires.ftc.teamcode.movement.motor_telemetry;
import static org.firstinspires.ftc.teamcode.movement.reset_encoders;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class newmovement {
    static DcMotor FL;
    static DcMotor FR;
    static DcMotor BR;
    static DcMotor BL;

    static double fullTurn = 21.74;
    static int velocity = 1000;

    static final DcMotor[] ALLWHEELS = {FR, FL, BL, BR};


    public static void initializeMotors(HardwareMap hardwareMap) {
        FL = hardwareMap.get(DcMotor.class, "FL");
        FR = hardwareMap.get(DcMotor.class, "FR");
        BL = hardwareMap.get(DcMotor.class, "BL");
        BR = hardwareMap.get(DcMotor.class, "BR");
        BR.setDirection(DcMotorSimple.Direction.REVERSE);
        for (int i = 0; i < ALLWHEELS.length; i++) {
            ALLWHEELS[i].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }

    public static void left(double distance, Telemetry telemetry) {
        reset_encoders(BL, BR, FL, FR);
        double rotations = (int) distance * fullTurn;
        int v = velocity;
        double rot = rotations;
        int[] wheelDir = {1, 0, 1, 0}; //binary to make it easier 1 = forward, 0 = backward fl bl

        for (int i = 0; i < ALLWHEELS.length; i++) {
            if (wheelDir[i] == 0) {
                rot = -rotations;
                v = -velocity;
            } else {
                rot = rotations;
                v = velocity;
            }
            ALLWHEELS[i].setTargetPosition((int) rot);
            ALLWHEELS[i].setMode(DcMotor.RunMode.RUN_TO_POSITION);
            ((DcMotorEx) ALLWHEELS[i]).setVelocity(v);
        }
        while (BL.isBusy()) {
            telemetry.addData("FUNCTION LEFT: ", distance);
            motor_telemetry(telemetry, BL, BR, FL, FR);
            telemetry.update();
        }
    }

    public static void right(double distance, Telemetry telemetry) {
        reset_encoders(BL, BR, FL, FR);
        double rotations = (int) distance * fullTurn;
        int v = velocity;
        double rot = rotations;
        int[] wheelDir = {0, 1, 0, 1}; //fr bl

        for (int i = 0; i < ALLWHEELS.length; i++) {
            if (wheelDir[i] == 0) {
                rot = -rotations;
                v = -velocity;
            } else {
                rot = rotations;
                v = velocity;
            }
            ALLWHEELS[i].setTargetPosition((int) rot);
            ALLWHEELS[i].setMode(DcMotor.RunMode.RUN_TO_POSITION);
            ((DcMotorEx) ALLWHEELS[i]).setVelocity(v);
        }
        while (BL.isBusy()) {
            telemetry.addData("FUNCTION RIGHT: ", distance);
            motor_telemetry(telemetry, BL, BR, FL, FR);
            telemetry.update();
        }
    }

    public static void backward(double distance, Telemetry telemetry) {
        reset_encoders(BL, BR, FL, FR);
        double rotations = (int) distance * fullTurn;
        int v = velocity;
        double rot = rotations;
        int[] wheelDir = {0, 0, 0, 0};

        for (int i = 0; i < ALLWHEELS.length; i++) {
            if (wheelDir[i] == 0) {
                rot = -rotations;
                v = -velocity;
            } else {
                rot = rotations;
                v = velocity;
            }
            ALLWHEELS[i].setTargetPosition((int) rot);
            ALLWHEELS[i].setMode(DcMotor.RunMode.RUN_TO_POSITION);
            ((DcMotorEx) ALLWHEELS[i]).setVelocity(v);
        }
        while (BL.isBusy()) {
            telemetry.addData("FUNCTION BACKWARD: ", distance);
            motor_telemetry(telemetry, BL, BR, FL, FR);
            telemetry.update();
        }
    }

    public static void forward(double distance, Telemetry telemetry) {
        reset_encoders(BL, BR, FL, FR);
        double rotations = (int) distance * fullTurn;
        int v = velocity;
        double rot = rotations;
        int[] wheelDir = {1, 1, 1, 1}; //binary to make it easier 1 = forward, 0 = backward

        for (int i = 0; i < ALLWHEELS.length; i++) {
            if (wheelDir[i] == 0) {
                rot = -rotations;
                v = -velocity;
            } else {
                rot = rotations;
                v = velocity;
            }
            ALLWHEELS[i].setTargetPosition((int) rot);
            ALLWHEELS[i].setMode(DcMotor.RunMode.RUN_TO_POSITION);
            ((DcMotorEx) ALLWHEELS[i]).setVelocity(v);
        }
        while (BL.isBusy()) {
            telemetry.addData("FUNCTION FORWARD: ", distance);
            motor_telemetry(telemetry, BL, BR, FL, FR);
            telemetry.update();
        }
    }

    public static void rotationRight(double degrees, Telemetry telemetry) {
        reset_encoders(BL, BR, FL, FR);
        double rotations = degrees * 14;
        int v = velocity;
        double rot = rotations;
        int[] wheelDir = {0, 1, 1, 0}; //fr br

        for (int i = 0; i < ALLWHEELS.length; i++) {
            if (wheelDir[i] == 0) {
                rot = -rotations;
                v = -velocity;
            } else {
                rot = rotations;
                v = velocity;
            }
            ALLWHEELS[i].setTargetPosition((int) rot);
            ALLWHEELS[i].setMode(DcMotor.RunMode.RUN_TO_POSITION);
            ((DcMotorEx) ALLWHEELS[i]).setVelocity(v);
        }
        while (BL.isBusy()) {
            telemetry.addData("FUNCTION ROTATELEFT: ", degrees);
            motor_telemetry(telemetry, BL, BR, FL, FR);
            telemetry.update();
        }
    }
    public static void rotationLeft(double degrees, Telemetry telemetry){
        reset_encoders(BL, BR, FL, FR);
        double rotations = degrees * 14;
        int v = velocity;
        double rot = rotations;
        int [] wheelDir = {1, 0, 0, 1}; //fl bl

        for (int i = 0; i < ALLWHEELS.length; i ++){
            if (wheelDir[i] == 0){
                rot = -rotations;
                v = -velocity;
            } else {
                rot = rotations;
                v = velocity;
            }
            ALLWHEELS[i].setTargetPosition((int) rot);
            ALLWHEELS[i].setMode(DcMotor.RunMode.RUN_TO_POSITION);
            ((DcMotorEx) ALLWHEELS[i]).setVelocity(v);
        }
        while (BL.isBusy()){
            telemetry.addData("FUNCTION ROTATERIGHT: ", degrees);
            motor_telemetry(telemetry, BL, BR, FL, FR);
            telemetry.update();
        }
    };
}

