package frc.robot.auto.selector;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.auto.modes.*;
public enum AutoModeList {
  DO_NOTHING (new DoNothing()),
  MIDSTARTCHARGESTATION(new MidStartChargeStation()),
  BLUECLOSESCORECHARING(new BlueCloseScoreCharging()),
  REDCLOSESCORECHARGING(new RedCloseScoreCharging()),
  RECLOSESCORETWO(new RedCloseScoreTwo()),
  REDMIDDLESCORETWO(new RedMiddleScoreTwo()),
  REDFARSCORECHARGING(new RedFarScoreCharging()),
  REDFARSCORETWO(new RedFarScoreTwo());

  private final SequentialCommandGroup autoCommand;

  AutoModeList(SequentialCommandGroup autoCommand) {
    this.autoCommand = autoCommand;

  }
  public SequentialCommandGroup getAuto() {
    return autoCommand;
  }
}
