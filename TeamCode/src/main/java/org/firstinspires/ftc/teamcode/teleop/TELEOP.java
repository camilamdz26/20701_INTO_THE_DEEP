package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple.Direction;
import com.qualcomm.robotcore.util.Range;
//THIS INCLUDES NO SERVO CODE YET. ONLY LINEARSLIDES AND WHEELS. 

@TeleOp(
        name = "TELEOP"
)
public class TELEOP extends LinearOpMode {
    DcMotor BR;
    DcMotor FR;
    DcMotor BL;
    DcMotor FL;
    DcMotor LSR;
    DcMotor LSL; //NAME THE LINEARSLIDE MOTORS LSL AND LSR
    double r;
    int maxExtension = 2200; //CHANGE THSI9 VALUE BASED ON THE MAX HEIGHT OF THE LS

    public void runOpMode() {

        BL = hardwareMap.get(DcMotor.class, "BL"); // LD to BL
        BL.setDirection(Direction.REVERSE);
        BR = hardwareMap.get(DcMotor.class, "BR"); // RD to BR
        BR.setDirection(Direction.REVERSE);
        FL = hardwareMap.get(DcMotor.class, "FL"); // LU to FL
        FR = hardwareMap.get(DcMotor.class, "FR"); // RU to FR
        LSR = hardwareMap.get(DcMotor.class, "LSR");
        LSL = hardwareMap.get(DcMotor.class, "LSL");

        LSR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LSL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LSR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        LSL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        LSL.setDirection(Direction.REVERSE);

        telemetry.addData(">", "Press Start to run Motors.");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {
            r = Math.hypot(-gamepad1.left_stick_y, gamepad1.left_stick_x);
            double robotAngle = Math.atan2(gamepad1.left_stick_x, -gamepad1.left_stick_y) - Math.PI / 4;
            double rightX = gamepad1.right_stick_x;
            final double v4 = r * Math.cos(robotAngle) - rightX;
            final double v3 = r * Math.sin(robotAngle) - rightX;
            final double v2 = r * Math.sin(robotAngle) + rightX;
            final double v1 = r * Math.cos(robotAngle) + rightX;

            BR.setPower(Range.clip(-v4, -1.0D, 1.0D));
            BL.setPower(Range.clip(-v3, -1.0D, 1.0D));
            FR.setPower(Range.clip(-v2, -1.0D, 1.0D));
            FL.setPower(Range.clip(-v1, -1.0D, 1.0D));
            telemetry.update();
        }

        telemetry.addData(">", "Done");
        telemetry.update();

//I DON'T KNOW IF THIS WILL WORK, WE HAVE TO CHECK
        if (LSR.getCurrentPosition() < maxExtension && LSL.getCurrentPosition() < maxExtension) { //if it is not already stretched
            if (gamepad1.y) {
                telemetry.update(); //if gamepad is pressed, turn on motors
                LSR.setPower(1);
                LSL.setPower(1);
            } else {
                LSR.setPower(0);
                LSL.setPower(0); //if it isn't, turn off
            }
        } else {
            LSR.setPower(0);
            LSL.setPower(0); //if it is at max position, set power to 0
        }
        if (LSR.getCurrentPosition() > 0 && LSL.getCurrentPosition() > 0) { //if they are not at position 0
            if (gamepad1.a) {
                LSR.setPower(-0.5); //if you press a, will retract the slides.
                LSL.setPower(-0.5);
            } else {
                LSR.setPower(0); //if it isn't, turn off
                LSL.setPower(0);
            }

        }
    }
}

