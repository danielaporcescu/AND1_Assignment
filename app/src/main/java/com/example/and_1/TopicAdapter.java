package com.example.and_1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.ViewHolder> {

    private ArrayList<Topic> topics;

    public TopicAdapter(ArrayList<Topic> topics) {
        this.topics = topics;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topic, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Topic topic = topics.get(position);

        holder.name.setText(topic.getName());
        Picasso.get().load(topic.getImageURL()).into(holder.image);
        holder.description.setText(topic.getDescription());
    }

    @Override
    public int getItemCount() {
        if (topics != null) {
            return topics.size();
        } else {
            return 0;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        public final TextView name;
        public final ImageView image;
        public final TextView description;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            name = view.findViewById(R.id.name);
            image = view.findViewById(R.id.image);
            description=view.findViewById(R.id.description);
        }
    }
}
