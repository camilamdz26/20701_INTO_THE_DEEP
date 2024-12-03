package org.firstinspires.ftc.teamcode.auto;
//autonomous red from observation zone - designed to place pixel in net zone and park in observation zone

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.movement;

@Config
@Autonomous(name="auto_red_obs")
public class auto_red_obs extends LinearOpMode {
    //sets up motors
    DcMotor FR;
    DcMotor FL;
    DcMotor BR;
    DcMotor BL;

    @Override
    public void runOpMode(){ //sets motors to correct modes and directions
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
        //code to run autonomous

        //places pixel in net zone
        movement.forward(20, telemetry, BL, BR, FL, FR);
        movement.left(180, telemetry, BL, BR, FL, FR);
        movement.rotationLeft(155, telemetry,BL, BR, FL, FR);
        movement.forward(30, telemetry, BL, BR, FL, FR);
        movement.backward(30, telemetry, BL, BR, FL, FR);
        //parks the robot in observation zone
        movement.left(250, telemetry, BL, BR, FL, FR);
        movement.forward(50, telemetry, BL, BR, FL, FR);
    }
}
