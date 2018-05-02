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

public class HotelFragment extends Fragment {

    ArrayList<ResourcesDetails> resourcesDetails;
    ListView listView;
    CustomAdapter customAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hotel_layout, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        resourcesDetails = setData();
        customAdapter = new CustomAdapter(getContext(), resourcesDetails);
        listView = view.findViewById(R.id.hotel_list);
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

        arrayList.add(new ResourcesDetails(getResources().getString(R.string.hotel_name_nile_plaza).toString(),
                getResources().getString(R.string.cairo_at_nile_plaza_txt),
                R.drawable.cairo_at_nile_plaza));
        arrayList.add(new ResourcesDetails(getResources().getString(R.string.hotel_name_marriot).toString(),
                getResources().getString(R.string.cairo_marriott_hotel_and_omar_khayyam_casino_txt),
                R.drawable.cairo_marriott_hotel_and_omar_khayyam_casino));
        arrayList.add(new ResourcesDetails(getResources().getString(R.string.hotel_name_kempinksi).toString(),
                getResources().getString(R.string.kempinski_nile__hotel_garden_city_cairo_txt),
                R.drawable.kempinski_nile__hotel_garden_city_cairo));
        arrayList.add(new ResourcesDetails(getResources().getString(R.string.hotel_name_sofitel_cairo_nile).toString(),
                getResources().getString(R.string.sofitel_cairo_nile_gezirah_txt),
                R.drawable.sofitel_cairo_nile_gezirah));

        return arrayList;
    }
}
