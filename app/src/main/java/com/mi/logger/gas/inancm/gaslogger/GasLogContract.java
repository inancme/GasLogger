package com.mi.logger.gas.inancm.gaslogger;

import android.provider.BaseColumns;

/**
 * Created by metinin on 01.03.2017.
 */

public final class GasLogContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private GasLogContract() {}

    /* Inner class that defines the table contents */
    public static class GasLog implements BaseColumns {
        public static final String TABLE_NAME = "gasMilageLog";
        public static final String COLUMN_NAME_MILAGE = "milage";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_VOLUME = "volume";
        public static final String COLUMN_NAME_MONEY = "money";
    }
}
