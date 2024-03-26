package com.project.dietively.roomdb;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class DatabaseDao_Impl implements DatabaseDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserProfile> __insertionAdapterOfUserProfile;

  private final EntityInsertionAdapter<DailyData> __insertionAdapterOfDailyData;

  private final EntityInsertionAdapter<FoodItem> __insertionAdapterOfFoodItem;

  private final EntityInsertionAdapter<FoodItem> __insertionAdapterOfFoodItem_1;

  private final EntityInsertionAdapter<MenstrualDays> __insertionAdapterOfMenstrualDays;

  private final EntityDeletionOrUpdateAdapter<UserProfile> __deletionAdapterOfUserProfile;

  private final EntityDeletionOrUpdateAdapter<DailyData> __deletionAdapterOfDailyData;

  private final EntityDeletionOrUpdateAdapter<FoodItem> __deletionAdapterOfFoodItem;

  private final EntityDeletionOrUpdateAdapter<UserProfile> __updateAdapterOfUserProfile;

  private final EntityDeletionOrUpdateAdapter<DailyData> __updateAdapterOfDailyData;

  private final EntityDeletionOrUpdateAdapter<FoodItem> __updateAdapterOfFoodItem;

  public DatabaseDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserProfile = new EntityInsertionAdapter<UserProfile>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `user_profile` (`id`,`user`,`email`,`phone`,`date_of_birth`,`age`,`genter`,`password`,`tracking`,`trackingData`,`last_update`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserProfile entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getUser() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getUser());
        }
        if (entity.getEmail() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getEmail());
        }
        if (entity.getPhone() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getPhone());
        }
        if (entity.getDateOfBirth() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getDateOfBirth());
        }
        statement.bindLong(6, entity.getAge());
        if (entity.getGenter() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getGenter());
        }
        if (entity.getPassword() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getPassword());
        }
        if (entity.getTracking() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getTracking());
        }
        if (entity.getTrackingData() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getTrackingData());
        }
        statement.bindLong(11, entity.getLastUpdate());
      }
    };
    this.__insertionAdapterOfDailyData = new EntityInsertionAdapter<DailyData>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `daily_data` (`date`,`user_id`,`food_item_name`,`calories`,`protein`,`carbohydrates`,`fat`,`add_count`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final DailyData entity) {
        if (entity.getDate() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getDate());
        }
        if (entity.getUserId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getUserId());
        }
        if (entity.getFoodItemName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getFoodItemName());
        }
        if (entity.getCalories() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCalories());
        }
        if (entity.getProtein() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getProtein());
        }
        if (entity.getCarbohydrates() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getCarbohydrates());
        }
        if (entity.getFat() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getFat());
        }
        statement.bindLong(8, entity.getAddCount());
      }
    };
    this.__insertionAdapterOfFoodItem = new EntityInsertionAdapter<FoodItem>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `food_item` (`name`,`calories`,`protein`,`fat`,`carbohydrates`,`type`,`img`,`id`) VALUES (?,?,?,?,?,?,?,nullif(?, 0))";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FoodItem entity) {
        if (entity.getName() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getName());
        }
        if (entity.getCalories() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getCalories());
        }
        if (entity.getProtein() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getProtein());
        }
        if (entity.getFat() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getFat());
        }
        if (entity.getCarbohydrates() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCarbohydrates());
        }
        if (entity.getType() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getType());
        }
        statement.bindLong(7, entity.getImg());
        statement.bindLong(8, entity.getId());
      }
    };
    this.__insertionAdapterOfFoodItem_1 = new EntityInsertionAdapter<FoodItem>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR IGNORE INTO `food_item` (`name`,`calories`,`protein`,`fat`,`carbohydrates`,`type`,`img`,`id`) VALUES (?,?,?,?,?,?,?,nullif(?, 0))";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FoodItem entity) {
        if (entity.getName() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getName());
        }
        if (entity.getCalories() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getCalories());
        }
        if (entity.getProtein() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getProtein());
        }
        if (entity.getFat() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getFat());
        }
        if (entity.getCarbohydrates() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCarbohydrates());
        }
        if (entity.getType() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getType());
        }
        statement.bindLong(7, entity.getImg());
        statement.bindLong(8, entity.getId());
      }
    };
    this.__insertionAdapterOfMenstrualDays = new EntityInsertionAdapter<MenstrualDays>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `menstrual_day_data` (`id`,`email`,`lastPeriodStartDate`,`duringDays`,`usualCycleLength`,`saveTime`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final MenstrualDays entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getEmail() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getEmail());
        }
        if (entity.getLastPeriodStartDate() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getLastPeriodStartDate());
        }
        statement.bindLong(4, entity.getDuringDays());
        statement.bindLong(5, entity.getUsualCycleLength());
        statement.bindLong(6, entity.getSaveTime());
      }
    };
    this.__deletionAdapterOfUserProfile = new EntityDeletionOrUpdateAdapter<UserProfile>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `user_profile` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserProfile entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__deletionAdapterOfDailyData = new EntityDeletionOrUpdateAdapter<DailyData>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `daily_data` WHERE `date` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final DailyData entity) {
        if (entity.getDate() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getDate());
        }
      }
    };
    this.__deletionAdapterOfFoodItem = new EntityDeletionOrUpdateAdapter<FoodItem>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `food_item` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FoodItem entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfUserProfile = new EntityDeletionOrUpdateAdapter<UserProfile>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `user_profile` SET `id` = ?,`user` = ?,`email` = ?,`phone` = ?,`date_of_birth` = ?,`age` = ?,`genter` = ?,`password` = ?,`tracking` = ?,`trackingData` = ?,`last_update` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserProfile entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getUser() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getUser());
        }
        if (entity.getEmail() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getEmail());
        }
        if (entity.getPhone() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getPhone());
        }
        if (entity.getDateOfBirth() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getDateOfBirth());
        }
        statement.bindLong(6, entity.getAge());
        if (entity.getGenter() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getGenter());
        }
        if (entity.getPassword() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getPassword());
        }
        if (entity.getTracking() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getTracking());
        }
        if (entity.getTrackingData() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getTrackingData());
        }
        statement.bindLong(11, entity.getLastUpdate());
        statement.bindLong(12, entity.getId());
      }
    };
    this.__updateAdapterOfDailyData = new EntityDeletionOrUpdateAdapter<DailyData>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `daily_data` SET `date` = ?,`user_id` = ?,`food_item_name` = ?,`calories` = ?,`protein` = ?,`carbohydrates` = ?,`fat` = ?,`add_count` = ? WHERE `date` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final DailyData entity) {
        if (entity.getDate() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getDate());
        }
        if (entity.getUserId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getUserId());
        }
        if (entity.getFoodItemName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getFoodItemName());
        }
        if (entity.getCalories() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCalories());
        }
        if (entity.getProtein() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getProtein());
        }
        if (entity.getCarbohydrates() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getCarbohydrates());
        }
        if (entity.getFat() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getFat());
        }
        statement.bindLong(8, entity.getAddCount());
        if (entity.getDate() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getDate());
        }
      }
    };
    this.__updateAdapterOfFoodItem = new EntityDeletionOrUpdateAdapter<FoodItem>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `food_item` SET `name` = ?,`calories` = ?,`protein` = ?,`fat` = ?,`carbohydrates` = ?,`type` = ?,`img` = ?,`id` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FoodItem entity) {
        if (entity.getName() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getName());
        }
        if (entity.getCalories() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getCalories());
        }
        if (entity.getProtein() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getProtein());
        }
        if (entity.getFat() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getFat());
        }
        if (entity.getCarbohydrates() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCarbohydrates());
        }
        if (entity.getType() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getType());
        }
        statement.bindLong(7, entity.getImg());
        statement.bindLong(8, entity.getId());
        statement.bindLong(9, entity.getId());
      }
    };
  }

  @Override
  public Object insertUser(final UserProfile userProfile,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUserProfile.insert(userProfile);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertUserDailyData(final DailyData data,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfDailyData.insert(data);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertFoodItem(final FoodItem data, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFoodItem.insert(data);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertFoodItems(final List<FoodItem> foodItems,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFoodItem_1.insert(foodItems);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertMenstrualDays(final MenstrualDays data,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfMenstrualDays.insert(data);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteUser(final UserProfile userProfile,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfUserProfile.handle(userProfile);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteUserDailyData(final DailyData data,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfDailyData.handle(data);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteFoodItem(final FoodItem data, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfFoodItem.handle(data);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateUser(final UserProfile userProfile,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfUserProfile.handle(userProfile);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateUserDailyData(final DailyData data,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfDailyData.handle(data);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateFoodItem(final FoodItem data, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfFoodItem.handle(data);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<UserProfile>> getUser() {
    final String _sql = "SELECT * FROM user_profile";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"user_profile"}, false, new Callable<List<UserProfile>>() {
      @Override
      @Nullable
      public List<UserProfile> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUser = CursorUtil.getColumnIndexOrThrow(_cursor, "user");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfDateOfBirth = CursorUtil.getColumnIndexOrThrow(_cursor, "date_of_birth");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfGenter = CursorUtil.getColumnIndexOrThrow(_cursor, "genter");
          final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
          final int _cursorIndexOfTracking = CursorUtil.getColumnIndexOrThrow(_cursor, "tracking");
          final int _cursorIndexOfTrackingData = CursorUtil.getColumnIndexOrThrow(_cursor, "trackingData");
          final int _cursorIndexOfLastUpdate = CursorUtil.getColumnIndexOrThrow(_cursor, "last_update");
          final List<UserProfile> _result = new ArrayList<UserProfile>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final UserProfile _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpUser;
            if (_cursor.isNull(_cursorIndexOfUser)) {
              _tmpUser = null;
            } else {
              _tmpUser = _cursor.getString(_cursorIndexOfUser);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpDateOfBirth;
            if (_cursor.isNull(_cursorIndexOfDateOfBirth)) {
              _tmpDateOfBirth = null;
            } else {
              _tmpDateOfBirth = _cursor.getString(_cursorIndexOfDateOfBirth);
            }
            final int _tmpAge;
            _tmpAge = _cursor.getInt(_cursorIndexOfAge);
            final String _tmpGenter;
            if (_cursor.isNull(_cursorIndexOfGenter)) {
              _tmpGenter = null;
            } else {
              _tmpGenter = _cursor.getString(_cursorIndexOfGenter);
            }
            final String _tmpPassword;
            if (_cursor.isNull(_cursorIndexOfPassword)) {
              _tmpPassword = null;
            } else {
              _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            }
            final String _tmpTracking;
            if (_cursor.isNull(_cursorIndexOfTracking)) {
              _tmpTracking = null;
            } else {
              _tmpTracking = _cursor.getString(_cursorIndexOfTracking);
            }
            final String _tmpTrackingData;
            if (_cursor.isNull(_cursorIndexOfTrackingData)) {
              _tmpTrackingData = null;
            } else {
              _tmpTrackingData = _cursor.getString(_cursorIndexOfTrackingData);
            }
            final long _tmpLastUpdate;
            _tmpLastUpdate = _cursor.getLong(_cursorIndexOfLastUpdate);
            _item = new UserProfile(_tmpId,_tmpUser,_tmpEmail,_tmpPhone,_tmpDateOfBirth,_tmpAge,_tmpGenter,_tmpPassword,_tmpTracking,_tmpTrackingData,_tmpLastUpdate);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<DailyData>> getUserDailyData() {
    final String _sql = "SELECT * FROM daily_data";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"daily_data"}, false, new Callable<List<DailyData>>() {
      @Override
      @Nullable
      public List<DailyData> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
          final int _cursorIndexOfFoodItemName = CursorUtil.getColumnIndexOrThrow(_cursor, "food_item_name");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "protein");
          final int _cursorIndexOfCarbohydrates = CursorUtil.getColumnIndexOrThrow(_cursor, "carbohydrates");
          final int _cursorIndexOfFat = CursorUtil.getColumnIndexOrThrow(_cursor, "fat");
          final int _cursorIndexOfAddCount = CursorUtil.getColumnIndexOrThrow(_cursor, "add_count");
          final List<DailyData> _result = new ArrayList<DailyData>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final DailyData _item;
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final String _tmpFoodItemName;
            if (_cursor.isNull(_cursorIndexOfFoodItemName)) {
              _tmpFoodItemName = null;
            } else {
              _tmpFoodItemName = _cursor.getString(_cursorIndexOfFoodItemName);
            }
            final String _tmpCalories;
            if (_cursor.isNull(_cursorIndexOfCalories)) {
              _tmpCalories = null;
            } else {
              _tmpCalories = _cursor.getString(_cursorIndexOfCalories);
            }
            final String _tmpProtein;
            if (_cursor.isNull(_cursorIndexOfProtein)) {
              _tmpProtein = null;
            } else {
              _tmpProtein = _cursor.getString(_cursorIndexOfProtein);
            }
            final String _tmpCarbohydrates;
            if (_cursor.isNull(_cursorIndexOfCarbohydrates)) {
              _tmpCarbohydrates = null;
            } else {
              _tmpCarbohydrates = _cursor.getString(_cursorIndexOfCarbohydrates);
            }
            final String _tmpFat;
            if (_cursor.isNull(_cursorIndexOfFat)) {
              _tmpFat = null;
            } else {
              _tmpFat = _cursor.getString(_cursorIndexOfFat);
            }
            final int _tmpAddCount;
            _tmpAddCount = _cursor.getInt(_cursorIndexOfAddCount);
            _item = new DailyData(_tmpDate,_tmpUserId,_tmpFoodItemName,_tmpCalories,_tmpProtein,_tmpCarbohydrates,_tmpFat,_tmpAddCount);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<FoodItem>> getFoodItem() {
    final String _sql = "SELECT * FROM food_item";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"food_item"}, false, new Callable<List<FoodItem>>() {
      @Override
      @Nullable
      public List<FoodItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "protein");
          final int _cursorIndexOfFat = CursorUtil.getColumnIndexOrThrow(_cursor, "fat");
          final int _cursorIndexOfCarbohydrates = CursorUtil.getColumnIndexOrThrow(_cursor, "carbohydrates");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfImg = CursorUtil.getColumnIndexOrThrow(_cursor, "img");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<FoodItem> _result = new ArrayList<FoodItem>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final FoodItem _item;
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpCalories;
            if (_cursor.isNull(_cursorIndexOfCalories)) {
              _tmpCalories = null;
            } else {
              _tmpCalories = _cursor.getString(_cursorIndexOfCalories);
            }
            final String _tmpProtein;
            if (_cursor.isNull(_cursorIndexOfProtein)) {
              _tmpProtein = null;
            } else {
              _tmpProtein = _cursor.getString(_cursorIndexOfProtein);
            }
            final String _tmpFat;
            if (_cursor.isNull(_cursorIndexOfFat)) {
              _tmpFat = null;
            } else {
              _tmpFat = _cursor.getString(_cursorIndexOfFat);
            }
            final String _tmpCarbohydrates;
            if (_cursor.isNull(_cursorIndexOfCarbohydrates)) {
              _tmpCarbohydrates = null;
            } else {
              _tmpCarbohydrates = _cursor.getString(_cursorIndexOfCarbohydrates);
            }
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            final int _tmpImg;
            _tmpImg = _cursor.getInt(_cursorIndexOfImg);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item = new FoodItem(_tmpName,_tmpCalories,_tmpProtein,_tmpFat,_tmpCarbohydrates,_tmpType,_tmpImg,_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<MenstrualDays>> getMenstrualDays() {
    final String _sql = "SELECT * FROM menstrual_day_data";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"menstrual_day_data"}, false, new Callable<List<MenstrualDays>>() {
      @Override
      @Nullable
      public List<MenstrualDays> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfLastPeriodStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPeriodStartDate");
          final int _cursorIndexOfDuringDays = CursorUtil.getColumnIndexOrThrow(_cursor, "duringDays");
          final int _cursorIndexOfUsualCycleLength = CursorUtil.getColumnIndexOrThrow(_cursor, "usualCycleLength");
          final int _cursorIndexOfSaveTime = CursorUtil.getColumnIndexOrThrow(_cursor, "saveTime");
          final List<MenstrualDays> _result = new ArrayList<MenstrualDays>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final MenstrualDays _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpLastPeriodStartDate;
            if (_cursor.isNull(_cursorIndexOfLastPeriodStartDate)) {
              _tmpLastPeriodStartDate = null;
            } else {
              _tmpLastPeriodStartDate = _cursor.getString(_cursorIndexOfLastPeriodStartDate);
            }
            final int _tmpDuringDays;
            _tmpDuringDays = _cursor.getInt(_cursorIndexOfDuringDays);
            final int _tmpUsualCycleLength;
            _tmpUsualCycleLength = _cursor.getInt(_cursorIndexOfUsualCycleLength);
            final long _tmpSaveTime;
            _tmpSaveTime = _cursor.getLong(_cursorIndexOfSaveTime);
            _item = new MenstrualDays(_tmpId,_tmpEmail,_tmpLastPeriodStartDate,_tmpDuringDays,_tmpUsualCycleLength,_tmpSaveTime);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
