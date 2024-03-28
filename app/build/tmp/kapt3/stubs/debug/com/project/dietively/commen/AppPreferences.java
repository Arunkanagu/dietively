package com.project.dietively.commen;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0001\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001bR\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R(\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Lcom/project/dietively/commen/AppPreferences;", "", "()V", "EXP_DATE", "Lkotlin/Pair;", "", "", "LOGIN_UUID", "NAME", "TODAY_DATA", "value", "expDate", "getExpDate", "()Ljava/lang/String;", "setExpDate", "(Ljava/lang/String;)V", "loginUuid", "getLoginUuid", "setLoginUuid", "preferences", "Landroid/content/SharedPreferences;", "todayData", "getTodayData", "setTodayData", "init", "", "context", "Landroid/content/Context;", "app_debug"})
public final class AppPreferences {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String NAME = "kiosk_browser_preferences";
    private static android.content.SharedPreferences preferences;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Pair LOGIN_UUID = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Pair TODAY_DATA = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Pair EXP_DATE = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.project.dietively.commen.AppPreferences INSTANCE = null;
    
    private AppPreferences() {
        super();
    }
    
    public final void init(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLoginUuid() {
        return null;
    }
    
    public final void setLoginUuid(@org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTodayData() {
        return null;
    }
    
    public final void setTodayData(@org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getExpDate() {
        return null;
    }
    
    public final void setExpDate(@org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
}