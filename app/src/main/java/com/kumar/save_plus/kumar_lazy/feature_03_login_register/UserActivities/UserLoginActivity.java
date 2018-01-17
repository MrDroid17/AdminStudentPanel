package com.kumar.save_plus.kumar_lazy.feature_03_login_register.UserActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kumar.save_plus.kumar_lazy.feature_03_login_register.R;
import com.kumar.save_plus.kumar_lazy.feature_03_login_register.sqlite.DatabaseHelper;

public class UserLoginActivity extends AppCompatActivity {

    DatabaseHelper helper= new DatabaseHelper(this);
    EditText username, password;
    //Button login;
    TextView register_here;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        getSupportActionBar().setTitle("User Login");



        register_here= (TextView) findViewById(R.id.tvRegisterHERE);


        register_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startRegisterActivity= new Intent(UserLoginActivity.this, UserRegisterActivity.class);
                startActivity(startRegisterActivity);
            }
        });

    }

    public void userLogin(View v){

        if(v.getId()==R.id.bLogin){
            username= (EditText) findViewById(R.id.etUserName);
            password= (EditText) findViewById(R.id.etPassWord);

            String inputUsernameStr= username.getText().toString();
            String inputPasswordStr= password.getText().toString();

            String finalPassword= helper.searchPassword(inputUsernameStr);

            if(inputPasswordStr.equals(finalPassword)){
                Intent startDashboard= new Intent(UserLoginActivity.this, Dashboard.class);
                startDashboard.putExtra("UserName", inputUsernameStr);
                startActivity(startDashboard);

            }else{
                Toast.makeText(getBaseContext(), "UserName or Password don't match", Toast.LENGTH_SHORT).show();

            }
        }

    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

}
