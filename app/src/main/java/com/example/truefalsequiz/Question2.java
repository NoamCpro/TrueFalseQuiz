package com.example.truefalsequiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Question2 extends AppCompatActivity {
    boolean correctAnswer = true;
    String exp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnTrue = findViewById(R.id.btnTrue);
        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean userAnswer = true;

                boolean isCorrect;
                if (userAnswer == correctAnswer) {
                    isCorrect = true;
                    exp = "אתה צודק. הוא דובון גדול";
                } else {
                    isCorrect = false;
                    exp = "מבין למה טעית אבל הוא שמן";
                }

                Intent intent = new Intent(Question2.this, ResultActivity.class);
                intent.putExtra("isCorrect", isCorrect);
                intent.putExtra("explanation", exp);
                startActivity(intent);
            }
        });

        Button btnFalse = findViewById(R.id.btnFalse);
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean userAnswer = false;


                boolean isCorrect;
                if (userAnswer == correctAnswer) {
                    isCorrect = true;
                    exp = "אתה צודק. הוא דובון גדול";
                } else {
                    isCorrect = false;
                    exp = "מבין למה טעית אבל הוא שמן";
                }

                Intent intent = new Intent(Question2.this, ResultActivity.class);
                intent.putExtra("isCorrect", isCorrect);
                intent.putExtra("explanation", exp);
                startActivity(intent);
            }
        });
    }


}