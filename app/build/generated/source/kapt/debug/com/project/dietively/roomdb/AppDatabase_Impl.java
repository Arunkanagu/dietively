package com.project.dietively.roomdb;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile DatabaseDao _databaseDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `user_profile` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `user` TEXT NOT NULL, `email` TEXT NOT NULL, `phone` TEXT NOT NULL, `date_of_birth` TEXT NOT NULL, `age` INTEGER NOT NULL, `genter` TEXT NOT NULL, `password` TEXT NOT NULL, `tracking` TEXT NOT NULL, `trackingData` TEXT NOT NULL, `last_update` INTEGER NOT NULL)");
        db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_user_profile_email` ON `user_profile` (`email`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `daily_data` (`date` TEXT NOT NULL, `user_id` TEXT NOT NULL, `food_item_name` TEXT NOT NULL, `calories` TEXT NOT NULL, `protein` TEXT NOT NULL, `carbohydrates` TEXT NOT NULL, `fat` TEXT NOT NULL, `add_count` INTEGER NOT NULL, PRIMARY KEY(`date`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `food_item` (`name` TEXT NOT NULL, `calories` TEXT NOT NULL, `protein` TEXT NOT NULL, `fat` TEXT NOT NULL, `carbohydrates` TEXT NOT NULL, `type` TEXT NOT NULL, `img` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `menstrual_day_data` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `email` TEXT NOT NULL, `lastPeriodStartDate` TEXT NOT NULL, `duringDays` INTEGER NOT NULL, `usualCycleLength` INTEGER NOT NULL, `saveTime` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '62475ea19b5304d4600eff9385b9ae97')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `user_profile`");
        db.execSQL("DROP TABLE IF EXISTS `daily_data`");
        db.execSQL("DROP TABLE IF EXISTS `food_item`");
        db.execSQL("DROP TABLE IF EXISTS `menstrual_day_data`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsUserProfile = new HashMap<String, TableInfo.Column>(11);
        _columnsUserProfile.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfile.put("user", new TableInfo.Column("user", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfile.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfile.put("phone", new TableInfo.Column("phone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfile.put("date_of_birth", new TableInfo.Column("date_of_birth", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfile.put("age", new TableInfo.Column("age", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfile.put("genter", new TableInfo.Column("genter", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfile.put("password", new TableInfo.Column("password", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfile.put("tracking", new TableInfo.Column("tracking", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfile.put("trackingData", new TableInfo.Column("trackingData", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfile.put("last_update", new TableInfo.Column("last_update", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserProfile = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUserProfile = new HashSet<TableInfo.Index>(1);
        _indicesUserProfile.add(new TableInfo.Index("index_user_profile_email", true, Arrays.asList("email"), Arrays.asList("ASC")));
        final TableInfo _infoUserProfile = new TableInfo("user_profile", _columnsUserProfile, _foreignKeysUserProfile, _indicesUserProfile);
        final TableInfo _existingUserProfile = TableInfo.read(db, "user_profile");
        if (!_infoUserProfile.equals(_existingUserProfile)) {
          return new RoomOpenHelper.ValidationResult(false, "user_profile(com.project.dietively.roomdb.UserProfile).\n"
                  + " Expected:\n" + _infoUserProfile + "\n"
                  + " Found:\n" + _existingUserProfile);
        }
        final HashMap<String, TableInfo.Column> _columnsDailyData = new HashMap<String, TableInfo.Column>(8);
        _columnsDailyData.put("date", new TableInfo.Column("date", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDailyData.put("user_id", new TableInfo.Column("user_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDailyData.put("food_item_name", new TableInfo.Column("food_item_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDailyData.put("calories", new TableInfo.Column("calories", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDailyData.put("protein", new TableInfo.Column("protein", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDailyData.put("carbohydrates", new TableInfo.Column("carbohydrates", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDailyData.put("fat", new TableInfo.Column("fat", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDailyData.put("add_count", new TableInfo.Column("add_count", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDailyData = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDailyData = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDailyData = new TableInfo("daily_data", _columnsDailyData, _foreignKeysDailyData, _indicesDailyData);
        final TableInfo _existingDailyData = TableInfo.read(db, "daily_data");
        if (!_infoDailyData.equals(_existingDailyData)) {
          return new RoomOpenHelper.ValidationResult(false, "daily_data(com.project.dietively.roomdb.DailyData).\n"
                  + " Expected:\n" + _infoDailyData + "\n"
                  + " Found:\n" + _existingDailyData);
        }
        final HashMap<String, TableInfo.Column> _columnsFoodItem = new HashMap<String, TableInfo.Column>(8);
        _columnsFoodItem.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodItem.put("calories", new TableInfo.Column("calories", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodItem.put("protein", new TableInfo.Column("protein", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodItem.put("fat", new TableInfo.Column("fat", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodItem.put("carbohydrates", new TableInfo.Column("carbohydrates", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodItem.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodItem.put("img", new TableInfo.Column("img", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodItem.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFoodItem = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFoodItem = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFoodItem = new TableInfo("food_item", _columnsFoodItem, _foreignKeysFoodItem, _indicesFoodItem);
        final TableInfo _existingFoodItem = TableInfo.read(db, "food_item");
        if (!_infoFoodItem.equals(_existingFoodItem)) {
          return new RoomOpenHelper.ValidationResult(false, "food_item(com.project.dietively.roomdb.FoodItem).\n"
                  + " Expected:\n" + _infoFoodItem + "\n"
                  + " Found:\n" + _existingFoodItem);
        }
        final HashMap<String, TableInfo.Column> _columnsMenstrualDayData = new HashMap<String, TableInfo.Column>(6);
        _columnsMenstrualDayData.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMenstrualDayData.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMenstrualDayData.put("lastPeriodStartDate", new TableInfo.Column("lastPeriodStartDate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMenstrualDayData.put("duringDays", new TableInfo.Column("duringDays", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMenstrualDayData.put("usualCycleLength", new TableInfo.Column("usualCycleLength", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMenstrualDayData.put("saveTime", new TableInfo.Column("saveTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMenstrualDayData = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMenstrualDayData = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMenstrualDayData = new TableInfo("menstrual_day_data", _columnsMenstrualDayData, _foreignKeysMenstrualDayData, _indicesMenstrualDayData);
        final TableInfo _existingMenstrualDayData = TableInfo.read(db, "menstrual_day_data");
        if (!_infoMenstrualDayData.equals(_existingMenstrualDayData)) {
          return new RoomOpenHelper.ValidationResult(false, "menstrual_day_data(com.project.dietively.roomdb.MenstrualDays).\n"
                  + " Expected:\n" + _infoMenstrualDayData + "\n"
                  + " Found:\n" + _existingMenstrualDayData);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "62475ea19b5304d4600eff9385b9ae97", "d9d9c0de500e032c948b0b931006a83e");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "user_profile","daily_data","food_item","menstrual_day_data");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `user_profile`");
      _db.execSQL("DELETE FROM `daily_data`");
      _db.execSQL("DELETE FROM `food_item`");
      _db.execSQL("DELETE FROM `menstrual_day_data`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(DatabaseDao.class, DatabaseDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public DatabaseDao databaseDao() {
    if (_databaseDao != null) {
      return _databaseDao;
    } else {
      synchronized(this) {
        if(_databaseDao == null) {
          _databaseDao = new DatabaseDao_Impl(this);
        }
        return _databaseDao;
      }
    }
  }
}
