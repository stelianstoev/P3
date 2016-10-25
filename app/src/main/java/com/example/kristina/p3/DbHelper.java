package com.example.kristina.p3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Kristina on 16.10.2016.
 */

public class DbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "appDB.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_USERS = "USERS";
    public static final String TABLE_DRINKS = "DRINKS";
    public static final String TABLE_REWARD = "REWARDS";
    public static final String TABLE_CONSUMTION = "COMSUMTION";

    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_DRINKS_ID = "drink_id";
    public static final String COLUMN_REWARD_ID = "reward_id";
    public static final String TABLE_DRINKS_ID = "consumtion";

    public static final String COLUMN_ROOM = "room";
    public static final String COLUMN_BALANCE = "balance";
    public static final String COLUMN_TIMESTAMP = "date";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_POINTS = "points";
    public static final String COLUMN_TYPE = "type";

    public static final String SQL_CREATE_USERS =
            "CREATE TABLE " + TABLE_USERS +
                    "(" + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_ROOM + " TEXT NOT NULL, " +
                    COLUMN_BALANCE + " INTEGER NOT NULL);";

    public static final String SQL_CREATE_DRINKS =
            "CREATE TABLE " + TABLE_DRINKS +
                    "(" + COLUMN_DRINKS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT NOT NULL, " +
                    COLUMN_PRICE + " INTEGER NOT NULL);";

    public static final String SQL_CREATE_CONSUMTION =
            "CREATE TABLE " + TABLE_CONSUMTION +
                    "(" + COLUMN_DRINKS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_USER_ID + " INTEGER" +
                    COLUMN_NAME + " TEXT NOT NULL, " +
                    COLUMN_PRICE + " INTEGER NOT NULL), " +
                    COLUMN_TIMESTAMP + " TIMESTAMP NOT NULL " +
                    " FOREIGN KEY ("+COLUMN_USER_ID+") REFERENCES "+ TABLE_USERS +"(" + COLUMN_USER_ID + "));";

    public static final String SQL_CREATE_REWARD =
            "CREATE TABLE " + TABLE_REWARD +
                    "(" + COLUMN_REWARD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_USER_ID + " INTEGER" +
                    COLUMN_NAME + " TEXT NOT NULL, " +
                    COLUMN_POINTS + " INTEGER NOT NULL, " +
                    COLUMN_TIMESTAMP + " TIMESTAMP NOT NULL " +
                    " FOREIGN KEY ("+COLUMN_USER_ID+") REFERENCES "+ TABLE_USERS +"(" + COLUMN_USER_ID + "));";

    public DbHelper (Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        Log.d("DbHelper", "DbHelper hat die Datenbank: " + getDatabaseName() + " erzeugt.");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Log.d("", "Die Tabelle wird mit SQL-Befehl angelegt.");
            db.execSQL(SQL_CREATE_USERS);
            db.execSQL(SQL_CREATE_DRINKS);
            db.execSQL(SQL_CREATE_REWARD);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
