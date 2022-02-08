// Generated code from Butter Knife. Do not modify!
package com.example.vande.scouting2022;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PitActivity_ViewBinding implements Unbinder {
  private PitActivity target;

  @UiThread
  public PitActivity_ViewBinding(PitActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PitActivity_ViewBinding(PitActivity target, View source) {
    this.target = target;

    target.pitTeamNumberInputLayout = Utils.findRequiredViewAsType(source, R.id.pit_teamNumber_input_layout, "field 'pitTeamNumberInputLayout'", TextInputLayout.class);
    target.pitSizeInputLayout = Utils.findRequiredViewAsType(source, R.id.pit_size_input_layout, "field 'pitSizeInputLayout'", TextInputLayout.class);
    target.pitSizeInput = Utils.findRequiredViewAsType(source, R.id.pit_size_input, "field 'pitSizeInput'", TextInputEditText.class);
    target.pitPowerCellTopInputLayout = Utils.findRequiredViewAsType(source, R.id.pit_powerCellTop_input_layout, "field 'pitPowerCellTopInputLayout'", TextInputLayout.class);
    target.pitPowerCellBottomInputLayout = Utils.findRequiredViewAsType(source, R.id.pit_cargoBottominput_layout, "field 'pitPowerCellBottomInputLayout'", TextInputLayout.class);
    target.pitWeightInputLayout = Utils.findRequiredViewAsType(source, R.id.pit_weight_input_layout, "field 'pitWeightInputLayout'", TextInputLayout.class);
    target.pitStormTrooperShotsInputLayout = Utils.findRequiredViewAsType(source, R.id.pit_stormTrooperShots_input_layout, "field 'pitStormTrooperShotsInputLayout'", TextInputLayout.class);
    target.pitCommentInputLayout = Utils.findRequiredViewAsType(source, R.id.pit_comments_input_layout, "field 'pitCommentInputLayout'", TextInputLayout.class);
    target.pitTeamNumberInput = Utils.findRequiredViewAsType(source, R.id.pit_teamNumber_input, "field 'pitTeamNumberInput'", TextInputEditText.class);
    target.pitPowerCellTopInput = Utils.findRequiredViewAsType(source, R.id.PitCargoTop_input, "field 'pitPowerCellTopInput'", TextInputEditText.class);
    target.pitPowerCellBottomInput = Utils.findRequiredViewAsType(source, R.id.pit_powerCellBottom_input, "field 'pitPowerCellBottomInput'", TextInputEditText.class);
    target.pitWeightInput = Utils.findRequiredViewAsType(source, R.id.pit_weight_input, "field 'pitWeightInput'", TextInputEditText.class);
    target.pitStormTrooperShotsInput = Utils.findRequiredViewAsType(source, R.id.pit_stormTrooperShots_input, "field 'pitStormTrooperShotsInput'", TextInputEditText.class);
    target.pitCommentInput = Utils.findRequiredViewAsType(source, R.id.pit_comments_input, "field 'pitCommentInput'", TextInputEditText.class);
    target.pitTeleopPreferenceRadiobtnGrp = Utils.findRequiredViewAsType(source, R.id.pit_teleopPreference_RadiobtnGrp, "field 'pitTeleopPreferenceRadiobtnGrp'", RadioGroup.class);
    target.pitClimbBooleanRadiobtnGrp = Utils.findRequiredViewAsType(source, R.id.pit_climbBoolean_RadiobtnGrp, "field 'pitClimbBooleanRadiobtnGrp'", RadioGroup.class);
    target.pitControlPanelRadioGrp = Utils.findRequiredViewAsType(source, R.id.pit_climbLevel_RadiobtnGrp, "field 'pitControlPanelRadioGrp'", RadioGroup.class);
    target.pitProgrammingLanguageRadiobtnGrp = Utils.findRequiredViewAsType(source, R.id.pit_programmingLanguage_RadiobtnGrp, "field 'pitProgrammingLanguageRadiobtnGrp'", RadioGroup.class);
    target.savePitBtn = Utils.findRequiredViewAsType(source, R.id.save_pit_btn, "field 'savePitBtn'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PitActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.pitTeamNumberInputLayout = null;
    target.pitSizeInputLayout = null;
    target.pitSizeInput = null;
    target.pitPowerCellTopInputLayout = null;
    target.pitPowerCellBottomInputLayout = null;
    target.pitWeightInputLayout = null;
    target.pitStormTrooperShotsInputLayout = null;
    target.pitCommentInputLayout = null;
    target.pitTeamNumberInput = null;
    target.pitPowerCellTopInput = null;
    target.pitPowerCellBottomInput = null;
    target.pitWeightInput = null;
    target.pitStormTrooperShotsInput = null;
    target.pitCommentInput = null;
    target.pitTeleopPreferenceRadiobtnGrp = null;
    target.pitClimbBooleanRadiobtnGrp = null;
    target.pitControlPanelRadioGrp = null;
    target.pitProgrammingLanguageRadiobtnGrp = null;
    target.savePitBtn = null;
  }
}
