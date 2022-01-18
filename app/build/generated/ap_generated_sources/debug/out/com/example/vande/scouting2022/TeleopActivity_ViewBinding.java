// Generated code from Butter Knife. Do not modify!
package com.example.vande.scouting2022;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TeleopActivity_ViewBinding implements Unbinder {
  private TeleopActivity target;

  @UiThread
  public TeleopActivity_ViewBinding(TeleopActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TeleopActivity_ViewBinding(TeleopActivity target, View source) {
    this.target = target;

    target.teleopInnerPortInputLayout = Utils.findRequiredViewAsType(source, R.id.teleopInnerPort_input_layout, "field 'teleopInnerPortInputLayout'", TextInputLayout.class);
    target.teleopOuterPortInputLayout = Utils.findRequiredViewAsType(source, R.id.teleopOuterPort_input_layout, "field 'teleopOuterPortInputLayout'", TextInputLayout.class);
    target.teleopBottomPortInputLayout = Utils.findRequiredViewAsType(source, R.id.teleopBottomPort_input_layout, "field 'teleopBottomPortInputLayout'", TextInputLayout.class);
    target.teleopInnerPortInput = Utils.findRequiredViewAsType(source, R.id.teleopInnerPort_input, "field 'teleopInnerPortInput'", TextInputEditText.class);
    target.teleopOuterPortInput = Utils.findRequiredViewAsType(source, R.id.teleopOuterPort_input, "field 'teleopOuterPortInput'", TextInputEditText.class);
    target.teleopBottomPortInput = Utils.findRequiredViewAsType(source, R.id.teleopBottomPort_input, "field 'teleopBottomPortInput'", TextInputEditText.class);
    target.powerCellPickupLoadingStationCheckBox = Utils.findRequiredViewAsType(source, R.id.powerCellPickupLoadingStation_checkBox, "field 'powerCellPickupLoadingStationCheckBox'", CheckBox.class);
    target.powerCellPickupFloorCheckBox = Utils.findRequiredViewAsType(source, R.id.powerCellPickupFloor_checkBox, "field 'powerCellPickupFloorCheckBox'", CheckBox.class);
    target.foulsCheckBox = Utils.findRequiredViewAsType(source, R.id.fouls_checkBox, "field 'foulsCheckBox'", CheckBox.class);
    target.controlPanelRadiobtnGrp = Utils.findRequiredViewAsType(source, R.id.controlPanel_RadiobtnGrp, "field 'controlPanelRadiobtnGrp'", RadioGroup.class);
    target.climbRadiobtnGrp = Utils.findRequiredViewAsType(source, R.id.climb_RadiobtnGrp, "field 'climbRadiobtnGrp'", RadioGroup.class);
    target.defenseRadiobtnGrp = Utils.findRequiredViewAsType(source, R.id.defense_RadiobtnGrp, "field 'defenseRadiobtnGrp'", RadioGroup.class);
    target.saveBtn = Utils.findRequiredViewAsType(source, R.id.save_btn, "field 'saveBtn'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TeleopActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.teleopInnerPortInputLayout = null;
    target.teleopOuterPortInputLayout = null;
    target.teleopBottomPortInputLayout = null;
    target.teleopInnerPortInput = null;
    target.teleopOuterPortInput = null;
    target.teleopBottomPortInput = null;
    target.powerCellPickupLoadingStationCheckBox = null;
    target.powerCellPickupFloorCheckBox = null;
    target.foulsCheckBox = null;
    target.controlPanelRadiobtnGrp = null;
    target.climbRadiobtnGrp = null;
    target.defenseRadiobtnGrp = null;
    target.saveBtn = null;
  }
}
