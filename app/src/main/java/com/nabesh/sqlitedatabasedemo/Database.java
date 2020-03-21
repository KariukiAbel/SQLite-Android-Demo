package com.nabesh.sqlitedatabasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "details.db";
    public static final String TABLE_USER = "contacts";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FIRSTNAME = "first name";
    public static final String COLUMN_LASTNAME = "last name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PHONENUMBER = "phone number";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_DATE_REGISTERED = "date registered";

    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

//    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
//        super(context, name, factory, version, errorHandler);
//    }

//    public Database(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
//        super(context, name, version, openParams);
//    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_SQL = "CREATE TABLE " + TABLE_USER + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_FIRSTNAME + " VARCHAR(255) NOTNULL, " +
                COLUMN_LASTNAME + " VARCHAR(255) NOTNULL, " +
                COLUMN_EMAIL + " VARCHAR(255) NOTNULL, " +
                COLUMN_PHONENUMBER + " VARCHAR(255) NOTNULL, " +
                COLUMN_GENDER + " VARCHAR(255) NOTNULL, " +
                COLUMN_DATE_REGISTERED + " TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP )";
        sqLiteDatabase.execSQL(CREATE_TABLE_SQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(sqLiteDatabase);
    }

    public void addDetails(DataModel detailsAdapter){
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID,detailsAdapter.getId());
        values.put(COLUMN_FIRSTNAME,detailsAdapter.getFirstname());
        values.put(COLUMN_LASTNAME,detailsAdapter.getLastname());
        values.put(COLUMN_EMAIL,detailsAdapter.getEmail());
        values.put(COLUMN_PHONENUMBER,detailsAdapter.getPhonenumber());
        values.put(COLUMN_GENDER,detailsAdapter.getGender());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_USER,null,values);
        db.close();
    }
}
