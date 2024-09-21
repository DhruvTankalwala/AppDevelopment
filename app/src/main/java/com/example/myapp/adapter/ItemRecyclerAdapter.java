package com.example.myapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapp.R;
import com.example.myapp.model.CategoryItem;

import java.util.List;

public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemRecyclerAdapter.ItemViewHolder> {
    Context context;
    List<CategoryItem> categoryItemList;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemViewHolder itemViewHolder = new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.cat_recycler_row_items));
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        //here we will fetch image from server so we use glide library
        Glide.with(context).load(categoryItemList.get(position).getImageUrl()).into(holder.itemImage);
    }

    @Override
    public int getItemCount() {
        return categoryItemList.size();
    }

    public  static final class ItemViewHolder extends  RecyclerView.ViewHolder{

        ImageView itemImage;
        public ItemViewHolder(View itemview){
            super(itemview);

            itemImage = itemview.findViewById(R.id.imageView);

        }
    }
}
