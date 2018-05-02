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

public class PoliceStationFragment extends Fragment {

    ArrayList<ResourcesDetails> resourcesDetails;
    ListView listView;
    CustomAdapter customAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_police_station_layout, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        resourcesDetails = setData();
        customAdapter = new CustomAdapter(getContext(), resourcesDetails);
        listView = view.findViewById(R.id.police_list);
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


        arrayList.add(new ResourcesDetails(getResources().getString(R.string.police_name_amirya).toString(),
                getResources().getString(R.string.amireya_police_station),
                R.drawable.police_fragment));
        arrayList.add(new ResourcesDetails(getResources().getString(R.string.police_name_gezira).toString(),
                getResources().getString(R.string.gezirah_police_station),
                R.drawable.police_fragment));
        arrayList.add(new ResourcesDetails(getResources().getString(R.string.police_name_hadahek).toString(),
                getResources().getString(R.string.hadahek_shobra_police_station),
                R.drawable.police_fragment));
        arrayList.add(new ResourcesDetails(getResources().getString(R.string.police_name_shoubra).toString(),
                getResources().getString(R.string.shoubra_police_department),
                R.drawable.police_fragment));

        return arrayList;
    }
}
