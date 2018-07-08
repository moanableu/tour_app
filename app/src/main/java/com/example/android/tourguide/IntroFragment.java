package com.example.android.tourguide;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class IntroFragment extends Fragment {
    TourAdapter adapter;
    IntroFragment listener;
    private ArrayList<Location> mLocation;

    private RecyclerView mRecyclerView;
    private LocationAdapter mAdapter; // limits displayed data  for improved performance
    private RecyclerView.LayoutManager mLayoutManager; //aligns items

    public IntroFragment(){
        // required emtpy constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list,container,false);

        final ArrayList<Tour> tours = new ArrayList <Tour>();
        tours.add(new Tour(R.drawable.seightseeing, (R.string.museums_kust), (R.string.kunst_intro)));
        tours.add(new Tour(R.drawable.seightseeing, (R.string.seightseeing), (R.string.seigtseeing_intro)));
        tours.add(new Tour(R.drawable.seightseeing, (R.string.food_drinks), (R.string.food_intro)));
        tours.add(new Tour(R.drawable.seightseeing, (R.string.berlinale),(R.string.berlinale_intro)));
        // add onItemClickListener

        // add adapter
        TourAdapter adapter = new TourAdapter(getActivity(),tours);
        ListView lv = rootView.findViewById(R.id.list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
                Tour tour = tours.get(position);
                //Log.i("selected item: ","position" + position);

                //VERIFY THAT If IS PART OF THE RUBRIC OR NOT!
                //Intent i = new Intent(getActivity(),)
            }
        });

        return rootView;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //super.onViewCreated(view, savedInstanceState);
    }
}
