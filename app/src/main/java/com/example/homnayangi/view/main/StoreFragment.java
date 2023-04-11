package com.example.homnayangi.view.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.homnayangi.R;


public class StoreFragment extends Fragment {



    public StoreFragment() {
        // Required empty public constructor
    }


    public static Fragment newInstance() {
        StoreFragment fragment = new StoreFragment();
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_store, container, false);
    }
}