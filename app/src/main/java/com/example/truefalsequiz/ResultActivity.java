package com.example.truefalsequiz;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent  = getIntent();
        TextView tvResult = findViewById(R.id.tvResult);
        boolean isCorrect = intent.getBooleanExtra("isCorrect", false);
        String exp = intent.getStringExtra("explanation");
        boolean hasNext = intent.getBooleanExtra("hasNext", true);

        if (isCorrect) {
            tvResult.setText("צדקת!");
        } else {
            tvResult.setText("טעית...");
        }

        TextView tvExplanation = findViewById(R.id.tvExplanation);
        tvExplanation.setText(exp);

        LinearLayout main = findViewById(R.id.main);
        if (isCorrect) {
            main.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.result_correct)
            );
        } else{
            main.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.result_wrong)
            );
        }

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, Question2.class);
                intent.putExtra("hasNext", true);
                startActivity(intent);
            }
        });

        if(!hasNext){
            btnNext.setVisibility(View.GONE);
        }

    }
}