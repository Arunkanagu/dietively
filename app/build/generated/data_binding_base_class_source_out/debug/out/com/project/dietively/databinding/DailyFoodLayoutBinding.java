// Generated by view binder compiler. Do not edit!
package com.project.dietively.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.project.dietively.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DailyFoodLayoutBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView calories;

  @NonNull
  public final TextView carbohydrates;

  @NonNull
  public final TextView fat;

  @NonNull
  public final TextView foodName;

  @NonNull
  public final TextView protein;

  @NonNull
  public final TextView quantity;

  @NonNull
  public final ImageView removeFood;

  private DailyFoodLayoutBinding(@NonNull CardView rootView, @NonNull TextView calories,
      @NonNull TextView carbohydrates, @NonNull TextView fat, @NonNull TextView foodName,
      @NonNull TextView protein, @NonNull TextView quantity, @NonNull ImageView removeFood) {
    this.rootView = rootView;
    this.calories = calories;
    this.carbohydrates = carbohydrates;
    this.fat = fat;
    this.foodName = foodName;
    this.protein = protein;
    this.quantity = quantity;
    this.removeFood = removeFood;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static DailyFoodLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DailyFoodLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.daily_food_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DailyFoodLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.calories;
      TextView calories = ViewBindings.findChildViewById(rootView, id);
      if (calories == null) {
        break missingId;
      }

      id = R.id.carbohydrates;
      TextView carbohydrates = ViewBindings.findChildViewById(rootView, id);
      if (carbohydrates == null) {
        break missingId;
      }

      id = R.id.fat;
      TextView fat = ViewBindings.findChildViewById(rootView, id);
      if (fat == null) {
        break missingId;
      }

      id = R.id.food_name;
      TextView foodName = ViewBindings.findChildViewById(rootView, id);
      if (foodName == null) {
        break missingId;
      }

      id = R.id.protein;
      TextView protein = ViewBindings.findChildViewById(rootView, id);
      if (protein == null) {
        break missingId;
      }

      id = R.id.quantity;
      TextView quantity = ViewBindings.findChildViewById(rootView, id);
      if (quantity == null) {
        break missingId;
      }

      id = R.id.remove_food;
      ImageView removeFood = ViewBindings.findChildViewById(rootView, id);
      if (removeFood == null) {
        break missingId;
      }

      return new DailyFoodLayoutBinding((CardView) rootView, calories, carbohydrates, fat, foodName,
          protein, quantity, removeFood);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
