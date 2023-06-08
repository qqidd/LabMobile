package com.example.bgthreadassigment.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bgthreadassigment.Models.PostModel;
import com.example.bgthreadassigment.ProfileActivity;
import com.example.bgthreadassigment.R;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private final ArrayList<PostModel> posts;
    private final Context context;

    public PostAdapter(ArrayList<PostModel> posts, Context context) {
        this.posts = posts;
        this.context = context;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        PostModel post = posts.get(position);
        holder.contentImageIv.setImageBitmap(post.getImage());
        holder.contentDescTv.setText(post.getDescription());
        holder.usernameTv.setText(post.getUser().getUsername());
        holder.aliasNameTV.setText(post.getUser().getFullname());
        holder.homeProfileIv.setImageDrawable(context.getDrawable(post.getUser().getProfileImage()));
        holder.headerLl.setOnClickListener(v -> {
            Intent i = new Intent(v.getContext(), ProfileActivity.class);
            i.putExtra("User", post.getUser());
            v.getContext().startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView homeProfileIv, contentImageIv;
        TextView usernameTv, aliasNameTV, contentDescTv;
        LinearLayout headerLl;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            homeProfileIv = itemView.findViewById(R.id.homeProfileIv);
            contentImageIv = itemView.findViewById(R.id.contentImageIv);
            usernameTv = itemView.findViewById(R.id.usernameTv);
            aliasNameTV = itemView.findViewById(R.id.aliasnameTv);
            headerLl = itemView.findViewById(R.id.headerLl);
            contentDescTv = itemView.findViewById(R.id.contentDescTv);
        }
    }
}