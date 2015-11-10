package com.example.franchez.lopvent;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Franchez on 2015-11-10.
 */
public class DBCreation extends SQLiteOpenHelper {

    //Database version and name respectively
    private static final int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "lopventDatabase";

    //Table Names
    private static final String CATEGORY_TABLE = "categoryTable";
    private static final String EVENT_TABLE = "eventTable";
    private static final String PLACES_TABLE = "placesTable";

    //Create CategoryTable statments
    private static final String CREATE_TABLE_CATEGORY = "CREATE TABLE" + CATEGORY_TABLE
            + "("
            + "CategoryID INTEGER PRIMARY KEY"
            + "CategoryName"
            + ")";

    public DBCreation(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_CATEGORY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
