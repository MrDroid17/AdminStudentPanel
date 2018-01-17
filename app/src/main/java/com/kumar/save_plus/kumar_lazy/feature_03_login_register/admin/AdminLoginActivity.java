package com.kumar.save_plus.kumar_lazy.feature_03_login_register.admin;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kumar.save_plus.kumar_lazy.feature_03_login_register.R;

public class AdminLoginActivity extends AppCompatActivity {
    EditText adminUsername, adminPassword;
    Button adminLogin;
    final String userName="sobhit2017";
    final String passWord="kumar2017";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        getSupportActionBar().setTitle("Admin Login");

        adminUsername= (EditText) findViewById(R.id.etAdminUserName);
        adminPassword= (EditText) findViewById(R.id.etAdminPassWord);
        adminLogin= (Button) findViewById(R.id.bAdminLogin);


        adminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if((userName.equals(adminUsername.getText().toString())) && (passWord.equals(adminPassword.getText().toString()))){
                    Toast.makeText(getBaseContext()," login Successful...", Toast.LENGTH_SHORT).show();
                    Intent startAdminDashboard = new Intent(AdminLoginActivity.this, AdminDashboard.class);
                    startActivity(startAdminDashboard);

                }else{
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(AdminLoginActivity.this);
                    alertDialog.setTitle("!!!  Login Failed  !!!");

                    alertDialog.setMessage("Wrong Username or Password \n!!!  Try Again  !!!").show();

                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}

