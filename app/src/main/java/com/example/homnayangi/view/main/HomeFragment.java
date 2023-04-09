package com.example.homnayangi.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.homnayangi.view.page.PageActivity;
import com.example.homnayangi.R;
import com.example.homnayangi.model.Meal;

import java.util.ArrayList;

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_thucdonmn = view.findViewById(R.id.btn_thucdonmn);
        btn_monandd = view.findViewById(R.id.btn_monandd);
        btn_monanmb = view.findViewById(R.id.btn_monanmb);
        btn_monanmt = view.findViewById(R.id.btn_monanmt);
        btn_monanmn = view.findViewById(R.id.btn_monanmn);

        btn_thucdonmn.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), PageActivity.class);
            intent.putExtra(PageActivity.PAGE_ITEM, new ArrayList<Meal>() {{
                add(new Meal(R.drawable.gakhogung, "Gà kho gừng", getString(R.string.gakhogung_text)));
                add(new Meal(R.drawable.lonkhosaot, "Lợn kho sả ớt", getString(R.string.lonkhosaot_text)));
                add(new Meal(R.drawable.cachiengiam, "Cá mối khô chiên đường", getString(R.string.cakho_text)));
                add(new Meal(R.drawable.tomxaothit, "Tôm xào thịt", getString(R.string.tomxaothit_text)));
            }});
            startActivity(intent);
        });


        btn_monandd.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), PageActivity.class);
            intent.putExtra(PageActivity.PAGE_ITEM, new ArrayList<Meal>() {{
                add(new Meal(R.drawable.suonhamcusen, "Sườn hầm củ sen", getString(R.string.suonham_text)));
                add(new Meal(R.drawable.canhraungot, "Canh rau ngót", getString(R.string.canhraungot_text)));
                add(new Meal(R.drawable.canhtom, "Canh dưa tôm cá", getString(R.string.canhtom_text)));
                add(new Meal(R.drawable.suonkho, "Sườn kho thơm (dứa)", getString(R.string.suonkho_text)));
            }});
            startActivity(intent);
        });

        btn_monanmb.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), PageActivity.class);
            intent.putExtra(PageActivity.PAGE_ITEM, new ArrayList<Meal>() {{
                add(new Meal(R.drawable.phohanoi, "Bún phở Hà Nội", getString(R.string.phohanoi_text)));
                add(new Meal(R.drawable.raubapcai, "Bắp cải luộc", getString(R.string.bapcai_text)));
                add(new Meal(R.drawable.suonxaochuangot, "Sườn xào chua ngọt", getString(R.string.suonxao_text)));
                add(new Meal(R.drawable.thitkhotrung, "Thịt kho trứng", getString(R.string.thitkho_text)));
            }});
            startActivity(intent);
        });

        btn_monanmt.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), PageActivity.class);
            intent.putExtra(PageActivity.PAGE_ITEM, new ArrayList<Meal>() {{
                add(new Meal(R.drawable.nemnuong, "Nem nướng Nha Trang", getString(R.string.nemnuong_text)));
                add(new Meal(R.drawable.bunchaca, "Bún chả cá", getString(R.string.bunchaca_text)));
                add(new Meal(R.drawable.bunsua, "Bún sứa", getString(R.string.bunsua_text)));
                add(new Meal(R.drawable.banhtrangcuonthitheo, "Bánh tráng cuốn thịt heo", getString(R.string.banhtrangcuonthiheo_text)));
            }});
            startActivity(intent);
        });

        btn_monanmn.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), PageActivity.class);
            intent.putExtra(PageActivity.PAGE_ITEM, new ArrayList<Meal>() {{
                add(new Meal(R.drawable.laucalinh, "Lẩu cá linh", getString(R.string.laucalinh_text)));
                add(new Meal(R.drawable.comtam, "Cơm tấm", getString(R.string.comtam_text)));
                add(new Meal(R.drawable.hutieu, "Hủ tiếu Sa Đéc", getString(R.string.hutieu_text)));
                add(new Meal(R.drawable.goicachich, "Gỏi cá chích", getString(R.string.goica_text)));
            }});
            startActivity(intent);
        });
    }
}