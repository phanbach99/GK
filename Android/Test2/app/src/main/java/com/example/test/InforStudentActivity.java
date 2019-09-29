package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class InforStudentActivity extends AppCompatActivity {
    private TextView tvname,tvemail,tvadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor_student);
        tvadd = findViewById(R.id.textViewAddress);
        tvemail = findViewById(R.id.textViewEmail);
        tvname = findViewById(R.id.textViewName);
        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String address = getIntent().getStringExtra("address");
        tvname.setText("Name: " +name);
        tvemail.setText("Email: " +email);
        tvadd.setText("Address: " +address);
    }
}
