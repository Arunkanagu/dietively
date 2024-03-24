// Generated by view binder compiler. Do not edit!
package com.project.dietively.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.project.dietively.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentForgetPassBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CardView PasswordCardView;

  @NonNull
  public final TextView backToLogin;

  @NonNull
  public final MaterialButton changePassBtn;

  @NonNull
  public final TextInputEditText confirmPass;

  @NonNull
  public final TextInputLayout confirmPassField;

  @NonNull
  public final TextInputEditText email;

  @NonNull
  public final CardView emailCardView;

  @NonNull
  public final TextInputLayout emailTextField;

  @NonNull
  public final Guideline guideline;

  @NonNull
  public final Guideline guideline1;

  @NonNull
  public final Guideline guideline2;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final TextInputEditText newPass;

  @NonNull
  public final TextInputLayout newPassField;

  @NonNull
  public final MaterialButton setNewPassBtn;

  private FragmentForgetPassBinding(@NonNull ConstraintLayout rootView,
      @NonNull CardView PasswordCardView, @NonNull TextView backToLogin,
      @NonNull MaterialButton changePassBtn, @NonNull TextInputEditText confirmPass,
      @NonNull TextInputLayout confirmPassField, @NonNull TextInputEditText email,
      @NonNull CardView emailCardView, @NonNull TextInputLayout emailTextField,
      @NonNull Guideline guideline, @NonNull Guideline guideline1, @NonNull Guideline guideline2,
      @NonNull LinearLayout linearLayout, @NonNull TextInputEditText newPass,
      @NonNull TextInputLayout newPassField, @NonNull MaterialButton setNewPassBtn) {
    this.rootView = rootView;
    this.PasswordCardView = PasswordCardView;
    this.backToLogin = backToLogin;
    this.changePassBtn = changePassBtn;
    this.confirmPass = confirmPass;
    this.confirmPassField = confirmPassField;
    this.email = email;
    this.emailCardView = emailCardView;
    this.emailTextField = emailTextField;
    this.guideline = guideline;
    this.guideline1 = guideline1;
    this.guideline2 = guideline2;
    this.linearLayout = linearLayout;
    this.newPass = newPass;
    this.newPassField = newPassField;
    this.setNewPassBtn = setNewPassBtn;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentForgetPassBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentForgetPassBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_forget_pass, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentForgetPassBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Password_cardView;
      CardView PasswordCardView = ViewBindings.findChildViewById(rootView, id);
      if (PasswordCardView == null) {
        break missingId;
      }

      id = R.id.back_to_login;
      TextView backToLogin = ViewBindings.findChildViewById(rootView, id);
      if (backToLogin == null) {
        break missingId;
      }

      id = R.id.change_pass_btn;
      MaterialButton changePassBtn = ViewBindings.findChildViewById(rootView, id);
      if (changePassBtn == null) {
        break missingId;
      }

      id = R.id.confirm_pass;
      TextInputEditText confirmPass = ViewBindings.findChildViewById(rootView, id);
      if (confirmPass == null) {
        break missingId;
      }

      id = R.id.confirm_pass_field;
      TextInputLayout confirmPassField = ViewBindings.findChildViewById(rootView, id);
      if (confirmPassField == null) {
        break missingId;
      }

      id = R.id.email;
      TextInputEditText email = ViewBindings.findChildViewById(rootView, id);
      if (email == null) {
        break missingId;
      }

      id = R.id.email_cardView;
      CardView emailCardView = ViewBindings.findChildViewById(rootView, id);
      if (emailCardView == null) {
        break missingId;
      }

      id = R.id.emailTextField;
      TextInputLayout emailTextField = ViewBindings.findChildViewById(rootView, id);
      if (emailTextField == null) {
        break missingId;
      }

      id = R.id.guideline;
      Guideline guideline = ViewBindings.findChildViewById(rootView, id);
      if (guideline == null) {
        break missingId;
      }

      id = R.id.guideline1;
      Guideline guideline1 = ViewBindings.findChildViewById(rootView, id);
      if (guideline1 == null) {
        break missingId;
      }

      id = R.id.guideline2;
      Guideline guideline2 = ViewBindings.findChildViewById(rootView, id);
      if (guideline2 == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.new_pass;
      TextInputEditText newPass = ViewBindings.findChildViewById(rootView, id);
      if (newPass == null) {
        break missingId;
      }

      id = R.id.new_pass_field;
      TextInputLayout newPassField = ViewBindings.findChildViewById(rootView, id);
      if (newPassField == null) {
        break missingId;
      }

      id = R.id.set_new_pass_btn;
      MaterialButton setNewPassBtn = ViewBindings.findChildViewById(rootView, id);
      if (setNewPassBtn == null) {
        break missingId;
      }

      return new FragmentForgetPassBinding((ConstraintLayout) rootView, PasswordCardView,
          backToLogin, changePassBtn, confirmPass, confirmPassField, email, emailCardView,
          emailTextField, guideline, guideline1, guideline2, linearLayout, newPass, newPassField,
          setNewPassBtn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
