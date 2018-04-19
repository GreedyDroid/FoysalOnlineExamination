package com.example.foysal.onlineexamination;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    EditText emailET;
    EditText passET;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailET = findViewById(R.id.emailET);
        passET = findViewById(R.id.passET);
        firebaseAuth = FirebaseAuth.getInstance();
    }
    public void login(View view) {
        String email = emailET.getText().toString();
        String password = passET.getText().toString();
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseUser!=null){
                    Toast.makeText(Login.this, ""+firebaseUser.getEmail(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Login.this, "faild to Login", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

    public void moveToReg(View view) {
        Intent intent = new Intent(this,TeacherReg.class);
        startActivity(intent);

    }
}
