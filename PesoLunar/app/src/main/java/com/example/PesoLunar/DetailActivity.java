package com.example.PesoLunar;

import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private TextView PesoTextView;
    private double Earth = 0;
    private double Moon = 0;
    private String strTotal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        PesoTextView = (TextView) findViewById(R.id.calculateWeightTextView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Earth = Double.valueOf(getIntent().getStringExtra("Peso")).doubleValue();
        Moon = (Earth/9.8)*1.622;
        PesoTextView.setText(getString(R.string.moon_text, String.valueOf(Moon)));
    }

}
