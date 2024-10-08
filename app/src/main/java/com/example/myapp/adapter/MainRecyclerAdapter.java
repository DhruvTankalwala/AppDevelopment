package com.example.myapp.adapter;

import static com.example.myapp.R.*;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;
import com.example.myapp.model.AllCategory;
import com.example.myapp.model.CategoryItem;

import java.util.List;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder> {

    Context context;
    List<AllCategory>allCategoryList;

    public MainRecyclerAdapter(Context context, List<AllCategory> allCategoryList) {
        this.context = context;
        this.allCategoryList = allCategoryList;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(context).inflate(layout.main_recycler_row_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {

        holder.categoryName.setText(allCategoryList.get(position).getCategoryTitle());
        setItemRecycler(holder.itemRecycler,allCategoryList.get(position).getCategoryItemList());
    }

    @Override
    public int getItemCount() {
        return allCategoryList.size();
    }

    public static final class MainViewHolder extends RecyclerView.ViewHolder{

        TextView categoryName;
        RecyclerView itemRecycler;



        public MainViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryName = itemView.findViewById(id.item_category);
            itemRecycler = itemView.findViewById(id.item_recycler);

        }
    }
    private void setItemRecycler(RecyclerView recyclerView, List<CategoryItem> categoryItemList){
        ItemRecyclerAdapter itemRecyclerAdapter = new ItemRecyclerAdapter(context , categoryItemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(itemRecyclerAdapter);
    }

}
