package com.mpa.android.nefertari.activity.detail.placeFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import com.mpa.android.nefertari.TipApplication;
import com.mpa.android.nefertari.model.Facility;
import com.mpa.android.nefertari.model.Place;
import com.mpa.android.nefertari.utils.FontUtils;
import com.mpa.android.nefertari.R;

/**
 * Created by phamngocthanh on 7/26/17.
 */

public class FacilitiesFragment extends Fragment {
    Place place;

    public FacilitiesFragment() {
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    GridView gridView;
    FacilityAdapter facilityAdapter;
    List<Facility> facilities = new LinkedList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_place_facility, container, false);
        gridView = (GridView) view.findViewById(R.id.gridView);

        initData();
        return view;
    }


    private void initData() {
        if (place != null && place.getFacilities() != null && place.getFacilities().size() > 0) {
            facilityAdapter = new FacilityAdapter(getContext());
            facilityAdapter.setFacilities(facilities);

            for (int i = 0; i < place.getFacilities().size(); i++) {
                if(TipApplication.getTipApplication().facilityService.getFacilityByKey(place.getFacilities().get(i)) != null) {
                    facilities.add(TipApplication.getTipApplication().facilityService.getFacilityByKey(place.getFacilities().get(i)));
                }
            }

            if(facilities.size() > 0) {
                facilityAdapter.notifyDataSetChanged();
            }
            gridView.setAdapter(facilityAdapter);
        }

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}