package com.project.dietively.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\u00020\u0001:\u0001)B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0013J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0015H\u0016J\u001a\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0017J\u0012\u0010&\u001a\u00020\u00152\b\b\u0002\u0010\'\u001a\u00020\u0013H\u0002J\b\u0010(\u001a\u00020\u0015H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\u00a8\u0006*"}, d2 = {"Lcom/project/dietively/ui/ProfileFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/project/dietively/databinding/FragmentProfileBinding;", "binding", "getBinding", "()Lcom/project/dietively/databinding/FragmentProfileBinding;", "userProfile", "Lcom/project/dietively/roomdb/UserProfile;", "viewModel", "Lcom/project/dietively/viewmodel/AppViewModel;", "getViewModel", "()Lcom/project/dietively/viewmodel/AppViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "calculateAge", "", "dateOfBirth", "", "fillData", "", "isValidEmail", "", "email", "isValidPhoneNumber", "phone", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "showDatePickerDialog", "dateString", "showLogoutConfirmationDialog", "Companion", "app_debug"})
public final class ProfileFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.project.dietively.databinding.FragmentProfileBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private com.project.dietively.roomdb.UserProfile userProfile;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "ProfileFragment";
    @org.jetbrains.annotations.NotNull()
    public static final com.project.dietively.ui.ProfileFragment.Companion Companion = null;
    
    public ProfileFragment() {
        super();
    }
    
    private final com.project.dietively.databinding.FragmentProfileBinding getBinding() {
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
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showDatePickerDialog(java.lang.String dateString) {
    }
    
    private final int calculateAge(java.lang.String dateOfBirth) {
        return 0;
    }
    
    private final void showLogoutConfirmationDialog() {
    }
    
    private final void fillData(com.project.dietively.roomdb.UserProfile userProfile) {
    }
    
    public final boolean isValidEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
        return false;
    }
    
    public final boolean isValidPhoneNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String phone) {
        return false;
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/project/dietively/ui/ProfileFragment$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}