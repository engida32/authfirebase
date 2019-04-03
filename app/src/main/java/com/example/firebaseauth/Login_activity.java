package com.example.firebaseauth;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_activity extends AppCompatActivity  implements View.OnClickListener{

    private Button login;
    private EditText email;
    private EditText password;
    ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().setTitle("LOGIN ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);

        if (firebaseAuth.getCurrentUser()!=null){
            //already login in
            finish();
            startActivity(new Intent(getApplicationContext(),home.class));
        }
        login=findViewById(R.id.btnlogin);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        //create listener
        login.setOnClickListener(this);
    }
    private void userlogin(){
        String  uemail=email.getText().toString().trim();
        String upassword=password.getText().toString().trim();
        //////////////////////
        if (TextUtils.isEmpty(uemail)){
            Toast.makeText(this,"please enter email",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(upassword)){
            Toast.makeText(this,"please enter password",Toast.LENGTH_SHORT).show();

            return;
        }
        progressDialog.setMessage("login user");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(uemail,upassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
           // progressDialog.dismiss();
            if (task.isSuccessful()){
                finish();
                startActivity(new Intent(getApplicationContext(),upload.class));

            }
            else {

                startActivity(new Intent(getApplicationContext(),Login_activity.class));

                finish();
            }

            }
        });
    }


    @Override
    public void onClick(View v) {

        if (v==login) {
            userlogin();
        }
    }


    public void signup(View view) {
        finish();
        startActivity( new Intent(this,MainActivity.class));

    }
}
