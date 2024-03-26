package com.project.dietively.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\u001a\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010#\u001a\u00020 H\u0002J\u0012\u0010$\u001a\u00020 2\b\b\u0002\u0010%\u001a\u00020&H\u0002J\u0012\u0010\'\u001a\u00020 2\b\b\u0002\u0010(\u001a\u00020&H\u0003J\u0010\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020&H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/project/dietively/ui/MenFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/project/dietively/databinding/FragmentMenBinding;", "backToWeight", "", "basicWorkOut", "Ljava/util/ArrayList;", "Lcom/project/dietively/roomdb/WorkoutView;", "Lkotlin/collections/ArrayList;", "binding", "getBinding", "()Lcom/project/dietively/databinding/FragmentMenBinding;", "userData", "Lcom/project/dietively/roomdb/UserProfile;", "viewModel", "Lcom/project/dietively/viewmodel/AppViewModel;", "getViewModel", "()Lcom/project/dietively/viewmodel/AppViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "workOutTitle", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onViewCreated", "view", "setBasicWorkout", "setFoodView", "text", "", "setLayoutView", "screen", "setWeight", "s", "Companion", "app_debug"})
public final class MenFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.project.dietively.databinding.FragmentMenBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.project.dietively.roomdb.WorkoutView> workOutTitle = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.project.dietively.roomdb.WorkoutView> basicWorkOut = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private com.project.dietively.roomdb.UserProfile userData;
    private boolean backToWeight = false;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "MenFragment";
    @org.jetbrains.annotations.NotNull()
    public static final com.project.dietively.ui.MenFragment.Companion Companion = null;
    
    public MenFragment() {
        super();
    }
    
    private final com.project.dietively.databinding.FragmentMenBinding getBinding() {
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
    
    @android.annotation.SuppressLint(value = {"SetJavaScriptEnabled"})
    private final void setLayoutView(java.lang.String screen) {
    }
    
    private final void setWeight(java.lang.String s) {
    }
    
    private final void setFoodView(java.lang.String text) {
    }
    
    private final void setBasicWorkout() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/project/dietively/ui/MenFragment$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}