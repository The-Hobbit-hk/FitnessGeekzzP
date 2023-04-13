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
public class night extends Fragment {

    private ExpandableListView mExpandableListView;
    private DietListAdapter mAdapter;
    private List<String> mGroupTitles;
    private Map<String, List<DietItem>> mChildItems;

    public night() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_night, container, false);

        mGroupTitles = new ArrayList<>();
        mChildItems = new HashMap<>();

        // Add group titles
        mGroupTitles.add("Before Dinner/Snacks");
        mGroupTitles.add("Dinner Diet");

        // Add child items for pre-workout diet
        List<DietItem> snacks = new ArrayList<>();
        snacks.add(new DietItem(R.drawable.ic_action_info, "Any one snack", "1 fruit of your choice\n" +
                "1 cup green tea/ 2 multigrain khakhras\n" +
                "1 bowl sprout\n" +
                "1 cup boiled corn or dal\n"));
        mChildItems.put(mGroupTitles.get(0), snacks);

        // Add child items for post-workout diet
        List<DietItem> DinnerItems = new ArrayList<>();
        DinnerItems.add(new DietItem(R.drawable.ic_action_mail, "Have a proper meal", "1 bowl veg/chicken gravy + 1 bowl rice\n" +
                "1 bowl vegetable dalia or upma with 1 bowl sambhar + 1 bowl salad\n" +
                  "2 multigrain rotis + salad + 1 bowl low fat curd\n"));
        mChildItems.put(mGroupTitles.get(1), DinnerItems);

        mExpandableListView = view.findViewById(R.id.diet_list2);
        mAdapter = new DietListAdapter(getContext(), mGroupTitles, mChildItems);
        mExpandableListView.setAdapter(mAdapter);

        return view;
    }
}
