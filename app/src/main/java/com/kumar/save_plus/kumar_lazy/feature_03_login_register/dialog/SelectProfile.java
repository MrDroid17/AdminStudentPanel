package com.kumar.save_plus.kumar_lazy.feature_03_login_register.dialog;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.kumar.save_plus.kumar_lazy.feature_03_login_register.R;
import com.kumar.save_plus.kumar_lazy.feature_03_login_register.UserActivities.UserLoginActivity;
import com.kumar.save_plus.kumar_lazy.feature_03_login_register.admin.AdminLoginActivity;

public class SelectProfile extends AppCompatActivity {
    //RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_profile);

       /* radioGroup= (RadioGroup) findViewById(R.id.selectProfile);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case 0:
                        //selection= (String) item[which];
                        Intent admin= new Intent(SelectProfile.this, AdminLoginActivity.class);
                        startActivity(admin);
                        Toast.makeText(getBaseContext(), "Your have selected Admin profile", Toast.LENGTH_SHORT).show();

                        break;

                    case 1:
                        //selection= (String) item[which];
                        Intent user= new Intent(SelectProfile.this, UserLoginActivity.class);
                        startActivity(user);
                        Toast.makeText(getBaseContext(), "Your have selected User profile", Toast.LENGTH_SHORT).show();

                        break;

                }
            }
        });*/


    }

    public void selectProfile(View view){
        boolean checked= ((RadioButton)view).isChecked();

        switch (view.getId()){
            case R.id.selectAdmin:
                //selection= (String) item[which];
                if(checked){
                    Intent admin= new Intent(SelectProfile.this, AdminLoginActivity.class);
                    startActivity(admin);
                    Toast.makeText(getBaseContext(), "Your have selected Admin profile", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.selectUser:
                //selection= (String) item[which];
                if(checked){
                    Intent user= new Intent(SelectProfile.this, UserLoginActivity.class);
                    startActivity(user);
                    Toast.makeText(getBaseContext(), "Your have selected User profile", Toast.LENGTH_SHORT).show();
                }


                break;

        }
    }
}
