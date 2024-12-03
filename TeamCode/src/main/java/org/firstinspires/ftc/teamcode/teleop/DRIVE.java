package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple.Direction;
import com.qualcomm.robotcore.util.Range;

@TeleOp(
        name = "Drive1"
)
public class DRIVE extends LinearOpMode {
    DcMotor BR;
    DcMotor FR;
    DcMotor BL;
    DcMotor FL;
    double r;

    public void runOpMode() {

        BL = hardwareMap.get(DcMotor.class, "BL"); // LD to BL
        BL.setDirection(Direction.REVERSE);
        BR = hardwareMap.get(DcMotor.class, "BR"); // RD to BR
        BR.setDirection(Direction.REVERSE);
        FL = hardwareMap.get(DcMotor.class, "FL"); // LU to FL
        FR = hardwareMap.get(DcMotor.class, "FR"); // RU to FR

        telemetry.addData(">", "Press Start to run Motors.");
        telemetry.update();
        waitForStart();

        while(opModeIsActive()) {
            r = Math.hypot(-gamepad1.left_stick_y, gamepad1.left_stick_x);
            double robotAngle = Math.atan2(gamepad1.left_stick_x, -gamepad1.left_stick_y) - Math.PI/4;
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
    }
}
