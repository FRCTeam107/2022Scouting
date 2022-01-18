// Generated code from Butter Knife. Do not modify!
package com.example.vande.scouting2022;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SendDataActivity_ViewBinding implements Unbinder {
  private SendDataActivity target;

  @UiThread
  public SendDataActivity_ViewBinding(SendDataActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SendDataActivity_ViewBinding(SendDataActivity target, View source) {
    this.target = target;

    target.matchOrPitRadiobtnGrp = Utils.findRequiredViewAsType(source, R.id.matchOrPit_RadiobtnGrp, "field 'matchOrPitRadiobtnGrp'", RadioGroup.class);
    target.concatFolderEditText = Utils.findRequiredViewAsType(source, R.id.concatFolder_editText, "field 'concatFolderEditText'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SendDataActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.matchOrPitRadiobtnGrp = null;
    target.concatFolderEditText = null;
  }
}
