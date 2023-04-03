package com.example.homnayangi;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.homnayangi.model.Meal;
import com.example.homnayangi.model.Menu;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    Button btn_thucdonmn;
    Button btn_monandd;
    Button btn_monanmb;
    Button btn_monanmt;
    Button btn_monanmn;

    List<Menu> menus;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_thucdonmn = view.findViewById(R.id.btn_thucdonmn);
        btn_monandd = view.findViewById(R.id.btn_monandd);
        btn_monanmb = view.findViewById(R.id.btn_monanmb);
        btn_monanmt = view.findViewById(R.id.btn_monanmt);
        btn_monanmn = view.findViewById(R.id.btn_monanmn);

        menus = new ArrayList<>();
        menus.add(new Menu("Thuc don hom nay", new ArrayList<Meal>() {{
            add(new Meal("1", "", ""));
            add(new Meal("2", "", ""));
            add(new Meal("3", "", ""));
        }}));
        menus.add(new Menu("Mon an dinh duong", new ArrayList<Meal>() {{
            add(new Meal("", "", ""));
        }}));

        btn_thucdonmn.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), PageActivity.class);
            intent.putExtra(PageActivity.DATA_NAME, menus.get(0));
            startActivity(intent);
        });

        btn_monandd.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), PageActivity.class);
            intent.putExtra(PageActivity.DATA_NAME, menus.get(1));
            startActivity(intent);
        });

        btn_monanmb.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), PageActivity.class);
            intent.putExtra(PageActivity.DATA_NAME, menus.get(0));
            startActivity(intent);
        });

        btn_monanmt.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), PageActivity.class);
            intent.putExtra(PageActivity.DATA_NAME, menus.get(0));
            startActivity(intent);
        });

        btn_monanmn.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), PageActivity.class);
            intent.putExtra(PageActivity.DATA_NAME, menus.get(0));
            startActivity(intent);
        });
    }
}