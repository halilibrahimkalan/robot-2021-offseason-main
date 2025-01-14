// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VisionCamSubsystem extends SubsystemBase {
  /** Creates a new VisionCamSubsystem. */
  PhotonCamera camera = new PhotonCamera("Lifecam");
  public static PhotonPipelineResult result;
  public static PhotonTrackedTarget target;
  public VisionCamSubsystem() {
    result = camera.getLatestResult();
    if(isValidAngle()){
    target = result.getBestTarget();
    }
  }

  public static double getVisionYawAngle() {
    return target.getYaw();
  }

  public static boolean isValidAngle() {
    return result.hasTargets();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
