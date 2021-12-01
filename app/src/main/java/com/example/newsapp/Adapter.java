package com.example.newsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<ModalClass> modalClassArrayList;

    public Adapter(Context context, ArrayList<ModalClass> modalClassArrayList) {
        this.context = context;
        this.modalClassArrayList = modalClassArrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(context).inflate(R.layout.layout_item, null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, webView.class);
                i.putExtra("url", modalClassArrayList.get(position).getUrl());
                i.putExtra("title", modalClassArrayList.get(position).getTitle());
                context.startActivity(i);
            }
        });

        holder.mtime.setText("Published At:" + modalClassArrayList.get(position).getPublishedAt());
        holder.mauthor.setText(modalClassArrayList.get(position).getAuthor());
        holder.mcontent.setText(modalClassArrayList.get(position).getDescription());
        holder.mheading.setText(modalClassArrayList.get(position).getTitle());
        Glide.with(context).load(modalClassArrayList.get(position).getUrlToImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return modalClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mheading, mauthor, mcontent, mtime;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mheading = itemView.findViewById(R.id.mainHeading);
            mauthor = itemView.findViewById(R.id.author);
            mtime = itemView.findViewById(R.id.time);
            mcontent = itemView.findViewById(R.id.content);
            cardView = itemView.findViewById(R.id.cardView);
            imageView = itemView.findViewById(R.id.imageView);


        }
    }
}
