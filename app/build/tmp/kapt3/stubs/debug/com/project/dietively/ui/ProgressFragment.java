package com.project.dietively.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005\u00a2\u0006\u0002\u0010\u0002J@\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0016H\u0002J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\u001a\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010&\u001a\u00020#2\b\b\u0002\u0010\'\u001a\u00020(H\u0002J \u0010)\u001a\u00020#2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014H\u0002J\u0016\u0010*\u001a\u00020#2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0012\u0010,\u001a\u00020#2\b\b\u0002\u0010-\u001a\u00020.H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u00060"}, d2 = {"Lcom/project/dietively/ui/ProgressFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/project/dietively/databinding/FragmentProgressBinding;", "binding", "getBinding", "()Lcom/project/dietively/databinding/FragmentProgressBinding;", "dailyData", "", "Lcom/project/dietively/roomdb/DailyData;", "viewModel", "Lcom/project/dietively/viewmodel/AppViewModel;", "getViewModel", "()Lcom/project/dietively/viewmodel/AppViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "generatePieEntries", "Ljava/util/ArrayList;", "Lcom/github/mikephil/charting/data/PieEntry;", "Lkotlin/collections/ArrayList;", "calSum", "", "proSum", "carSum", "fatSum", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onViewCreated", "view", "processData", "filteredDateStr", "", "setChart", "setTodayList", "list", "showDatePickerDialog", "context", "Landroid/content/Context;", "Companion", "app_debug"})
public final class ProgressFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.project.dietively.databinding.FragmentProgressBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.project.dietively.roomdb.DailyData> dailyData;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "ProgressFragment";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String selectedDate;
    @org.jetbrains.annotations.NotNull()
    public static final com.project.dietively.ui.ProgressFragment.Companion Companion = null;
    
    public ProgressFragment() {
        super();
    }
    
    private final com.project.dietively.databinding.FragmentProgressBinding getBinding() {
        return null;
    }
    
    private final com.project.dietively.viewmodel.AppViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setTodayList(java.util.List<com.project.dietively.roomdb.DailyData> list) {
    }
    
    private final java.util.ArrayList<com.github.mikephil.charting.data.PieEntry> generatePieEntries(float calSum, float proSum, float carSum, float fatSum) {
        return null;
    }
    
    private final void processData(java.lang.String filteredDateStr) {
    }
    
    private final void setChart(java.util.ArrayList<com.github.mikephil.charting.data.PieEntry> generatePieEntries) {
    }
    
    private final void showDatePickerDialog(android.content.Context context) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/project/dietively/ui/ProgressFragment$Companion;", "", "()V", "TAG", "", "selectedDate", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}