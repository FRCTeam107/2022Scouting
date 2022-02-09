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

    target.DefenseTeaminputlayout = Utils.findRequiredViewAsType(source, R.id.DefenseTeam_input_layout, "field 'DefenseTeaminputlayout'", TextInputLayout.class);
    target.DefenseTeaminput = Utils.findRequiredViewAsType(source, R.id.DefenseTeam_input, "field 'DefenseTeaminput'", TextInputEditText.class);
    target.teleopHighHubinputlayout = Utils.findRequiredViewAsType(source, R.id.teleopHighHub_input_layout, "field 'teleopHighHubinputlayout'", TextInputLayout.class);
    target.teleopLowHubinputlayout = Utils.findRequiredViewAsType(source, R.id.teleopLowHub_input_layout, "field 'teleopLowHubinputlayout'", TextInputLayout.class);
    target.HighHubPortinput = Utils.findRequiredViewAsType(source, R.id.HighHubPort_input, "field 'HighHubPortinput'", TextInputEditText.class);
    target.teleopLowHub_input = Utils.findRequiredViewAsType(source, R.id.teleopLowHub_input, "field 'teleopLowHub_input'", TextInputEditText.class);
    target.FixedcheckBox = Utils.findRequiredViewAsType(source, R.id.Fixed_checkBox, "field 'FixedcheckBox'", CheckBox.class);
    target.VariablecheckBox = Utils.findRequiredViewAsType(source, R.id.Variable_checkBox, "field 'VariablecheckBox'", CheckBox.class);
    target.foulsCheckBox = Utils.findRequiredViewAsType(source, R.id.fouls_checkBox, "field 'foulsCheckBox'", CheckBox.class);
    target.climberRungRadiobtnGrp = Utils.findRequiredViewAsType(source, R.id.climberRung_MultiRadiobtnGrp, "field 'climberRungRadiobtnGrp'", RadioGroup.class);
    target.speedRadiobtnGrp = Utils.findRequiredViewAsType(source, R.id.speed_RadiobtnGrp, "field 'speedRadiobtnGrp'", RadioGroup.class);
    target.defenseRadiobtnGrp = Utils.findRequiredViewAsType(source, R.id.defense_RadiobtnGrp, "field 'defenseRadiobtnGrp'", RadioGroup.class);
    target.speedclimbRadiobtnGrp = Utils.findRequiredViewAsType(source, R.id.speedofrobotClimbingnGrp, "field 'speedclimbRadiobtnGrp'", RadioGroup.class);
    target.saveBtn = Utils.findRequiredViewAsType(source, R.id.save_btn, "field 'saveBtn'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TeleopActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.DefenseTeaminputlayout = null;
    target.DefenseTeaminput = null;
    target.teleopHighHubinputlayout = null;
    target.teleopLowHubinputlayout = null;
    target.HighHubPortinput = null;
    target.teleopLowHub_input = null;
    target.FixedcheckBox = null;
    target.VariablecheckBox = null;
    target.foulsCheckBox = null;
    target.climberRungRadiobtnGrp = null;
    target.speedRadiobtnGrp = null;
    target.defenseRadiobtnGrp = null;
    target.speedclimbRadiobtnGrp = null;
    target.saveBtn = null;
  }
}
