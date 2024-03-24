package com.project.dietively.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0014\u0010\u0013\u001a\u00020\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/project/dietively/adapter/FoodAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/project/dietively/adapter/FoodAdapter$FoodViewHolder;", "foodList", "", "Lcom/project/dietively/roomdb/FoodItem;", "listener", "Lcom/project/dietively/adapter/FoodAdapter$OnClickListener;", "(Ljava/util/List;Lcom/project/dietively/adapter/FoodAdapter$OnClickListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "newDataList", "FoodViewHolder", "OnClickListener", "app_debug"})
public final class FoodAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.project.dietively.adapter.FoodAdapter.FoodViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.project.dietively.roomdb.FoodItem> foodList;
    @org.jetbrains.annotations.NotNull()
    private final com.project.dietively.adapter.FoodAdapter.OnClickListener listener = null;
    
    public FoodAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.project.dietively.roomdb.FoodItem> foodList, @org.jetbrains.annotations.NotNull()
    com.project.dietively.adapter.FoodAdapter.OnClickListener listener) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.project.dietively.adapter.FoodAdapter.FoodViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.project.dietively.adapter.FoodAdapter.FoodViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void updateData(@org.jetbrains.annotations.NotNull()
    java.util.List<com.project.dietively.roomdb.FoodItem> newDataList) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/project/dietively/adapter/FoodAdapter$FoodViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/project/dietively/databinding/FoodItemsBinding;", "(Lcom/project/dietively/databinding/FoodItemsBinding;)V", "getBinding", "()Lcom/project/dietively/databinding/FoodItemsBinding;", "app_debug"})
    public static final class FoodViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.project.dietively.databinding.FoodItemsBinding binding = null;
        
        public FoodViewHolder(@org.jetbrains.annotations.NotNull()
        com.project.dietively.databinding.FoodItemsBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.project.dietively.databinding.FoodItemsBinding getBinding() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/project/dietively/adapter/FoodAdapter$OnClickListener;", "", "onClick", "", "item", "Lcom/project/dietively/roomdb/FoodItem;", "app_debug"})
    public static abstract interface OnClickListener {
        
        public abstract void onClick(@org.jetbrains.annotations.NotNull()
        com.project.dietively.roomdb.FoodItem item);
    }
}