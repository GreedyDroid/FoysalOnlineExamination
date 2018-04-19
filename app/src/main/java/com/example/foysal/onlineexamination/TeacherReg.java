package com.example.foysal.onlineexamination;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class TeacherReg extends AppCompatActivity {
    EditText email,pass,cpass;
    Button registration;
    FirebaseAuth firebaseAuth;
    FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_reg);
        email = findViewById(R.id.emailTea);
        pass = findViewById(R.id.passTea);
        cpass = findViewById(R.id.cPassTea);
        registration = findViewById(R.id.registrationTea);
        firebaseAuth=FirebaseAuth.getInstance();
    }

    public void registrationTeacher(View view) {
        final String EmailEt = email.getText().toString();
        final String passET = pass.getText().toString();
        final String cpassEt = cpass.getText().toString();
        firebaseAuth.createUserWithEmailAndPassword(EmailEt,passET).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (EmailEt.equals("")||passET.equals("")){
                    Toast.makeText(getApplicationContext(),"fields are empty",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "registration Successfully",Toast.LENGTH_LONG).show();

                }
            }
        });

    }

    public void regToLoginTeacher(View view) {
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }
}
