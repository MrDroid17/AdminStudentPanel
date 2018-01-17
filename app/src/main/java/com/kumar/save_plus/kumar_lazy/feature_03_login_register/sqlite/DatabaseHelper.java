package com.kumar.save_plus.kumar_lazy.feature_03_login_register.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by kumar_lazy on 6/17/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME= "UserManager.db";
    private static final String TABLE_USER= "user";

    private static final String COLUMN_USER_ID= "user_id";
    private static final String COLUMN_USER_NAME= "user_name";
    private static final String COLUMN_USER_USERNAME="user_username";
    private static final String COLUMN_USER_AGE= "user_age";
    private static final String COLUMN_USER_CONTACT= "user_contact";
    private static final String COLUMN_USER_EMAIL= "user_email";
    private static final String COLUMN_USER_PASSWORD= "user_password";

    private String CREATE_USER_TABLE = "CREATE TABLE "+TABLE_USER
            + "("+ COLUMN_USER_ID+ " INTEGER PRIMARY KEY NOT NULL,"
            +COLUMN_USER_NAME+ " TEXT NOT NULL,"
            +COLUMN_USER_USERNAME+ " TEXT NOT NULL,"
            +COLUMN_USER_AGE+ " INTEGER NOT NULL,"
            +COLUMN_USER_CONTACT+ " TEXT NOT NULL,"
            +COLUMN_USER_EMAIL+ " TEXT NOT NULL,"
            +COLUMN_USER_PASSWORD+ " TEXT NOT NULL" +")";

    private String DROP_USER_TABLE ="DROP TABLE IF EXIST "+ TABLE_USER;

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.v("Database Operation", "Database created or opened");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_USER_TABLE);
        onCreate(db);

    }

    public void addUser(UserAttributes attributes){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values= new ContentValues();

       /* String query= "SELECT * FROM"+ TABLE_USER;
        Cursor cursor= db.rawQuery(query, null);
        int count= cursor.getCount();

        values.put(COLUMN_USER_ID, count);
*/
        values.put(COLUMN_USER_NAME, attributes.getName());
        values.put(COLUMN_USER_USERNAME, attributes.getUserName());
        values.put(COLUMN_USER_AGE, attributes.getAge());
        values.put(COLUMN_USER_CONTACT, attributes.getContactNo());
        values.put(COLUMN_USER_EMAIL, attributes.getEmail());
        values.put(COLUMN_USER_PASSWORD, attributes.getPassword());

        db.insert(TABLE_USER, null, values);
        Log.v("Database Operation", "one row is inserted");
        db.close();
    }

    public String searchPassword(String user_username){
        SQLiteDatabase db = this.getReadableDatabase();
        String query= "SELECT user_username, user_password FROM "+ TABLE_USER;

        Cursor cursor= db.rawQuery(query, null);
        String a, b;
        b="not found";

        if(cursor.moveToFirst()){
            do{
                a= cursor.getString(0);

                if(a.equals(user_username )){

                    b= cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext());
        }
        return  b;
    }

    public String[] retriveUserDetails(SQLiteDatabase db) {
        String[] columns = {

                DatabaseHelper.COLUMN_USER_ID,
                DatabaseHelper.COLUMN_USER_NAME,
                DatabaseHelper.COLUMN_USER_USERNAME,
                DatabaseHelper.COLUMN_USER_AGE,
                DatabaseHelper.COLUMN_USER_CONTACT,
                DatabaseHelper.COLUMN_USER_EMAIL,
                DatabaseHelper.COLUMN_USER_PASSWORD

        };

        Cursor cursor = db.query(DatabaseHelper.TABLE_USER, columns, null, null, null, null, null, null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {

                int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_USER_ID));
                String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_USER_NAME));
                String username = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_USER_USERNAME));
                int age = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_USER_AGE));
                String contact = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_USER_CONTACT));
                String email = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_USER_EMAIL));
                String password = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_USER_PASSWORD));
            }
        }
        cursor.close();
        return columns;
    }
 /*   public boolean checkUser(String email){
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_USER_EMAIL + " = ?";
        String[] selectionArgs = { email };

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0){
            return true;
        }
        return false;
    }

    public boolean checkUser(String email, String password){
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " =?";
        String[] selectionArgs = { email, password };

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0){
            return true;
        }
        return false;
    }*/
}
