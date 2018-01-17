package com.kumar.save_plus.kumar_lazy.feature_03_login_register.sqlite.keyhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kumar_lazy on 6/21/2017.
 */

public class KeyDbHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "keys.db";

    // Contacts table name
    private static final String TABLE_KEY_DETAILS_EIGHT= "eight_character_key";

    // Contacts Table Columns names
    private static final String COLUMN_KEY_ID = "id";
    private static final String COLUMN_KEY_VALUE = "key";


    public KeyDbHelper(Context contex) {
        super(contex, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {

        String CREATE_STUDENT_DETAIL_TABLE = "CREATE TABLE " + TABLE_KEY_DETAILS_EIGHT + "("
                + COLUMN_KEY_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_KEY_VALUE + " TEXT"+ ")";

        db.execSQL(CREATE_STUDENT_DETAIL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KEY_DETAILS_EIGHT);

        // Create tables again
        onCreate(db);
    }

    public boolean addData(String string) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_KEY_VALUE, string);

        long result = db.insert(TABLE_KEY_DETAILS_EIGHT, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_KEY_DETAILS_EIGHT, null);
        //Cursor data=db.rawQuery("SELECT * FROM " + TABLE_KEY_DETAILS_EIGHT +"ORDER BY"+ COLUMN_KEY_ID, null);
        return data;
    }

    public boolean searchKey(String authKey){
        SQLiteDatabase db = this.getReadableDatabase();
        String query= "SELECT key FROM "+ TABLE_KEY_DETAILS_EIGHT;

        Cursor cursor= db.rawQuery(query, null);
        String a, b;
        b="not found";

        if(cursor.moveToFirst()){
            do{
                a= cursor.getString(0);

                if(a.equals(authKey)){

                    return true;
                    //break;
                }
            }while(cursor.moveToNext());
        }
        return false;
    }


    /*// Adding new Student Information
    public void addNewKey(KeyAttributes newKey) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_KEY_VALUE, newKey.getKey());

        // Inserting Row
        db.insert(TABLE_KEY_DETAILS_EIGHT, null, values);
        db.close(); // Closing database connection
    }





    // Getting All Students
    public List<KeyAttributes> getAllStudentList() {


        List<KeyAttributes> keyList = new ArrayList<KeyAttributes>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_KEY_DETAILS_EIGHT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                KeyAttributes keyAttributes = new KeyAttributes();
                keyAttributes.setId(Integer.parseInt(cursor.getString(0)));
                keyAttributes.setKey(cursor.getString(1));

                // Adding key to list
                keyList.add(keyAttributes);

            } while (cursor.moveToNext());
        }

        // return contact list
        return keyList;
    }*/

}
