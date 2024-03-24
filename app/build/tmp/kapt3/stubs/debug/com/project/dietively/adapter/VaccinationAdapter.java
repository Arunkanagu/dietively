package com.project.dietively.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0015\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/project/dietively/adapter/VaccinationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/project/dietively/adapter/VaccinationAdapter$VaccinationViewHolder;", "vaccinationList", "", "Lcom/project/dietively/util/VaccinationSchedule;", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "VaccinationViewHolder", "app_debug"})
public final class VaccinationAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.project.dietively.adapter.VaccinationAdapter.VaccinationViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.project.dietively.util.VaccinationSchedule> vaccinationList;
    
    public VaccinationAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.project.dietively.util.VaccinationSchedule> vaccinationList) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.project.dietively.adapter.VaccinationAdapter.VaccinationViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.project.dietively.adapter.VaccinationAdapter.VaccinationViewHolder holder, int position) {
    }
    
    public VaccinationAdapter() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/project/dietively/adapter/VaccinationAdapter$VaccinationViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/project/dietively/databinding/LayoutVaccinationBinding;", "(Lcom/project/dietively/databinding/LayoutVaccinationBinding;)V", "getBinding", "()Lcom/project/dietively/databinding/LayoutVaccinationBinding;", "app_debug"})
    public static final class VaccinationViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.project.dietively.databinding.LayoutVaccinationBinding binding = null;
        
        public VaccinationViewHolder(@org.jetbrains.annotations.NotNull()
        com.project.dietively.databinding.LayoutVaccinationBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.project.dietively.databinding.LayoutVaccinationBinding getBinding() {
            return null;
        }
    }
}