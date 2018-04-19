package com.example.foysal.onlineexamination;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class StudentProfile extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);
        TextView emailTV = findViewById(R.id.studentEmailID);
        TextView nameTV = findViewById(R.id.studentNameID);

        Intent intent = getIntent();
        String email =  intent.getStringExtra("email");
        String name = intent.getStringExtra("name");
        nameTV.setText(name);
        emailTV.setText("Email: "+email);
    }
}
