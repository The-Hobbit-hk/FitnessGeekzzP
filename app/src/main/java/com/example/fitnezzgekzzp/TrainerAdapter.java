package com.example.fitnezzgekzzp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TrainerAdapter extends ArrayAdapter<trainer1> {
    private Context context;
    private int layoutResId;
    private List<trainer1> trainers;

    public TrainerAdapter(Context context, int layoutResId, List<trainer1> trainers) {
        super(context, layoutResId, trainers);
        this.context = context;
        this.layoutResId = layoutResId;
        this.trainers = trainers;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        TrainerViewHolder viewHolder;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(layoutResId, parent, false);
            viewHolder = new TrainerViewHolder();
            viewHolder.nameTextView = view.findViewById(R.id.nameTextView);
            viewHolder.emailTextView = view.findViewById(R.id.emailTextView);
            viewHolder.imageView = view.findViewById(R.id.imageView);
            view.setTag(viewHolder);
        } else {
            viewHolder = (TrainerViewHolder) view.getTag();
        }

        trainer1 trainer = trainers.get(position);
        viewHolder.nameTextView.setText(trainer.getName());
        viewHolder.emailTextView.setText(trainer.getEmail());
        viewHolder.imageView.setImageResource(trainer.getImage());

        return view;
    }

    private static class TrainerViewHolder {
        TextView nameTextView;
        TextView emailTextView;
        ImageView imageView;
    }
}
