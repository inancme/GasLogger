package com.mi.logger.gas.inancm.gaslogger;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.util.Log;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import android.provider.BaseColumns;

/**
 * Created by metinin on 28.02.2017.
 */

class GasLogOpenHelper extends SQLiteOpenHelper {

    private static final String TAG = "GasLogOpenHelper";
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "GAS_MILAGE_LOG";
    private static final String SQL_TABLE_CREATE =
            "CREATE TABLE " + GasLogContract.GasLog.TABLE_NAME + " (" +
                    GasLogContract.GasLog._ID + " INTEGER PRIMARY KEY, " +
                    GasLogContract.GasLog.COLUMN_NAME_MILAGE + " INTEGER, " +
                    GasLogContract.GasLog.COLUMN_NAME_DATE + " DATETIME, " +
                    GasLogContract.GasLog.COLUMN_NAME_VOLUME + " TEXT, " +
                    GasLogContract.GasLog.COLUMN_NAME_MONEY + " TEXT);";

    GasLogOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "Created");
        db.execSQL(SQL_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
