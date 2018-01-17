package com.kumar.save_plus.kumar_lazy.feature_03_login_register.UserActivities;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kumar.save_plus.kumar_lazy.feature_03_login_register.R;
import com.kumar.save_plus.kumar_lazy.feature_03_login_register.sqlite.DatabaseHelper;
import com.kumar.save_plus.kumar_lazy.feature_03_login_register.sqlite.UserAttributes;
import com.kumar.save_plus.kumar_lazy.feature_03_login_register.sqlite.keyhelper.KeyDbHelper;

public class UserRegisterActivity extends AppCompatActivity {
    DatabaseHelper helper= new DatabaseHelper(this);
    KeyDbHelper keyDbHelper=new KeyDbHelper(this);

    EditText name, username, age, contactNo, email, password, confirmPassword, auth_key ;
   // Button register;
    TextView login_here;
    String validity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        getSupportActionBar().setTitle("User Register");

        /*name= (EditText) findViewById(R.id.etName);
        username= (EditText) findViewById(R.id.etUserName);
        age= (EditText) findViewById(R.id.etAge);
        contactNo= (EditText) findViewById(R.id.etContactNo);
        email= (EditText) findViewById(R.id.etEmail);
        password= (EditText) findViewById(R.id.etPassWord);
        confirmPassword= (EditText) findViewById(R.id.etConfirmPassWord);*/

        //register= (Button) findViewById(R.id.bRegister);
        login_here= (TextView) findViewById(R.id.tvLoginHERE);

        login_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startLoginActivity = new Intent(UserRegisterActivity.this, UserLoginActivity.class);
                startActivity(startLoginActivity);
            }
        });

        /*register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name= (EditText) findViewById(R.id.etName);
                username= (EditText) findViewById(R.id.etUserName);
                age= (EditText) findViewById(R.id.etAge);
                contactNo= (EditText) findViewById(R.id.etContactNo);
                email= (EditText) findViewById(R.id.etEmail);
                password= (EditText) findViewById(R.id.etPassWord);
                confirmPassword= (EditText) findViewById(R.id.etConfirmPassWord);

                String nameStr= name.getText().toString();
                String usernameStr= username.getText().toString();
                String ageStr= age.getText().toString();
                String contactNoStr= contactNo.getText().toString();
                String emailStr=email.getText().toString();
                String passwordStr= password.getText().toString();
                String confirmPasswordStr= confirmPassword.getText().toString();

                if(!passwordStr.equals(confirmPasswordStr)){
                    //Snackbar.make(UserRegisterActivity.this, "password don't match", Snackbar.LENGTH_LONG).show();
                    Toast.makeText(getBaseContext(), "password dont't match", Toast.LENGTH_SHORT).show();

                }else{

                    UserAttributes attributes= new UserAttributes();
                    attributes.setName(nameStr);
                    attributes.setUserName(usernameStr);
                    attributes.setAge(ageStr);
                    attributes.setContactNo(contactNoStr);
                    attributes.setEmail(emailStr);
                    attributes.setPassword(passwordStr);

                    helper.addUser(attributes);

                }
            }
        });*/
    }

    public void userRegister(View v){
       if(v.getId()== R.id.bRegister){
           name= (EditText) findViewById(R.id.etName);
           username= (EditText) findViewById(R.id.etUserName);
           age= (EditText) findViewById(R.id.etAge);
           contactNo= (EditText) findViewById(R.id.etContactNo);
           email= (EditText) findViewById(R.id.etEmail);
           password= (EditText) findViewById(R.id.etPassWord);
           confirmPassword= (EditText) findViewById(R.id.etConfirmPassWord);

           String nameStr= name.getText().toString();
           String usernameStr= username.getText().toString();
           int ageInt= Integer.parseInt(age.getText().toString());
           String contactNoStr= contactNo.getText().toString();
           String emailStr=email.getText().toString();
           String passwordStr= password.getText().toString();
           String confirmPasswordStr= confirmPassword.getText().toString();



           if(!passwordStr.equals(confirmPasswordStr)){
               //Snackbar.make(UserRegisterActivity.this, "password don't match", Snackbar.LENGTH_LONG).show();
               Toast.makeText(getBaseContext(), "password dont't match", Toast.LENGTH_SHORT).show();

           }else{
               auth_key= (EditText) findViewById(R.id.etAuthorisationKey);
               String auth_keyStr=auth_key.getText().toString();

              /* switch(auth_keyStr.length()){
                   case 8:
                       validity="03 Month";
                       break;
                   case 10:
                       validity="06 Month";
                       break;
                   case 12:
                       validity="12 Month";
                       break;
               }*/


               //final key exist in keys.db database
               boolean finalKey= keyDbHelper.searchKey(auth_keyStr);

               if(finalKey){

                   switch(auth_keyStr.length()){
                       case 8:
                           validity="03 Month";
                           Toast.makeText(getBaseContext(),"Account Validity - 03 Month", Toast.LENGTH_SHORT ).show();
                           break;
                       case 10:
                           validity="06 Month";
                           Toast.makeText(getBaseContext(),"Account Validity - 06 Month", Toast.LENGTH_SHORT ).show();
                           break;
                       case 12:
                           validity="12 Month";
                           Toast.makeText(getBaseContext(),"Account Validity - 12 Month", Toast.LENGTH_SHORT ).show();
                           break;
                   }

                   UserAttributes attributes= new UserAttributes();
                   attributes.setName(nameStr);
                   attributes.setUserName(usernameStr);
                   attributes.setAge(ageInt);
                   attributes.setContactNo(contactNoStr);
                   attributes.setEmail(emailStr);
                   attributes.setPassword(passwordStr);

                   helper.addUser(attributes);

                   Toast.makeText(getBaseContext(), "Your Account is generated", Toast.LENGTH_SHORT).show();

                   Intent startDashboard= new Intent(UserRegisterActivity.this, Dashboard.class);
                   /*startDashboard.putExtra("validity", validity);
                   startDashboard.putExtra("userName", usernameStr);
                   startDashboard.putExtra("age", ageInt);
                   startDashboard.putExtra("contactNo", contactNoStr);*/


                   startActivity(startDashboard);


               }else{
                   Toast.makeText(getBaseContext(), "Authorization Key NOT Valid..", Toast.LENGTH_SHORT).show();

               }
           }
               /*UserAttributes attributes= new UserAttributes();
               attributes.setName(nameStr);
               attributes.setUserName(usernameStr);
               attributes.setAge(ageInt);
               attributes.setContactNo(contactNoStr);
               attributes.setEmail(emailStr);
               attributes.setPassword(passwordStr);

               helper.addUser(attributes);
               Toast.makeText(getBaseContext(), "1 row of data is inserted in database...", Toast.LENGTH_SHORT).show();
*/


           //check if auth key exist

       }
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
