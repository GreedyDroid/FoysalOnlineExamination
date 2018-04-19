package com.example.foysal.onlineexamination;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class student_login extends AppCompatActivity {
    EditText email, pass;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        databaseHelper = new DatabaseHelper(this);
        email = findViewById(R.id.emailstuLogin);
        pass = findViewById(R.id.passstuLogin);

    }


    public void moveToReg(View view) {
        Intent intent = new Intent(this, Student_reg.class);
        startActivity(intent);

    }

    public void login_student(View view) {
        String emailLogin = email.getText().toString();
        String passLogin = pass.getText().toString();
        Boolean chkemailpass = databaseHelper.emailPassword(emailLogin,passLogin);
        if (chkemailpass==true){

            startActivity(new Intent(this, StudentProfile.class)
                            .putExtra("email", emailLogin)
                            .putExtra("name", databaseHelper.getStudentName(emailLogin, passLogin)));
        } else {
            Toast.makeText(getApplicationContext(),"wrong Email or Password",Toast.LENGTH_LONG).show();
        }
    }
}
