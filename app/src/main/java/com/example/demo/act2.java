package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class act2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_act2);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(act2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        String value = intent.getStringExtra("key");
        int value2 = intent.getIntExtra("key2", 0);
        String name = intent.getStringExtra("Name");
        // use the retrieved values
        TextView textView = findViewById(R.id.textView2);
        textView.setText("Welcome " + name + ", Received value: " + value + ", another value: " + value2);


    }
}