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
public class Morn extends Fragment {
    private ExpandableListView mExpandableListView;
    private DietListAdapter mAdapter;
    private List<String> mGroupTitles;
    private Map<String, List<DietItem>> mChildItems;

    public Morn() {
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
        mGroupTitles.add("Breakfast");
        mGroupTitles.add("Mid-Morning");

        // Add child items for pre-workout diet
        List<DietItem> earlymrngitems = new ArrayList<>();
        earlymrngitems.add(new DietItem(R.drawable.ic_action_info, "1 fruit of choice", "Grapefruit\n Apples\n Passion Fruit\n Melons\n Avocadoes\n"));
        earlymrngitems.add(new DietItem(R.drawable.ic_action_mobile ,"3-4 mixed seeds", "Chia seeds\n  flax seeds\n sunflower seeds\n pumpkin seeds\n Seasame seeds\n Watermelon seeds\n"));
        mChildItems.put(mGroupTitles.get(0), earlymrngitems);

        // Add child items for post-workout diet
        List<DietItem> breakfastItems = new ArrayList<>();
        breakfastItems.add(new DietItem(R.drawable.ic_action_mail, "Any one food \n", "2 idlis with sambhar \n" +
                "2 eggs omelette with 2 whole grain bread slices\n" +
                "2 multigrain mix veg parathas\n" +
                "2 vegetable uttapam\n" +
                "1 bowl vegetable dalia or upma\n" +
                "1 bowl fruit, flaxseed and oats porridge\n" +
                " 2 methi parathas + curd \n"));
        breakfastItems.add(new DietItem(R.drawable.ic_home, "Any one juice", "Beet juice\n" +
                "Carrot juice\n" +
                "Green veggie juice\n" +
                "Watermelon juice\n"));
        mChildItems.put(mGroupTitles.get(1), breakfastItems);

        List<DietItem> midmrngitems = new ArrayList<>();
        midmrngitems.add(new DietItem(R.drawable.ic_action_info, "Any one from given options", "4 walnuts + 2 dates/ fruit of your choice/ coconut water \n" +
                "1 glass whey protein shake/ assorted fruits/ coconut water\n" +
                "1 fruit of your choice/ Fistful of assorted nuts\n" +
                "3-4 dry fruits/ 1 bowl fresh fruit salad\n"));
        mChildItems.put(mGroupTitles.get(2), midmrngitems);

        mExpandableListView = view.findViewById(R.id.diet_list);
        mAdapter = new DietListAdapter(getContext(), mGroupTitles, mChildItems);
        mExpandableListView.setAdapter(mAdapter);

        return view;
    }
}
