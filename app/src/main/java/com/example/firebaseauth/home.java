package com.example.firebaseauth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class home extends AppCompatActivity implements View.OnClickListener {

    private Button btnUpload;
    private Button btnLogout;
    private TextView textView;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        firebaseAuth=FirebaseAuth.getInstance() ;
        if (firebaseAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(this,Login_activity.class));
        }
        FirebaseUser user=firebaseAuth.getCurrentUser();
        String email=user.getEmail();
       btnUpload=findViewById(R.id.upload);
       btnLogout=findViewById(R.id.logout);
       textView=findViewById(R.id.textVie);

       textView.setText(" WELCOME...."+"\n"  +email);

       btnUpload.setOnClickListener(this);
       btnLogout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               firebaseAuth.signOut();
               Toast.makeText(home.this, "User loged out ", Toast.LENGTH_SHORT).show();
               startActivity(new Intent(getApplicationContext(),Login_activity.class));
           }
       });
    }

    @Override
    public void onClick(View v) {
//        firebaseAuth.signOut();
        finish();
        startActivity( new Intent(this,upload.class));

    }
}
