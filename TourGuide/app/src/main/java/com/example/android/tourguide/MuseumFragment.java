package com.example.android.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Mohamed_Araby on 3/23/2018.
 */

public class MuseumFragment extends Fragment {

    ArrayList<ResourcesDetails> resourcesDetails;
    ListView listView;
    CustomAdapter customAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_museum_layout, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        resourcesDetails = setData();
        customAdapter = new CustomAdapter(getContext(), resourcesDetails);
        listView = view.findViewById(R.id.museum_list);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra("data", resourcesDetails.get(i));
                startActivity(intent);
            }
        });
    }

    private ArrayList<ResourcesDetails> setData() {
        ArrayList<ResourcesDetails> arrayList = new ArrayList<>();


        arrayList.add(new ResourcesDetails(getResources().getString(R.string.museum_name_egyptian).toString(),
                getResources().getString(R.string.egyptain_museum),
                R.drawable.egyptian_museum));
        arrayList.add(new ResourcesDetails(getResources().getString(R.string.museum_name_coptic).toString(),
                getResources().getString(R.string.coptic_museum),
                R.drawable.coptic_museum));
        arrayList.add(new ResourcesDetails(getResources().getString(R.string.museum_of_islamic_art).toString(),
                getResources().getString(R.string.museum_of_islamic_art),
                R.drawable.islamic_art_museum));
        arrayList.add(new ResourcesDetails(getResources().getString(R.string.museum_name_gayer).toString(),
                getResources().getString(R.string.gayer_anderson_museum),
                R.drawable.gayer_anderson_museum));

        return arrayList;
    }

}
