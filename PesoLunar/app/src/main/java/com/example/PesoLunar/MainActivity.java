package com.example.PesoLunar;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText pesoTextInputEditText;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pesoTextInputEditText = findViewById(R.id.pesoTextInputEditText);
        calculateButton = findViewById(R.id.calculateButton);
    }

    @Override
    protected void onResume() {
        super.onResume();

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new  Intent (MainActivity.this, DetailActivity.class);
                intent.putExtra("Peso", pesoTextInputEditText.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }
}
