// Generated by view binder compiler. Do not edit!
package com.project.dietively.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.project.dietively.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentWomenBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView addData1;

  @NonNull
  public final ImageView addData2;

  @NonNull
  public final ImageView back;

  @NonNull
  public final ImageView backDate;

  @NonNull
  public final AppCompatButton changeDate;

  @NonNull
  public final ImageView clear;

  @NonNull
  public final AppCompatEditText cycleDays;

  @NonNull
  public final AppCompatEditText duringDays;

  @NonNull
  public final ScrollView formLayout;

  @NonNull
  public final Guideline guideline3;

  @NonNull
  public final LinearLayout healthCare;

  @NonNull
  public final AppCompatEditText lastPeriodStratDate;

  @NonNull
  public final LinearLayout linearLayout5;

  @NonNull
  public final ScrollView mainLayout;

  @NonNull
  public final ImageView minusData1;

  @NonNull
  public final ImageView minusData2;

  @NonNull
  public final TextView monthName;

  @NonNull
  public final ImageView nextDate;

  @NonNull
  public final RecyclerView periodCalender;

  @NonNull
  public final ImageView periodDatePicker;

  @NonNull
  public final LinearLayout periodsTrack;

  @NonNull
  public final ScrollView periodsTrackLayout;

  @NonNull
  public final AppCompatButton resetDate;

  @NonNull
  public final AppCompatButton startTracking;

  @NonNull
  public final TextView textView;

  private FragmentWomenBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView addData1,
      @NonNull ImageView addData2, @NonNull ImageView back, @NonNull ImageView backDate,
      @NonNull AppCompatButton changeDate, @NonNull ImageView clear,
      @NonNull AppCompatEditText cycleDays, @NonNull AppCompatEditText duringDays,
      @NonNull ScrollView formLayout, @NonNull Guideline guideline3,
      @NonNull LinearLayout healthCare, @NonNull AppCompatEditText lastPeriodStratDate,
      @NonNull LinearLayout linearLayout5, @NonNull ScrollView mainLayout,
      @NonNull ImageView minusData1, @NonNull ImageView minusData2, @NonNull TextView monthName,
      @NonNull ImageView nextDate, @NonNull RecyclerView periodCalender,
      @NonNull ImageView periodDatePicker, @NonNull LinearLayout periodsTrack,
      @NonNull ScrollView periodsTrackLayout, @NonNull AppCompatButton resetDate,
      @NonNull AppCompatButton startTracking, @NonNull TextView textView) {
    this.rootView = rootView;
    this.addData1 = addData1;
    this.addData2 = addData2;
    this.back = back;
    this.backDate = backDate;
    this.changeDate = changeDate;
    this.clear = clear;
    this.cycleDays = cycleDays;
    this.duringDays = duringDays;
    this.formLayout = formLayout;
    this.guideline3 = guideline3;
    this.healthCare = healthCare;
    this.lastPeriodStratDate = lastPeriodStratDate;
    this.linearLayout5 = linearLayout5;
    this.mainLayout = mainLayout;
    this.minusData1 = minusData1;
    this.minusData2 = minusData2;
    this.monthName = monthName;
    this.nextDate = nextDate;
    this.periodCalender = periodCalender;
    this.periodDatePicker = periodDatePicker;
    this.periodsTrack = periodsTrack;
    this.periodsTrackLayout = periodsTrackLayout;
    this.resetDate = resetDate;
    this.startTracking = startTracking;
    this.textView = textView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentWomenBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentWomenBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_women, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentWomenBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.add_data1;
      ImageView addData1 = ViewBindings.findChildViewById(rootView, id);
      if (addData1 == null) {
        break missingId;
      }

      id = R.id.add_data2;
      ImageView addData2 = ViewBindings.findChildViewById(rootView, id);
      if (addData2 == null) {
        break missingId;
      }

      id = R.id.back;
      ImageView back = ViewBindings.findChildViewById(rootView, id);
      if (back == null) {
        break missingId;
      }

      id = R.id.back_date;
      ImageView backDate = ViewBindings.findChildViewById(rootView, id);
      if (backDate == null) {
        break missingId;
      }

      id = R.id.change_date;
      AppCompatButton changeDate = ViewBindings.findChildViewById(rootView, id);
      if (changeDate == null) {
        break missingId;
      }

      id = R.id.clear;
      ImageView clear = ViewBindings.findChildViewById(rootView, id);
      if (clear == null) {
        break missingId;
      }

      id = R.id.cycle_days;
      AppCompatEditText cycleDays = ViewBindings.findChildViewById(rootView, id);
      if (cycleDays == null) {
        break missingId;
      }

      id = R.id.during_days;
      AppCompatEditText duringDays = ViewBindings.findChildViewById(rootView, id);
      if (duringDays == null) {
        break missingId;
      }

      id = R.id.form_layout;
      ScrollView formLayout = ViewBindings.findChildViewById(rootView, id);
      if (formLayout == null) {
        break missingId;
      }

      id = R.id.guideline3;
      Guideline guideline3 = ViewBindings.findChildViewById(rootView, id);
      if (guideline3 == null) {
        break missingId;
      }

      id = R.id.health_care;
      LinearLayout healthCare = ViewBindings.findChildViewById(rootView, id);
      if (healthCare == null) {
        break missingId;
      }

      id = R.id.last_period_strat_date;
      AppCompatEditText lastPeriodStratDate = ViewBindings.findChildViewById(rootView, id);
      if (lastPeriodStratDate == null) {
        break missingId;
      }

      id = R.id.linearLayout5;
      LinearLayout linearLayout5 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout5 == null) {
        break missingId;
      }

      id = R.id.main_layout;
      ScrollView mainLayout = ViewBindings.findChildViewById(rootView, id);
      if (mainLayout == null) {
        break missingId;
      }

      id = R.id.minus_data1;
      ImageView minusData1 = ViewBindings.findChildViewById(rootView, id);
      if (minusData1 == null) {
        break missingId;
      }

      id = R.id.minus_data2;
      ImageView minusData2 = ViewBindings.findChildViewById(rootView, id);
      if (minusData2 == null) {
        break missingId;
      }

      id = R.id.month_name;
      TextView monthName = ViewBindings.findChildViewById(rootView, id);
      if (monthName == null) {
        break missingId;
      }

      id = R.id.next_date;
      ImageView nextDate = ViewBindings.findChildViewById(rootView, id);
      if (nextDate == null) {
        break missingId;
      }

      id = R.id.period_calender;
      RecyclerView periodCalender = ViewBindings.findChildViewById(rootView, id);
      if (periodCalender == null) {
        break missingId;
      }

      id = R.id.period_date_picker;
      ImageView periodDatePicker = ViewBindings.findChildViewById(rootView, id);
      if (periodDatePicker == null) {
        break missingId;
      }

      id = R.id.periods_track;
      LinearLayout periodsTrack = ViewBindings.findChildViewById(rootView, id);
      if (periodsTrack == null) {
        break missingId;
      }

      id = R.id.periods_track_layout;
      ScrollView periodsTrackLayout = ViewBindings.findChildViewById(rootView, id);
      if (periodsTrackLayout == null) {
        break missingId;
      }

      id = R.id.reset_date;
      AppCompatButton resetDate = ViewBindings.findChildViewById(rootView, id);
      if (resetDate == null) {
        break missingId;
      }

      id = R.id.start_tracking;
      AppCompatButton startTracking = ViewBindings.findChildViewById(rootView, id);
      if (startTracking == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      return new FragmentWomenBinding((ConstraintLayout) rootView, addData1, addData2, back,
          backDate, changeDate, clear, cycleDays, duringDays, formLayout, guideline3, healthCare,
          lastPeriodStratDate, linearLayout5, mainLayout, minusData1, minusData2, monthName,
          nextDate, periodCalender, periodDatePicker, periodsTrack, periodsTrackLayout, resetDate,
          startTracking, textView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
