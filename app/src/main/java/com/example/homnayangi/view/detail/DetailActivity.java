package com.example.homnayangi.view.detail;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.homnayangi.R;
import com.example.homnayangi.model.Meal;

public class DetailActivity extends AppCompatActivity {

    public static final String DETAIL_ITEM = "DETAIL_ITEM";
    private Meal meal;

    private ImageView ivBack;
    private TextView tvTitle;
    private ImageView ivThumbnail;
    private TextView tvDescribe;
    private TextView instructionTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        meal = (Meal) getIntent().getSerializableExtra(DETAIL_ITEM);

        ivBack = findViewById(R.id.iv_back);
        tvTitle = findViewById(R.id.tv_title);
        ivThumbnail = findViewById(R.id.iv_thumbnail);
        instructionTextView = findViewById(R.id.instruction_text);
        initViews();
        setEventListeners();


    }

    private void initViews() {
        tvTitle.setText(meal.getTitle());
        ivThumbnail.setImageResource(meal.getThumbnail());
        instructionTextView.setText(Html.fromHtml(meal.getDescription()));
        instructionTextView.setTextIsSelectable(true);
//        tvDescribe.setText(meal.getDescription());

    }

    private void setEventListeners() {
        ivBack.setOnClickListener(v -> finish());
    }
}