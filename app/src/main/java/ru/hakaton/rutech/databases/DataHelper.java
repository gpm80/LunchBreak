package ru.hakaton.rutech.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "database_resource";

    private static final String TABLE_USER = "User";
    private static final String COLUMN_UID = "uid";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_ABOUT = "about";
    private static final String COLUMN_AVATAR = "avatar";

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createPlayer = "create table " + TABLE_USER + "(" + COLUMN_UID + " INTEGER primary key, " + COLUMN_NAME + " TEXT, " +
                COLUMN_ABOUT + " TEXT, " + COLUMN_AVATAR + " TEXT)";

        db.execSQL(createPlayer);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_USER);
        onCreate(db);
    }
}
