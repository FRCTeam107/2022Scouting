// Generated code from Butter Knife. Do not modify!
package com.example.vande.scouting2022;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AutonActivity_ViewBinding implements Unbinder {
  private AutonActivity target;

  @UiThread
  public AutonActivity_ViewBinding(AutonActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AutonActivity_ViewBinding(AutonActivity target, View source) {
    this.target = target;

    target.teamNumberInputLayout = Utils.findRequiredViewAsType(source, R.id.teamNumber_input_layout, "field 'teamNumberInputLayout'", TextInputLayout.class);
    target.matchNumberInputLayout = Utils.findRequiredViewAsType(source, R.id.matchNumber_input_layout, "field 'matchNumberInputLayout'", TextInputLayout.class);
    target.autonHighHubInputLayout = Utils.findRequiredViewAsType(source, R.id.autonHighHub_input_layout, "field 'autonHighHubInputLayout'", TextInputLayout.class);
    target.autonLowHubInputLayout = Utils.findRequiredViewAsType(source, R.id.autonLowHub_input_layout, "field 'autonLowHubInputLayout'", TextInputLayout.class);
    target.teamNumberInput = Utils.findRequiredViewAsType(source, R.id.teamNumber_input, "field 'teamNumberInput'", EditText.class);
    target.matchNumberInput = Utils.findRequiredViewAsType(source, R.id.matchNumber_input, "field 'matchNumberInput'", EditText.class);
    target.Taxichkbx = Utils.findRequiredViewAsType(source, R.id.Taxi_chkbx, "field 'Taxichkbx'", CheckBox.class);
    target.humanPlayershotchkbx = Utils.findRequiredViewAsType(source, R.id.humanPlayershot_chkbx, "field 'humanPlayershotchkbx'", CheckBox.class);
    target.autonHighHubInput = Utils.findRequiredViewAsType(source, R.id.autonHighHub_input, "field 'autonHighHubInput'", TextInputEditText.class);
    target.autonLowHubInput = Utils.findRequiredViewAsType(source, R.id.autonLowHub_input, "field 'autonLowHubInput'", TextInputEditText.class);
    target.nextButton = Utils.findRequiredViewAsType(source, R.id.next_button, "field 'nextButton'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AutonActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.teamNumberInputLayout = null;
    target.matchNumberInputLayout = null;
    target.autonHighHubInputLayout = null;
    target.autonLowHubInputLayout = null;
    target.teamNumberInput = null;
    target.matchNumberInput = null;
    target.Taxichkbx = null;
    target.humanPlayershotchkbx = null;
    target.autonHighHubInput = null;
    target.autonLowHubInput = null;
    target.nextButton = null;
  }
}
