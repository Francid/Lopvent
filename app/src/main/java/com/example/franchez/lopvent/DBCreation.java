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

    //Create categoryTable statments
    private static final String CREATE_TABLE_CATEGORY = "CREATE TABLE " + CATEGORY_TABLE
            + "( "
            + "CategoryID INTEGER PRIMARY KEY"
            + "CategoryName VARCHAR(50)"
            + " );";

    //Create eventTable statement
    private static final String CREATE_TABLE_EVENT = "CREATE TABLE " + EVENT_TABLE
            + "( "
            + "EventID      INTEGERY PRIMARY KEY"
            + "EventName    VARCHAR(50)"
            + "EventLocation VARCHAR(50)"
            + "EventDate    TEXT"
            + "EventTime    TEXT"
            + "EventEndDate TEXT"
            + "EventDescription TEXT"
            + "EventRating  NUMERIC"
            + "CategoryID   INTEGER"
            + "FOREIGN KEY(CategoryID) REFERENCES " + CATEGORY_TABLE + "(CategoryID)"
            + " );";

    //Create placesTable statement
    private static final String CREATE_TABLE_PLACES = "CREATE TABLE " + PLACES_TABLE
            +"( "
            + "PlaceID      INTEGER PRIMARY KEY"
            + "PLaceName    VARCHAR(50)"
            + "PlaceLocation VARCHAR(50)"
            + "PlaceDescription TEXT"
            + "PlaceRating  NUMERIC"
            +" );";

    public DBCreation(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_CATEGORY);
        db.execSQL(CREATE_TABLE_EVENT);
        db.execSQL(CREATE_TABLE_PLACES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
