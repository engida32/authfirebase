package com.example.firebaseauth;

import android.app.ProgressDialog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private Button  buttonreg;
    private EditText regEmial;
    private  EditText regpass;
    private TextView signedup;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        buttonreg=findViewById(R.id.Rbtn_signup);
        regEmial=findViewById(R.id.Rinput_email);
        regpass=findViewById(R.id.Rinput_password);
        signedup=findViewById(R.id.Rlogin_page);
        buttonreg.setOnClickListener(this);
        signedup.setOnClickListener(this);
    }


    // registering  user
    public void registerUser(){
        String email=regEmial.getText().toString().trim();
        String password=regpass.getText().toString().trim();
        /////////if-empty
        if (TextUtils.isEmpty(email)){
            Toast.makeText(this,"please enter email",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this,"please enter password",Toast.LENGTH_SHORT).show();

            return;
        }
        progressDialog.setMessage("Registering User ......");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(  Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(MainActivity.this,"User Registerd successfully",Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                    startActivity(new Intent(getApplicationContext(),upload.class));
                }
                else
                    Toast.makeText(MainActivity.this,"User not Registerd successfully",Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });

    }


    @Override
    public void onClick(View v) {
         if (v==buttonreg){
             registerUser();
         }
         if(v==signedup){
             //open login activity
             startActivity(new Intent(this,Login_activity.class));
         }

    }
}
