package com.example.franchez.lopvent;

/**
 * Created by lijunhao on 2015-11-18.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="LOPVENT.db";
    public static final String TABLE_NAME="EVENT";
    public static final String TABLE_NAME2="PLACE";

    public static final String COL_1="EVENT_ID";
    public static final String COL_2="DATE";
    public static final String COL_3="TIME";
    public static final String COL_4="PRICE";
    public static final String COL_5="DESCRIPTION";
    public static final String COL_6="LOCATION";
    public static final String COL_7="PICTURE";

    public static final String COL_8="PLACE_ID";
    public static final String COL_9="PICTURE";
    public static final String COL_10="DESCRIPTION";
    public static final String COL_11="LOCATION";

    public static final String COL_12="E_NAME";
    public static final String COL_13="P_NAME";




    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 2);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME +"(EVENT_ID INTEGER PRIMARY KEY AUTOINCREMENT, E_NAME TEXT,DATE TEXT,TIME TEXT,PRICE TEXT,DESCRIPTION TEXT,LOCATION TEXT,PICTURE TEXT)");
        db.execSQL("create table "+ TABLE_NAME2 +"(PLACE_ID INTEGER PRIMARY KEY AUTOINCREMENT,P_NAME TEXT,PICTURE TEXT,DESCRIPTION TEXT,LOCATION TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists " +TABLE_NAME);
        db.execSQL("Drop table if exists " +TABLE_NAME2);

        onCreate(db);
    }

    public boolean insertEvent(String name,String date,String time,String price,String description,String location,String picture){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,date);
        contentValues.put(COL_3,time);
        contentValues.put(COL_4,price);
        contentValues.put(COL_5,description);
        contentValues.put(COL_6,location);
        contentValues.put(COL_7,picture);
        contentValues.put(COL_12,name);
        long result=db.insert(TABLE_NAME,null,contentValues);
        db.close();
        if (result==-1)
            return  false;
        else
            return  true;
    }
    public boolean insertPlace(String name,String picture,String description,String location ){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_9,picture);
        contentValues.put(COL_10,description);
        contentValues.put(COL_11,location);
        contentValues.put(COL_13,name);


        long result=db.insert(TABLE_NAME2,null,contentValues);
        db.close();
        if (result==-1)
            return  false;
        else
            return  true;
    }

    public Cursor getEvent(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select EVENT_ID as _id,E_NAME,DATE,TIME,PRICE,DESCRIPTION,LOCATION FROM "+TABLE_NAME,null);
        return res;
    }
    public Cursor getPlace(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select PLACE_ID as _id, P_NAME,PICTURE,DESCRIPTION,LOCATION FROM "+TABLE_NAME2,null);
        return res;
    }
}


