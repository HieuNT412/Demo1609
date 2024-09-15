package com.example.demo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    private ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btnChange);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, act2.class);
                startActivity(intent);
            }
        });

        //pass initialized data
        Button btn2 = findViewById(R.id.passData);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final String Ex1 = "value";
                final int num1 = 123;
                Intent intent = new Intent(MainActivity.this, act2.class);
                //Pass String data
                intent.putExtra("key",Ex1);
                //Pass Int data
                intent.putExtra("key2",num1);
                startActivity(intent);
            }
        });

        Button btn3 = findViewById(R.id.btnSubmit);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, act2.class);
                EditText e1 = findViewById(R.id.Name);
                String e1Value = e1.getText().toString();
                intent.putExtra("Name", e1Value);
                startActivity(intent);
            }
        });

        Button btn4 = findViewById(R.id.btnFAP);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://fap.fpt.edu.vn/");
                Intent it = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(it);
            }
        });

        Button button5 = findViewById(R.id.btnResultBack);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, act3.class);
                intent.putExtra("key", "value"); // pass data to SecondActivity
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == 1) {
            String message = data.getStringExtra("MESSAGE"); // receive result from Activity 2
            TextView tvResult = findViewById(R.id.tv_result);
            tvResult.setText("Received message: " + message); // display the message
        }
    }



}