package com.gmail.wjdrhkddud2.algorithmapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {

    private HorizontalScrollView horizontalScrollView;
    private LinearLayout linearHorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        horizontalScrollView = findViewById(R.id.horizontal_search);
        linearHorizontal = findViewById(R.id.linear_horizontal_search);

        TextView textView = new TextView(SearchActivity.this);
        textView.setText("AAA");
        textView.setTextColor(getColor(R.color.purple_700));
        textView.setTextSize(15f);
        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        for (int i = 0; i < 10; i++) {

        }


    }

    private void updateUI() {

    }



}