// Generated code from Butter Knife. Do not modify!
package com.example.vande.scouting2022;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ScouterInitialsActivity_ViewBinding implements Unbinder {
  private ScouterInitialsActivity target;

  @UiThread
  public ScouterInitialsActivity_ViewBinding(ScouterInitialsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ScouterInitialsActivity_ViewBinding(ScouterInitialsActivity target, View source) {
    this.target = target;

    target.scouterInitialsInputLayout = Utils.findRequiredViewAsType(source, R.id.scouterInitials_input_layout, "field 'scouterInitialsInputLayout'", TextInputLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ScouterInitialsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.scouterInitialsInputLayout = null;
  }
}
