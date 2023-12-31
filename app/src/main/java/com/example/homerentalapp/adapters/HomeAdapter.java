package com.example.homerentalapp.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.homerentalapp.R;
import com.example.homerentalapp.listeners.ItemListener;
import com.example.homerentalapp.model.Item;
import com.google.firebase.database.ChildEventListener;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private Context context;
    private List<Item> itemList;

    private ItemListener itemListener;

    public HomeAdapter(Context context, List<Item> itemList , ChildEventListener itemListener) {
        this.context = context;
        this.itemList = itemList;
        this.itemListener = (ItemListener) itemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.top_deals,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.price.setText(itemList.get(position).getPrice());
        holder.location.setText(itemList.get(position).getLocation());
        holder.shortDescription.setText(itemList.get(position).getShortDescription());
        Glide.with(context)
                .load(itemList.get(position).getImage())
                .centerCrop()
                .placeholder(R.drawable.ic_account)
                .into(new CustomTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        holder.relativeLayout.setBackground(resource);
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView price;
        private TextView location;
        private TextView shortDescription;
        private RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            price = itemView.findViewById(R.id.price);
            location = itemView.findViewById(R.id.location);
            shortDescription = itemView.findViewById(R.id.short_description);
            relativeLayout = itemView.findViewById(R.id.relative_layout);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemListener.OnItemPosition(getAdapterPosition());
                }
            });
        }
    }
}
