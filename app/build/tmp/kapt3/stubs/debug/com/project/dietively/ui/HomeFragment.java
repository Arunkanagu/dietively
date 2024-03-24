package com.project.dietively.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 12\u00020\u0001:\u00011B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010\'\u001a\u00020\u001eH\u0016J\u001a\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0016\u0010*\u001a\u00020\u001e2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0016\u0010,\u001a\u00020\u001e2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0016\u0010.\u001a\u00020\u001e2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0010\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u000fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013\u00a8\u00062"}, d2 = {"Lcom/project/dietively/ui/HomeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/project/dietively/databinding/FragmentHomeBinding;", "adapter", "Lcom/project/dietively/adapter/FoodAdapter;", "alertDialog", "Landroidx/appcompat/app/AlertDialog;", "binding", "getBinding", "()Lcom/project/dietively/databinding/FragmentHomeBinding;", "foodList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/project/dietively/roomdb/FoodItem;", "viewModel", "Lcom/project/dietively/viewmodel/AppViewModel;", "getViewModel", "()Lcom/project/dietively/viewmodel/AppViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "calculateAverage", "", "range", "", "kilocaloriesToGrams", "kilocalories", "", "observe", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setFilter", "foodItems", "setFoodList", "list", "setRecycleView", "showDialog", "foodItem", "Companion", "app_debug"})
public final class HomeFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.project.dietively.databinding.FragmentHomeBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.project.dietively.roomdb.FoodItem>> foodList = null;
    private androidx.appcompat.app.AlertDialog alertDialog;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private com.project.dietively.adapter.FoodAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "HomeFragment";
    @org.jetbrains.annotations.NotNull()
    public static final com.project.dietively.ui.HomeFragment.Companion Companion = null;
    
    public HomeFragment() {
        super();
    }
    
    private final com.project.dietively.databinding.FragmentHomeBinding getBinding() {
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
    
    private final void observe() {
    }
    
    private final void setFoodList(java.util.List<com.project.dietively.roomdb.FoodItem> list) {
    }
    
    private final void setRecycleView(java.util.List<com.project.dietively.roomdb.FoodItem> foodItems) {
    }
    
    private final void setFilter(java.util.List<com.project.dietively.roomdb.FoodItem> foodItems) {
    }
    
    private final void showDialog(com.project.dietively.roomdb.FoodItem foodItem) {
    }
    
    private final double calculateAverage(java.lang.String range) {
        return 0.0;
    }
    
    public final double kilocaloriesToGrams(float kilocalories) {
        return 0.0;
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/project/dietively/ui/HomeFragment$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}