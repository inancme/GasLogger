package com.mi.logger.gas.inancm.gaslogger;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
/**
 * Created by metinin on 28.02.2017.
 */

public abstract class GasLogOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "GAS_MILAGE_LOG";
    private static final String DICTIONARY_TABLE_NAME = "gasMilageLog";
    private static final String DICTIONARY_TABLE_CREATE =
            "CREATE TABLE " + DICTIONARY_TABLE_NAME + " (" +
                    "milage" + " INTEGER PRIMARY KEY, " +
                    "date" + " DATETIME, " +
                    "volume" + " TEXT, " +
                    "money" + " TEXT);";

    GasLogOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DICTIONARY_TABLE_CREATE);
    }
}
