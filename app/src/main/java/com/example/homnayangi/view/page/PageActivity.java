package com.example.homnayangi.view.page;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homnayangi.R;
import com.example.homnayangi.model.Meal;
import com.example.homnayangi.model.Menu;
import com.example.homnayangi.view.detail.DetailActivity;

import java.util.List;

public class PageActivity extends AppCompatActivity {

    public static final String PAGE_ITEM = "PAGE_ITEM";
    public static final int GRID = 1;
    public static final int LINEAR = 2;
    ImageView ivBack;
    TextView tvTitle;
    ImageView ivSwitch;
    RecyclerView rvMenu;
    TextView tvSwitch;
    private Menu menu;
    private List<Meal> mealList;
    private PageAdapter pageAdapter;

    private int listState = GRID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        mealList = (List<Meal>) getIntent().getSerializableExtra(PAGE_ITEM);

        ivBack = findViewById(R.id.iv_back);
        ivSwitch = findViewById(R.id.iv_switch);
        rvMenu = findViewById(R.id.rv_menu);
        tvSwitch = findViewById(R.id.tv_switch);

        initViews();
        setEventListeners();
    }

    private void initViews() {
        pageAdapter = new PageAdapter(mealList, meal -> {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.DETAIL_ITEM, meal);
            startActivity(intent);
        });
        setRecyclerViewLayout();
        rvMenu.setAdapter(pageAdapter);
    }

    private void setEventListeners() {
        ivBack.setOnClickListener(v -> finish());
        ivSwitch.setOnClickListener(v -> {
            if (listState == GRID) listState = LINEAR;
            else listState = GRID;
            setRecyclerViewLayout();
        });
    }

    private void setRecyclerViewLayout() {
        if (listState == GRID) {
            rvMenu.setLayoutManager(new GridLayoutManager(this, 2));
            tvSwitch.setText(R.string.grid_txt);
        } else {
            rvMenu.setLayoutManager(new LinearLayoutManager(this));
            tvSwitch.setText(R.string.linear_txt);
        }
    }
}