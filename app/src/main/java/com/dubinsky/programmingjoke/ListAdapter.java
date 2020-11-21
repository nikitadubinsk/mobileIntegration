package com.dubinsky.programmingjoke;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    Context context;
    List<Joke> list;

    public ListAdapter(Context context, List<Joke> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_joke, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        Joke joke = list.get(position);
        holder.jokeID.setText("Шутка №"+joke.id);
        holder.jokeSetup.setText(joke.setup);
        holder.detailJokeLayout.setOnClickListener(v -> {
            Intent intent = new Intent(context, JokeDetailActivity.class);
            intent.putExtra("id", joke.id);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView jokeID;
        TextView jokeSetup;
        LinearLayout detailJokeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            jokeID = itemView.findViewById(R.id.jokeID);
            jokeSetup = itemView.findViewById(R.id.jokeSetup);
            detailJokeLayout = itemView.findViewById(R.id.detailJoke);
        }
    }
}
