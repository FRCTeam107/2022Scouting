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
    target.autonInnerPortInputLayout = Utils.findRequiredViewAsType(source, R.id.autonInnerPort_input_layout, "field 'autonInnerPortInputLayout'", TextInputLayout.class);
    target.autonOuterPortInputLayout = Utils.findRequiredViewAsType(source, R.id.autonOuterPort_input_layout, "field 'autonOuterPortInputLayout'", TextInputLayout.class);
    target.autonBottomPortInputLayout = Utils.findRequiredViewAsType(source, R.id.autonBottomPort_input_layout, "field 'autonBottomPortInputLayout'", TextInputLayout.class);
    target.teamNumberInput = Utils.findRequiredViewAsType(source, R.id.teamNumber_input, "field 'teamNumberInput'", EditText.class);
    target.matchNumberInput = Utils.findRequiredViewAsType(source, R.id.matchNumber_input, "field 'matchNumberInput'", EditText.class);
    target.initiationLinechkbx = Utils.findRequiredViewAsType(source, R.id.initiationLine_chkbx, "field 'initiationLinechkbx'", CheckBox.class);
    target.autonInnerPortInput = Utils.findRequiredViewAsType(source, R.id.autonInnerPort_input, "field 'autonInnerPortInput'", TextInputEditText.class);
    target.autonOuterPortInput = Utils.findRequiredViewAsType(source, R.id.autonOuterPort_input, "field 'autonOuterPortInput'", TextInputEditText.class);
    target.autonBottomPortInput = Utils.findRequiredViewAsType(source, R.id.autonBottomPort_input, "field 'autonBottomPortInput'", TextInputEditText.class);
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
    target.autonInnerPortInputLayout = null;
    target.autonOuterPortInputLayout = null;
    target.autonBottomPortInputLayout = null;
    target.teamNumberInput = null;
    target.matchNumberInput = null;
    target.initiationLinechkbx = null;
    target.autonInnerPortInput = null;
    target.autonOuterPortInput = null;
    target.autonBottomPortInput = null;
    target.nextButton = null;
  }
}
