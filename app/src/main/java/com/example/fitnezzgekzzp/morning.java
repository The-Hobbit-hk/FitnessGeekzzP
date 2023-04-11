package com.example.fitnezzgekzzp;



import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class morning extends Fragment {

    private ExpandableListView mExpandableListView;
    private DietListAdapter mAdapter;
    private List<String> mGroupTitles;
    private Map<String, List<DietItem>> mChildItems;

    public morning() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_morning, container, false);

        mGroupTitles = new ArrayList<>();
        mChildItems = new HashMap<>();

        // Add group titles
        mGroupTitles.add("Early Morning");
        mGroupTitles.add("Post-Workout Diet");

        // Add child items for pre-workout diet
        List<DietItem> earlymrngitems = new ArrayList<>();
        earlymrngitems.add(new DietItem(R.drawable.ic_action_info, "1fruit of choice", "Grapefruit\n, Apples\n, Passion Fruit\n, Melons\n, Avocadoes\n"));
        earlymrngitems.add(new DietItem(R.drawable.ic_action_mobile ,"3-4 mixed seeds", "Top with fresh berries and honey."));
        mChildItems.put(mGroupTitles.get(0), earlymrngitems);

        // Add child items for post-workout diet
        List<DietItem> postWorkoutItems = new ArrayList<>();
        postWorkoutItems.add(new DietItem(R.drawable.ic_action_mail, "Protein Shake", "Mix protein powder, almond milk, and banana in a blender."));
        postWorkoutItems.add(new DietItem(R.drawable.ic_home, "Grilled Chicken Salad", "Top mixed greens with grilled chicken, avocado, and balsamic vinaigrette."));
        mChildItems.put(mGroupTitles.get(1), postWorkoutItems);

        mExpandableListView = view.findViewById(R.id.diet_list);
        mAdapter = new DietListAdapter(getContext(), mGroupTitles, mChildItems);
        mExpandableListView.setAdapter(mAdapter);

        return view;
    }
}
