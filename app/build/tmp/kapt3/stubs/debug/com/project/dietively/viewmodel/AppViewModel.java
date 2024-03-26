package com.project.dietively.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\bJ\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u000fJ\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012J\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\bJ\u0014\u0010 \u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010!\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\fJ\u000e\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u000fJ\u000e\u0010#\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012J\u000e\u0010$\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\bJ\u000e\u0010%\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u000fJ\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\nR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\'"}, d2 = {"Lcom/project/dietively/viewmodel/AppViewModel;", "Landroidx/lifecycle/ViewModel;", "databaseRepository", "Lcom/project/dietively/roomdb/DatabaseRepository;", "(Lcom/project/dietively/roomdb/DatabaseRepository;)V", "getFoodItem", "Landroidx/lifecycle/LiveData;", "", "Lcom/project/dietively/roomdb/FoodItem;", "getGetFoodItem", "()Landroidx/lifecycle/LiveData;", "getMenstrualDays", "Lcom/project/dietively/roomdb/MenstrualDays;", "getGetMenstrualDays", "getUser", "Lcom/project/dietively/roomdb/UserProfile;", "getGetUser", "getUserDailyData", "Lcom/project/dietively/roomdb/DailyData;", "getGetUserDailyData", "toastMsgStr", "Landroidx/lifecycle/MutableLiveData;", "", "getToastMsgStr", "()Landroidx/lifecycle/MutableLiveData;", "deleteFoodItem", "", "data", "deleteUser", "userProfile", "deleteUserData", "insertFoodItem", "insertFoodItems", "insertMenstrualDays", "insertUser", "insertUserData", "updateFoodItem", "updateUser", "updateUserData", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AppViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.project.dietively.roomdb.DatabaseRepository databaseRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> toastMsgStr = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.project.dietively.roomdb.UserProfile>> getUser = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.project.dietively.roomdb.DailyData>> getUserDailyData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.project.dietively.roomdb.FoodItem>> getFoodItem = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.project.dietively.roomdb.MenstrualDays>> getMenstrualDays = null;
    
    @javax.inject.Inject()
    public AppViewModel(@org.jetbrains.annotations.NotNull()
    com.project.dietively.roomdb.DatabaseRepository databaseRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getToastMsgStr() {
        return null;
    }
    
    public final void insertUser(@org.jetbrains.annotations.NotNull()
    com.project.dietively.roomdb.UserProfile userProfile) {
    }
    
    public final void updateUser(@org.jetbrains.annotations.NotNull()
    com.project.dietively.roomdb.UserProfile userProfile) {
    }
    
    public final void deleteUser(@org.jetbrains.annotations.NotNull()
    com.project.dietively.roomdb.UserProfile userProfile) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.project.dietively.roomdb.UserProfile>> getGetUser() {
        return null;
    }
    
    public final void insertUserData(@org.jetbrains.annotations.NotNull()
    com.project.dietively.roomdb.DailyData data) {
    }
    
    public final void updateUserData(@org.jetbrains.annotations.NotNull()
    com.project.dietively.roomdb.DailyData data) {
    }
    
    public final void deleteUserData(@org.jetbrains.annotations.NotNull()
    com.project.dietively.roomdb.DailyData data) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.project.dietively.roomdb.DailyData>> getGetUserDailyData() {
        return null;
    }
    
    public final void insertFoodItem(@org.jetbrains.annotations.NotNull()
    com.project.dietively.roomdb.FoodItem data) {
    }
    
    public final void insertFoodItems(@org.jetbrains.annotations.NotNull()
    java.util.List<com.project.dietively.roomdb.FoodItem> data) {
    }
    
    public final void updateFoodItem(@org.jetbrains.annotations.NotNull()
    com.project.dietively.roomdb.FoodItem data) {
    }
    
    public final void deleteFoodItem(@org.jetbrains.annotations.NotNull()
    com.project.dietively.roomdb.FoodItem data) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.project.dietively.roomdb.FoodItem>> getGetFoodItem() {
        return null;
    }
    
    public final void insertMenstrualDays(@org.jetbrains.annotations.NotNull()
    com.project.dietively.roomdb.MenstrualDays data) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.project.dietively.roomdb.MenstrualDays>> getGetMenstrualDays() {
        return null;
    }
}