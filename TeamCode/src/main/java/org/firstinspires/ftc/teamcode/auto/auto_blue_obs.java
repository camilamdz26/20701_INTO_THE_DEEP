package org.firstinspires.ftc.teamcode.auto;
//autonomous blue from observation zone - designed to place pixel in net zone and park in observation zone

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.movement;

@Config
@Autonomous(name="auto_blue_obs")

public static double a01_d = 0;
public static double a02_d = 0;
public static double a03_r = 0;
public static double a04_d = 0;
public static double a05_d = 0;
public static double a06_d = 0;
public static double a07_d = 0;

public class auto_blue_obs extends LinearOpMode {
    //sets up motors
    DcMotor FR;
    DcMotor FL;
    DcMotor BR;
    DcMotor BL;

    @Override
    public void runOpMode(){
        //declares motors and sets them to the correct directions
        FL = hardwareMap.get(DcMotor.class, "FL");
        FR = hardwareMap.get(DcMotor.class,"FR");
        BL = hardwareMap.get(DcMotor.class, "BL");
        BR = hardwareMap.get(DcMotor.class, "BR");

        FL.setDirection(DcMotor.Direction.REVERSE);
        FR.setDirection(DcMotor.Direction.FORWARD);
        BL.setDirection(DcMotor.Direction.REVERSE);
        BR.setDirection(DcMotor.Direction.FORWARD);

        FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        waitForStart();
        //actual code to move: using movement.java program

        //movement.forward(20, telemetry, BL, BR, FL, FR);
        //movement.left(175, telemetry, BL, BR, FL, FR);
        //movement.rotationLeft(162, telemetry,BL, BR, FL, FR);
        //movement.forward(2, telemetry, BL, BR, FL, FR);
        //movement.backward(20, telemetry, BL, BR, FL, FR);
        //movement.left(250, telemetry, BL, BR, FL, FR);
        //movement.forward(22, telemetry, BL, BR, FL, FR);

        movement.forward(a01_d, telemetry, BL, BR, FL, FR);
        movement.left(a02_d, telemetry, BL, BR, FL, FR);
        movement.rotationLeft(a03_r, telemetry,BL, BR, FL, FR);
        movement.forward(a04_d, telemetry, BL, BR, FL, FR);
        movement.backward(a05_d, telemetry, BL, BR, FL, FR);
        movement.left(a06_d, telemetry, BL, BR, FL, FR);
        movement.forward(a07_d, telemetry, BL, BR, FL, FR);
    }
}
