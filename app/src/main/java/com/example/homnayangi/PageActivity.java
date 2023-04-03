package com.example.homnayangi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.homnayangi.model.Menu;

public class PageActivity extends AppCompatActivity {

    static final String DATA_NAME  = "DATA_NAME";
    ImageView ivBack;
    TextView tvTitle;
    ImageView ivSwitch;
    RecyclerView rvMenu;

    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
//        getIntent().getSerializableExtra(DATA_NAME);

        ivBack = findViewById(R.id.iv_back);
        ivSwitch = findViewById(R.id.iv_switch);
        rvMenu = findViewById(R.id.rv_menu);

        initViews();
        setEventListeners();
    }

    private void initViews() {

    }

    private void setEventListeners() {
        ivBack.setOnClickListener(v -> finish());
    }
}