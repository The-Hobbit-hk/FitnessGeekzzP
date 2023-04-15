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
public class Aftn extends Fragment {

    private ExpandableListView mExpandableListView;
    private DietListAdapter mAdapter;
    private List<String> mGroupTitles;
    private Map<String, List<DietItem>> mChildItems;

    public Aftn() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afternoon, container, false);

        mGroupTitles = new ArrayList<>();
        mChildItems = new HashMap<>();

        // Add group titles
        mGroupTitles.add("Pre-Lunch Diet");
        mGroupTitles.add("Lunch Diet");

        // Add child items for pre-workout diet
        List<DietItem> prelunchItems = new ArrayList<>();
        prelunchItems.add(new DietItem(R.drawable.ic_action_info, "Any one from options", "1 bowl of salad\n" +
                "1 bowl minestrone soup\n" +
                "1 bowl sprouts salad\n" +
                "1 bowl mix vegetable soup\n" +
                "1 bowl grilled chicken or fish salad\n"));
        mChildItems.put(mGroupTitles.get(0), prelunchItems);

        List<DietItem> lunchItems = new ArrayList<>();
        lunchItems.add(new DietItem(R.drawable.ic_action_mail, "Any 1 from the options", "2 multigrain roti/ 1 bowl brown rice \n" +
                "1 bowl low fat yoghurt\n" +
                "1 bowl dal/ egg bhurji/ low fat chicken\n"));
        mChildItems.put(mGroupTitles.get(1), lunchItems);

        mExpandableListView = view.findViewById(R.id.diet_list1);
        mAdapter = new DietListAdapter(getContext(), mGroupTitles, mChildItems);
        mExpandableListView.setAdapter(mAdapter);

        return view;
    }
}
