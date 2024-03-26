package com.project.dietively.roomdb;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u0017J\u001c\u0010\u001e\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086@\u00a2\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u001aJ\u0016\u0010#\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u001cJ\u0016\u0010$\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u0017J\u0016\u0010%\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u001aJ\u0016\u0010&\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\n\u00a8\u0006\'"}, d2 = {"Lcom/project/dietively/roomdb/DatabaseRepository;", "", "databaseDao", "Lcom/project/dietively/roomdb/DatabaseDao;", "(Lcom/project/dietively/roomdb/DatabaseDao;)V", "getFoodItem", "Landroidx/lifecycle/LiveData;", "", "Lcom/project/dietively/roomdb/FoodItem;", "getGetFoodItem", "()Landroidx/lifecycle/LiveData;", "getMenstrualDays", "Lcom/project/dietively/roomdb/MenstrualDays;", "getGetMenstrualDays", "getUser", "Lcom/project/dietively/roomdb/UserProfile;", "getGetUser", "getUserDailyData", "Lcom/project/dietively/roomdb/DailyData;", "getGetUserDailyData", "deleteFoodItem", "", "data", "(Lcom/project/dietively/roomdb/FoodItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteUser", "userProfile", "(Lcom/project/dietively/roomdb/UserProfile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteUserData", "(Lcom/project/dietively/roomdb/DailyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertFoodItem", "insertFoodItems", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertMenstrualDays", "(Lcom/project/dietively/roomdb/MenstrualDays;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUser", "insertUserData", "updateFoodItem", "updateUser", "updateUserData", "app_debug"})
public final class DatabaseRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.project.dietively.roomdb.DatabaseDao databaseDao = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.project.dietively.roomdb.UserProfile>> getUser = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.project.dietively.roomdb.DailyData>> getUserDailyData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.project.dietively.roomdb.FoodItem>> getFoodItem = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.project.dietively.roomdb.MenstrualDays>> getMenstrualDays = null;
    
    @javax.inject.Inject()
    public DatabaseRepository(@org.jetbrains.annotations.NotNull()
    com.project.dietively.roomdb.DatabaseDao databaseDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertUser(@org.jetbrains.annotations.NotNull()
    com.project.dietively.roomdb.UserProfile userProfile, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateUser(@org.jetbrains.annotations.NotNull()
    com.project.dietively.roomdb.UserProfile userProfile, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteUser(@org.jetbrains.annotations.NotNull()
    com.project.dietively.roomdb.UserProfile userProfile, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.project.dietively.roomdb.UserProfile>> getGetUser() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertUserData(@org.jetbrains.annotations.NotNull()
    com.project.dietively.roomdb.DailyData data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateUserData(@org.jetbrains.annotations.NotNull()
    com.project.dietively.roomdb.DailyData data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteUserData(@org.jetbrains.annotations.NotNull()
    com.project.dietively.roomdb.DailyData data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.project.dietively.roomdb.DailyData>> getGetUserDailyData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertFoodItem(@org.jetbrains.annotations.NotNull()
    com.project.dietively.roomdb.FoodItem data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertFoodItems(@org.jetbrains.annotations.NotNull()
    java.util.List<com.project.dietively.roomdb.FoodItem> data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateFoodItem(@org.jetbrains.annotations.NotNull()
    com.project.dietively.roomdb.FoodItem data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteFoodItem(@org.jetbrains.annotations.NotNull()
    com.project.dietively.roomdb.FoodItem data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.project.dietively.roomdb.FoodItem>> getGetFoodItem() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertMenstrualDays(@org.jetbrains.annotations.NotNull()
    com.project.dietively.roomdb.MenstrualDays data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.project.dietively.roomdb.MenstrualDays>> getGetMenstrualDays() {
        return null;
    }
}