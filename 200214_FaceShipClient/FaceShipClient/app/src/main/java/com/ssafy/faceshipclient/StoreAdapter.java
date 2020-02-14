package com.ssafy.faceshipclient;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ssafy.faceshipclient.DTO.Store;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {

    ArrayList<Store> items = new ArrayList<Store>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.store_cardview, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int position) {
        final Store item = items.get(position);
        viewHolder.setItem(item);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                System.out.println(item.toString());
                Context context = v.getContext();

                Intent intent = new Intent(v.getContext(), StoreActivity.class);
                intent.putExtra("store", item);
                intent.putExtra("coupon", item.getCoupon());
//
                context.startActivity(intent);
//   				startActivityForResult(intent, REQUEST_CODE_STORE);
            }
        });
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Store item) {
        items.add(item);
    }

    public void setItems(ArrayList<Store> items) {
        this.items = items;
    }

    public Store getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, Store item) {
        items.set(position, item);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView2;
        ImageView imageView;



        public ViewHolder(final View itemView) {
            super(itemView);
//            itemView.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View v) {
//                    System.out.println();
//                }
//            });

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
        }

        public void setItem(Store item) {
            imageView.setImageResource(item.getImage());
            textView.setText(item.getsName());
            textView2.setText(item.getsDesc());
        }

    }
}
