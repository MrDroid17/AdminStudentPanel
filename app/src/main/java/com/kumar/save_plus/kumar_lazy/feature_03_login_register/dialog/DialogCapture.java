package com.kumar.save_plus.kumar_lazy.feature_03_login_register.dialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kumar.save_plus.kumar_lazy.feature_03_login_register.dialog.AdminOrUser;

public class DialogCapture extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // make appear dialog for admin and login Page
        AdminOrUser selectSingleOptions = new AdminOrUser();
        selectSingleOptions.show(getSupportFragmentManager(),"select_single_options");
    }
}
