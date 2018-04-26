package com.prdadmin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
    private EditText adminlogin;
    private EditText adminpassword;
    private Button adminbtn;
    private ProgressBar adminProgressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        adminProgressBar = findViewById(R.id.admin_progress_bar);
        adminlogin = findViewById(R.id.admin_login);
        adminpassword = findViewById(R.id.admin_password);
        adminbtn = findViewById(R.id.admin_btn);

        adminbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String adminLogin = adminlogin.getText().toString();
                String adminPassword = adminpassword.getText().toString();

                if (!TextUtils.isEmpty(adminLogin) && !TextUtils.isEmpty(adminPassword)) {

                    adminProgressBar.setVisibility(View.VISIBLE);

                    mAuth.signInWithEmailAndPassword(adminLogin, adminPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {

                                sendToMain();


                            } else {

                                String errorMessage = task.getException().getMessage();
                                Toast.makeText(LoginActivity.this, "Error : " + errorMessage, Toast.LENGTH_LONG).show();
                            }
                            adminProgressBar.setVisibility(View.INVISIBLE);
                        }
                    });

                }

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {

            sendToMain();
            
        }


    }

   private void sendToMain() {

      Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
      startActivity(loginIntent);
      finish();

   }
}
