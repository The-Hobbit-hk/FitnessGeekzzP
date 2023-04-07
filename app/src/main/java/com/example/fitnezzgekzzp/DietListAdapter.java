package com.example.fitnezzgekzzp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class DietListAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private List<String> mGroupTitles;
    private Map<String, List<DietItem>> mChildItems;

    public DietListAdapter(Context context, List<String> groupTitles, Map<String, List<DietItem>> childItems) {
        mContext = context;
        mGroupTitles = groupTitles;
        mChildItems = childItems;
    }

    public DietListAdapter(Context context, List<DietItem> afternoonDietData) {

    }


    @Override
    public int getGroupCount() {
        return mGroupTitles.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        String groupTitle = mGroupTitles.get(groupPosition);
        List<DietItem> childItems = mChildItems.get(groupTitle);
        return childItems.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mGroupTitles.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        String groupTitle = mGroupTitles.get(groupPosition);
        List<DietItem> childItems = mChildItems.get(groupTitle);
        return childItems.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }



    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.diet_groups, null);
        }

        TextView groupTitleTextView = convertView.findViewById(R.id.list_header);
        String groupTitle = mGroupTitles.get(groupPosition);
        groupTitleTextView.setText(groupTitle);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        // Check if convertView is null
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_diet, parent, false);
        }

        // Get the child DietItem object
        DietItem dietItem = (DietItem) getChild(groupPosition, childPosition);

        // Get references to the child views
        TextView titleTextView = convertView.findViewById(R.id.diet_item_title);
        TextView descriptionTextView = convertView.findViewById(R.id.diet_item_description);
        ImageView iconImageView = convertView.findViewById(R.id.diet_item_icon);

        // Set the child views with the DietItem object data
        titleTextView.setText(dietItem.getTitle());
        descriptionTextView.setText(dietItem.getDescription());
        iconImageView.setImageResource(dietItem.getIconResId());

        return convertView;
    }


    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
