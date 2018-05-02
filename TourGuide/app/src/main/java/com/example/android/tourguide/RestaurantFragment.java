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

public class RestaurantFragment extends Fragment {

    ArrayList<ResourcesDetails> resourcesDetails;
    ListView listView;
    CustomAdapter customAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_restaurant_lyout, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        resourcesDetails = setData();
        customAdapter = new CustomAdapter(getContext(), resourcesDetails);
        listView = view.findViewById(R.id.restaurant_list);
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


        arrayList.add(new ResourcesDetails(getResources().getString(R.string.restaurant_name_esplanada).toString(),
                getResources().getString(R.string.esplanade_cafe_restaurant),
                R.drawable.esplanade_cafe_restaurant));
        arrayList.add(new ResourcesDetails(getResources().getString(R.string.fayruz_lebanese_restaurant).toString(),
                getResources().getString(R.string.fayruz_lebanese_restaurant),
                R.drawable.fayruz_lebanese_restaurant));
        arrayList.add(new ResourcesDetails(getResources().getString(R.string.indira_indian_restaurant).toString(),
                getResources().getString(R.string.indira_indian_restaurant),
                R.drawable.indira_indian_restaurant));
        arrayList.add(new ResourcesDetails(getResources().getString(R.string.birdcage).toString(),
                getResources().getString(R.string.birdcage),
                R.drawable.birdcage_restaurant));

        return arrayList;
    }
}
