package com.kumar.save_plus.kumar_lazy.feature_03_login_register.admin;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.kumar.save_plus.kumar_lazy.feature_03_login_register.R;
import com.kumar.save_plus.kumar_lazy.feature_03_login_register.sqlite.keyhelper.KeyDbHelper;

import java.util.Random;

public class AdminDashboard extends AppCompatActivity {
    KeyDbHelper keyDbHelper= new KeyDbHelper(this);
    ListView listView;
    EditText numberOfKeys;
    int keyLength;
    Spinner spinner;
    TextView adminLogout;


    private String[] keys;
    ArrayAdapter<String> listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        numberOfKeys= (EditText) findViewById(R.id.et_keyCount);
        listView =(ListView) findViewById(R.id.list_View);
        spinner= (Spinner) findViewById(R.id.spinner);
        adminLogout= (TextView) findViewById(R.id.tvAdminLogout);

        // adminLogout click eventnm
        adminLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startAdminLogin= new Intent(AdminDashboard.this, AdminLoginActivity.class);
                startActivity(startAdminLogin);
            }
        });


        //spinner is linked with adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.package_type,
                android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Toast.makeText(getBaseContext(),"package for 3 Month Selected",Toast.LENGTH_SHORT).show();
                        keyLength=8;
                        break;
                    case 1:
                        Toast.makeText(getBaseContext(),"package for 6 Month Selected",Toast.LENGTH_SHORT).show();
                        keyLength=10;
                        break;
                    case 2:
                        Toast.makeText(getBaseContext(),"package for 12 Month Selected",Toast.LENGTH_SHORT).show();
                        keyLength=12;
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }


    public void keyGenerator(View view){

       /* String newEntry = editText.getText().toString();
        if(editText.length()!= 0){
            addData(newEntry);
            editText.setText("");
        }else{
            Toast.makeText(MainActivity.this, "You must put something in the text field!", Toast.LENGTH_LONG).show();
        }*/

        keys= randomKeys(Integer.parseInt(numberOfKeys.getText().toString().trim()), keyLength);
        /*String keyStr=convertArrayToString(keys);
            AddData(keyStr);*/

        String keyStr;
        for(int i=0;i<Integer.parseInt(numberOfKeys.getText().toString().trim());i++) {
            keyStr = keys[i];
            AddData(keyStr);
        }
      /* helper =this.openOrCreateDatabase("CUED", MODE_PRIVATE, null);
        //Cursor crs = helper.rawQuery("SELECT * FROM HELLO", null);
        Cursor crs = helper.rawQuery("SELECT * FROM " + TABLE_KEY_DETAILS_EIGHT, null);


        while(crs.moveToNext())
        {
            String uname = crs.getString(crs.getColumnIndex("NAME"));
            System.out.println(uname);
        }*/


        String Str="";
        Cursor data = keyDbHelper.getListContents();
        if(data.getCount() == 0){
            Toast.makeText(this, "There are no contents in this list!",Toast.LENGTH_LONG).show();
        }else{
            //while(data.moveToNext()){
            //Str.add(data.getString(1));

            // Str=convertStringToArray(data.getString(1));
            for(int i=0;i<Integer.parseInt(numberOfKeys.getText().toString().trim());i++) {
               /* while(data.moveToNext()){
                    keys[i] =data.getString(1) ;

                }*/


                //AddData(keyStr);
            }

               /* listAdapter = new ArrayAdapter<String>(this,R.layout.listview_custom_layout,R.id.key_row,keys);
                listView.setAdapter(listAdapter);*/
            // }
            listAdapter = new ArrayAdapter<String>(this,R.layout.listview_custom_layout,R.id.key_row,keys);
            listView.setAdapter(listAdapter);
        }

    }

    private String[] randomKeys(int keysCount, int keySize){
        String contain= "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";  /*special character & lowercase character
                                                                        ,<.>;:@#$%^&*+=-_!   abcdefghijklmnopqrstuvwxyz */

        //int keySize=10;
        //int keysCount=15;
        String[] strArray= new String[keysCount];
        Random random = new Random();
        //StringBuilder sb= new StringBuilder();
        for(int j=0;j<keysCount; j++){

            StringBuilder sb= new StringBuilder(/*Integer.toString(j+1)+"    "*/);

            for(int i=0; i<keySize; i++){
                sb.append(contain.charAt(random.nextInt(contain.length())));

                       /* random.nextInt(anyinteger) generates a random number
                        contain.length() is the inbuilt method to get the length of your string in this case  80.
                        so the output will be a random number  from this random.nextInt(contain.length())
                        contain. charAt will tell the character at the specified the number generated
                        from above in the string contain sb is an instance of string buffer to which you are
                        appending it. it means if sb = "a" initially then sb.append("b") means now sb will be ab*/

            }
            strArray[j]= sb.toString();
            sb.setLength(0);
        }

        return strArray;

    }
    //use this method to convert a StringArray to String
    public static String strSeparator = ", ";
    public static String convertArrayToString(String[] array){
        String str = "";
        for (int i = 0;i<array.length; i++) {
            str = str+array[i];
            // Do not append comma at the end of last element
            if(i<array.length-1){
                str = str+strSeparator;
            }
        }
        return str;
    }
    //use this method to convert a String to StringArray
    public static String[] convertStringToArray(String str){
        String[] arr = str.split(strSeparator);
        return arr;
    }

    //Add data method
    public void AddData(String newEntry) {

        boolean insertData = keyDbHelper.addData(newEntry);

        if(insertData==true){
            Toast.makeText(this, "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Something went wrong :(.", Toast.LENGTH_LONG).show();
        }
    }

}
