package com.example.foysal.onlineexamination;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Student_reg extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    EditText email, pass, comfirmPass, studnetName;
    Button registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_reg);
        databaseHelper = new DatabaseHelper(this);
        email = findViewById(R.id.emailStu);
        pass = findViewById(R.id.passStu);
        comfirmPass = findViewById(R.id.cPassStu);
        registration = findViewById(R.id.registrationStu);
        studnetName = findViewById(R.id.nameStu);

    }

    public void registrationStudent(View view) {
        String emailEt = email.getText().toString();
        String nameET = studnetName.getText().toString();
        String passEt = pass.getText().toString();
        String cPassEt = comfirmPass.getText().toString();
        if (emailEt.equals("")||passEt.equals("")||cPassEt.equals("")){
            Toast.makeText(getApplicationContext(),"fields are empty",Toast.LENGTH_LONG).show();
        }else if (nameET.isEmpty()){
            studnetName.setError("Enter Your Name");
        } else {
            if (passEt.equals(cPassEt)){
                Boolean chkemail = databaseHelper.chkemail(emailEt);
                if (chkemail==true){
                    Boolean insert = databaseHelper.insert(emailEt,passEt, nameET);
                    if (insert==true){
                        Toast.makeText(getApplicationContext(), "registration Successfully",Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"Email Already exists",Toast.LENGTH_LONG).show();
                }
            }
            Toast.makeText(getApplicationContext(),"Password donot match",Toast.LENGTH_LONG).show();
        }
    }

    public void regToLoginStudent(View view) {
        Intent intent = new Intent(this,student_login.class);
        startActivity(intent);

    }
}
