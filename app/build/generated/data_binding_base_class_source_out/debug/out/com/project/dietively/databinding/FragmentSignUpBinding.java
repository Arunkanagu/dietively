// Generated by view binder compiler. Do not edit!
package com.project.dietively.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

public final class FragmentSignUpBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextInputEditText age;

  @NonNull
  public final TextInputLayout ageTextField;

  @NonNull
  public final ConstraintLayout constraintLayout;

  @NonNull
  public final TextInputEditText dateOfBirth;

  @NonNull
  public final ImageView dateOfBirthBtn;

  @NonNull
  public final TextInputLayout dobTextField;

  @NonNull
  public final TextInputEditText email;

  @NonNull
  public final TextInputLayout emailTextField;

  @NonNull
  public final ImageView female;

  @NonNull
  public final TextView goToLogin;

  @NonNull
  public final Guideline guideline;

  @NonNull
  public final Guideline guideline1;

  @NonNull
  public final LinearLayout info1;

  @NonNull
  public final LinearLayout info2;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final ImageView male;

  @NonNull
  public final TextInputEditText mobile;

  @NonNull
  public final TextInputLayout mobileTextField;

  @NonNull
  public final MaterialButton next;

  @NonNull
  public final TextInputEditText pass;

  @NonNull
  public final TextInputLayout passTextField;

  @NonNull
  public final CardView profileInfoCardView;

  @NonNull
  public final MaterialButton signUp;

  @NonNull
  public final TextInputEditText user;

  @NonNull
  public final TextInputLayout userTextField1;

  private FragmentSignUpBinding(@NonNull ConstraintLayout rootView, @NonNull TextInputEditText age,
      @NonNull TextInputLayout ageTextField, @NonNull ConstraintLayout constraintLayout,
      @NonNull TextInputEditText dateOfBirth, @NonNull ImageView dateOfBirthBtn,
      @NonNull TextInputLayout dobTextField, @NonNull TextInputEditText email,
      @NonNull TextInputLayout emailTextField, @NonNull ImageView female,
      @NonNull TextView goToLogin, @NonNull Guideline guideline, @NonNull Guideline guideline1,
      @NonNull LinearLayout info1, @NonNull LinearLayout info2, @NonNull LinearLayout linearLayout,
      @NonNull ImageView male, @NonNull TextInputEditText mobile,
      @NonNull TextInputLayout mobileTextField, @NonNull MaterialButton next,
      @NonNull TextInputEditText pass, @NonNull TextInputLayout passTextField,
      @NonNull CardView profileInfoCardView, @NonNull MaterialButton signUp,
      @NonNull TextInputEditText user, @NonNull TextInputLayout userTextField1) {
    this.rootView = rootView;
    this.age = age;
    this.ageTextField = ageTextField;
    this.constraintLayout = constraintLayout;
    this.dateOfBirth = dateOfBirth;
    this.dateOfBirthBtn = dateOfBirthBtn;
    this.dobTextField = dobTextField;
    this.email = email;
    this.emailTextField = emailTextField;
    this.female = female;
    this.goToLogin = goToLogin;
    this.guideline = guideline;
    this.guideline1 = guideline1;
    this.info1 = info1;
    this.info2 = info2;
    this.linearLayout = linearLayout;
    this.male = male;
    this.mobile = mobile;
    this.mobileTextField = mobileTextField;
    this.next = next;
    this.pass = pass;
    this.passTextField = passTextField;
    this.profileInfoCardView = profileInfoCardView;
    this.signUp = signUp;
    this.user = user;
    this.userTextField1 = userTextField1;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSignUpBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSignUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_sign_up, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSignUpBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.age;
      TextInputEditText age = ViewBindings.findChildViewById(rootView, id);
      if (age == null) {
        break missingId;
      }

      id = R.id.age_textField;
      TextInputLayout ageTextField = ViewBindings.findChildViewById(rootView, id);
      if (ageTextField == null) {
        break missingId;
      }

      ConstraintLayout constraintLayout = (ConstraintLayout) rootView;

      id = R.id.date_of_birth;
      TextInputEditText dateOfBirth = ViewBindings.findChildViewById(rootView, id);
      if (dateOfBirth == null) {
        break missingId;
      }

      id = R.id.date_of_birth_btn;
      ImageView dateOfBirthBtn = ViewBindings.findChildViewById(rootView, id);
      if (dateOfBirthBtn == null) {
        break missingId;
      }

      id = R.id.dob_textField;
      TextInputLayout dobTextField = ViewBindings.findChildViewById(rootView, id);
      if (dobTextField == null) {
        break missingId;
      }

      id = R.id.email;
      TextInputEditText email = ViewBindings.findChildViewById(rootView, id);
      if (email == null) {
        break missingId;
      }

      id = R.id.email_textField;
      TextInputLayout emailTextField = ViewBindings.findChildViewById(rootView, id);
      if (emailTextField == null) {
        break missingId;
      }

      id = R.id.female;
      ImageView female = ViewBindings.findChildViewById(rootView, id);
      if (female == null) {
        break missingId;
      }

      id = R.id.go_to_login;
      TextView goToLogin = ViewBindings.findChildViewById(rootView, id);
      if (goToLogin == null) {
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

      id = R.id.info_1;
      LinearLayout info1 = ViewBindings.findChildViewById(rootView, id);
      if (info1 == null) {
        break missingId;
      }

      id = R.id.info_2;
      LinearLayout info2 = ViewBindings.findChildViewById(rootView, id);
      if (info2 == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.male;
      ImageView male = ViewBindings.findChildViewById(rootView, id);
      if (male == null) {
        break missingId;
      }

      id = R.id.mobile;
      TextInputEditText mobile = ViewBindings.findChildViewById(rootView, id);
      if (mobile == null) {
        break missingId;
      }

      id = R.id.mobile_textField;
      TextInputLayout mobileTextField = ViewBindings.findChildViewById(rootView, id);
      if (mobileTextField == null) {
        break missingId;
      }

      id = R.id.next;
      MaterialButton next = ViewBindings.findChildViewById(rootView, id);
      if (next == null) {
        break missingId;
      }

      id = R.id.pass;
      TextInputEditText pass = ViewBindings.findChildViewById(rootView, id);
      if (pass == null) {
        break missingId;
      }

      id = R.id.pass_textField;
      TextInputLayout passTextField = ViewBindings.findChildViewById(rootView, id);
      if (passTextField == null) {
        break missingId;
      }

      id = R.id.profile_info_cardView;
      CardView profileInfoCardView = ViewBindings.findChildViewById(rootView, id);
      if (profileInfoCardView == null) {
        break missingId;
      }

      id = R.id.sign_up;
      MaterialButton signUp = ViewBindings.findChildViewById(rootView, id);
      if (signUp == null) {
        break missingId;
      }

      id = R.id.user;
      TextInputEditText user = ViewBindings.findChildViewById(rootView, id);
      if (user == null) {
        break missingId;
      }

      id = R.id.user_textField1;
      TextInputLayout userTextField1 = ViewBindings.findChildViewById(rootView, id);
      if (userTextField1 == null) {
        break missingId;
      }

      return new FragmentSignUpBinding((ConstraintLayout) rootView, age, ageTextField,
          constraintLayout, dateOfBirth, dateOfBirthBtn, dobTextField, email, emailTextField,
          female, goToLogin, guideline, guideline1, info1, info2, linearLayout, male, mobile,
          mobileTextField, next, pass, passTextField, profileInfoCardView, signUp, user,
          userTextField1);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}