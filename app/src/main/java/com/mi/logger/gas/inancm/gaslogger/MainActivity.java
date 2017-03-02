package com.mi.logger.gas.inancm.gaslogger;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Locale;
import android.content.ContentValues;
import android.database.Cursor;
import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    String[] myDataset;


    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
    private static final String TAG = "MainActivity";
    public List<GasLog> gasLogList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "Created");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyc);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                GasLogContract.GasLog._ID,
                GasLogContract.GasLog.COLUMN_NAME_MILAGE,
                GasLogContract.GasLog.COLUMN_NAME_VOLUME,
                GasLogContract.GasLog.COLUMN_NAME_MONEY
        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                GasLogContract.GasLog.COLUMN_NAME_MILAGE + " DESC";

        SQLiteOpenHelper dbh = new GasLogOpenHelper(this);
        final SQLiteDatabase db = dbh.getWritableDatabase();

        Cursor cursor = db.query(
                GasLogContract.GasLog.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );
        gasLogList = new ArrayList<>();
        while(cursor.moveToNext()) {
            long mileage = cursor.getLong(
                    cursor.getColumnIndexOrThrow(GasLogContract.GasLog.COLUMN_NAME_MILAGE));
            String vol = cursor.getString(cursor.getColumnIndexOrThrow(GasLogContract.GasLog.COLUMN_NAME_VOLUME));
            String mon = cursor.getString(cursor.getColumnIndexOrThrow(GasLogContract.GasLog.COLUMN_NAME_MONEY));
            gasLogList.add(new GasLog(String.valueOf(mileage),vol, mon));
            Log.i(TAG, String.valueOf(mileage)+" "+vol+" "+mon);
        }
        cursor.close();

        // specify an adapter (see also next example)
        mAdapter = new RecycAdapter(gasLogList);
        mRecyclerView.setAdapter(mAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new map of values, where column names are the keys
                for (int i = 0; i<10; i++) {
                    ContentValues values = new ContentValues();
                    values.put(GasLogContract.GasLog.COLUMN_NAME_MILAGE, 1000+i);
                    values.put(GasLogContract.GasLog.COLUMN_NAME_DATE, getDateTime());
                    values.put(GasLogContract.GasLog.COLUMN_NAME_MONEY, "10.10");
                    values.put(GasLogContract.GasLog.COLUMN_NAME_VOLUME, "40.35");

                    // Insert the new row, returning the primary key value of the new row
                    long newRowId = db.insert(GasLogContract.GasLog.TABLE_NAME, null, values);
                }
            }
        });






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
