package com.example.android.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mohamed_Araby on 3/23/2018.
 */
public class CustomAdapter extends ArrayAdapter<ResourcesDetails> {
    public CustomAdapter(Context context, ArrayList<ResourcesDetails> resourcesDetails) {
        super(context, 0, resourcesDetails);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            ResourcesDetails currentResourceDetails = getItem(position);
            ImageView imageView = listItemView.findViewById(R.id.imageview_list_item_resource_file);
            imageView.setImageResource(currentResourceDetails.getImage());
            TextView textView = listItemView.findViewById(R.id.textview_list_item_resource_file);
            textView.setText(currentResourceDetails.getName());
        }
        return listItemView;
    }
}
