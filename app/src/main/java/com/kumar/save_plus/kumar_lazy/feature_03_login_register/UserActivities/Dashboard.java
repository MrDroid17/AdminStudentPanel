package com.kumar.save_plus.kumar_lazy.feature_03_login_register.UserActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kumar.save_plus.kumar_lazy.feature_03_login_register.R;

public class Dashboard extends AppCompatActivity {

    TextView username, age, contact_no,validity_period, userLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        getSupportActionBar().setTitle("User Dashboard");

        username= (TextView) findViewById(R.id.etUserName);
        age= (TextView) findViewById(R.id.etAge);
        contact_no = (TextView) findViewById(R.id.tvContact);
        validity_period = (TextView) findViewById(R.id.tvValidity);
        userLogout = (TextView) findViewById(R.id.tvUserLogout);

        //pass date by using sesion Id
        //username.setText(getIntent().getStringExtra("UserName"));
        /*age.setText(getIntent().getStringExtra("age"));
        contact_no.setText(getIntent().getStringExtra("contactNo"));
        validity_period.setText(getIntent().getStringExtra("validity"));*/


        userLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"User Logging Out...", Toast.LENGTH_SHORT).show();

                Intent startUserLoginActivity = new Intent(Dashboard.this, UserLoginActivity.class);
                startActivity(startUserLoginActivity);

            }
        });

    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
