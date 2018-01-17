package com.kumar.save_plus.kumar_lazy.feature_03_login_register.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.kumar.save_plus.kumar_lazy.feature_03_login_register.UserActivities.UserLoginActivity;
import com.kumar.save_plus.kumar_lazy.feature_03_login_register.admin.AdminLoginActivity;

/**
 * Created by kumar_lazy on 6/16/2017.
 */

public class AdminOrUser extends DialogFragment {

    final CharSequence[] item= {"Admin","User"};
    String selection;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
        builder.setTitle("Select Your Profile :").setSingleChoiceItems(item, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        selection= (String) item[which];
                        Intent admin= new Intent(getContext(), AdminLoginActivity.class);
                        startActivity(admin);
                        Toast.makeText(getActivity(), "Your have selected "+selection+" profile", Toast.LENGTH_SHORT).show();

                        break;

                    case 1:
                        selection= (String) item[which];
                        Intent user= new Intent(getContext(), UserLoginActivity.class);
                        startActivity(user);
                        Toast.makeText(getActivity(), "Your have selected "+selection+" profile", Toast.LENGTH_SHORT).show();

                        break;

                }

            }
        });

        return builder.create();
    }
}
