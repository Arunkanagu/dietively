package com.project.dietively.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fJ\b\u0010\u001a\u001a\u00020\u001bH\u0002J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u001bH\u0016J\u001a\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010\'\u001a\u00020\u001bH\u0002J\u0012\u0010(\u001a\u00020\u001b2\b\b\u0002\u0010)\u001a\u00020\u0018H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0006j\b\u0012\u0004\u0012\u00020\u000e`\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006+"}, d2 = {"Lcom/project/dietively/ui/SignUpFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/project/dietively/databinding/FragmentSignUpBinding;", "arrayLayout", "Ljava/util/ArrayList;", "Landroid/widget/LinearLayout;", "binding", "getBinding", "()Lcom/project/dietively/databinding/FragmentSignUpBinding;", "selectedGender", "", "userDate", "Lcom/project/dietively/roomdb/UserProfile;", "userProfileList", "Lkotlin/collections/ArrayList;", "viewModel", "Lcom/project/dietively/viewmodel/AppViewModel;", "getViewModel", "()Lcom/project/dietively/viewmodel/AppViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "calculateAge", "", "dateOfBirth", "genderSelection", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "showDatePickerDialog", "viewControl", "point", "Companion", "app_debug"})
public final class SignUpFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.project.dietively.databinding.FragmentSignUpBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<android.widget.LinearLayout> arrayLayout = null;
    @org.jetbrains.annotations.NotNull()
    private com.project.dietively.roomdb.UserProfile userDate;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String selectedGender = "Male";
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.project.dietively.roomdb.UserProfile> userProfileList;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "LoginFragment";
    @org.jetbrains.annotations.NotNull()
    public static final com.project.dietively.ui.SignUpFragment.Companion Companion = null;
    
    public SignUpFragment() {
        super();
    }
    
    private final com.project.dietively.databinding.FragmentSignUpBinding getBinding() {
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
    
    private final void viewControl(int point) {
    }
    
    private final void showDatePickerDialog() {
    }
    
    public final int calculateAge(@org.jetbrains.annotations.NotNull()
    java.lang.String dateOfBirth) {
        return 0;
    }
    
    private final void genderSelection() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/project/dietively/ui/SignUpFragment$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}