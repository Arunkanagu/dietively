// Generated by view binder compiler. Do not edit!
package com.project.dietively.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.project.dietively.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DialogChangeDataBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final ImageView addData1;

  @NonNull
  public final ImageView addData2;

  @NonNull
  public final AppCompatEditText cycleDays;

  @NonNull
  public final AppCompatEditText duringDays;

  @NonNull
  public final AppCompatEditText lastPeriodStratDate;

  @NonNull
  public final ImageView minusData1;

  @NonNull
  public final ImageView minusData2;

  @NonNull
  public final ImageView periodDatePicker;

  @NonNull
  public final AppCompatButton startTracking;

  private DialogChangeDataBinding(@NonNull CardView rootView, @NonNull ImageView addData1,
      @NonNull ImageView addData2, @NonNull AppCompatEditText cycleDays,
      @NonNull AppCompatEditText duringDays, @NonNull AppCompatEditText lastPeriodStratDate,
      @NonNull ImageView minusData1, @NonNull ImageView minusData2,
      @NonNull ImageView periodDatePicker, @NonNull AppCompatButton startTracking) {
    this.rootView = rootView;
    this.addData1 = addData1;
    this.addData2 = addData2;
    this.cycleDays = cycleDays;
    this.duringDays = duringDays;
    this.lastPeriodStratDate = lastPeriodStratDate;
    this.minusData1 = minusData1;
    this.minusData2 = minusData2;
    this.periodDatePicker = periodDatePicker;
    this.startTracking = startTracking;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogChangeDataBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogChangeDataBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_change_data, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogChangeDataBinding bind(@NonNull View rootView) {
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

      id = R.id.last_period_strat_date;
      AppCompatEditText lastPeriodStratDate = ViewBindings.findChildViewById(rootView, id);
      if (lastPeriodStratDate == null) {
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

      id = R.id.period_date_picker;
      ImageView periodDatePicker = ViewBindings.findChildViewById(rootView, id);
      if (periodDatePicker == null) {
        break missingId;
      }

      id = R.id.start_tracking;
      AppCompatButton startTracking = ViewBindings.findChildViewById(rootView, id);
      if (startTracking == null) {
        break missingId;
      }

      return new DialogChangeDataBinding((CardView) rootView, addData1, addData2, cycleDays,
          duringDays, lastPeriodStratDate, minusData1, minusData2, periodDatePicker, startTracking);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}