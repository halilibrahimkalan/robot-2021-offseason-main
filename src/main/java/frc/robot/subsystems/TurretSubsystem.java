// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.TurretConstants;

public class TurretSubsystem extends SubsystemBase {
  /** Creates a new TurretSubsystem. */
  private final PWMVictorSPX TurretMotor = new PWMVictorSPX(TurretConstants.kTurretMotor);
  double cpr = 64; //if am-4027
  double whd = 6; // for 6 inch wheel
  public final Encoder TurretEncoder = new Encoder(TurretConstants.kTurretEncoderA, TurretConstants.kTurretEncoderB, TurretConstants.kIsEncoderReversed);
  public TurretSubsystem() { }

  public double HeadEncoderGetValue(){
    TurretEncoder.setDistancePerPulse(1.0 / (TurretConstants.kTurretEncoderPPR));
    TurretEncoder.setDistancePerPulse(Math.PI*whd/cpr);
    return TurretEncoder.getDistance();
  }

  public void runTurret(double m_speed){
		TurretMotor.set(m_speed);
  }

  public void resetEncoders() {
    TurretEncoder.reset();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
