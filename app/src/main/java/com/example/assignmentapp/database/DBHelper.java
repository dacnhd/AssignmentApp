package com.example.assignmentapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "SPENDING";
    public static final int DB_VERSION = 1;

    public static String TABLE_NAME = "TBL_SPENDING";
    public static String ID = "_id";
    public static String NAME = "name";
    public static String DES = "des";
    public static String DETAIL = "detail";
    public static String MONEY = "money";
    public static String DATEAT = "dateat";
    public static String CATEGORY = "category";
    public static String TABLE_NAME_CATEGORY = "TBL_CATEGORY";
    public static String ID_CATEGORY = "id_category";
    public static String NAME_CATEGORY = "name_category";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + TABLE_NAME + " ( " +
                ID + " INTEGER PRIMARY KEY, " +
                NAME + "TEXT, " +
                DES + " TEXT, " +
                DETAIL + "TEXT, " +
                MONEY + " TEXT, " +
                DATEAT + "TEXT, " +
                CATEGORY + " TEXT)";

        String sqlCategory = "CREATE TABLE " + TABLE_NAME_CATEGORY + " ( " +
                ID_CATEGORY + " INTEGER PRIMARY KEY, " +
                NAME_CATEGORY + " TEXT)";
        sqLiteDatabase.execSQL(sql);
        sqLiteDatabase.execSQL(sqlCategory);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        String sqlCategory = "DROP TABLE IF EXISTS " + TABLE_NAME_CATEGORY;
        sqLiteDatabase.execSQL(sql);
        sqLiteDatabase.execSQL(sqlCategory);
        onCreate(sqLiteDatabase);
        initView();
    }

    public String add(String name, String des, String detail, String money, String dateAt, String category){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(DES, des);
        contentValues.put(DETAIL, detail);
        contentValues.put(MONEY, money);
        contentValues.put(DATEAT, dateAt);
        contentValues.put(CATEGORY, category);
        long isAdd = db.insert(TABLE_NAME, null, contentValues);
        if (isAdd == -1){
            return "Add Fail";
        }
        db.close();
        return "Add success";
    }

    public Cursor getAll(){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME;
        Cursor c = db.rawQuery(sql, null);
        return c;
    }

    public String addCategory(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME_CATEGORY, name);
        long isAdd = db.insert(TABLE_NAME_CATEGORY, null, contentValues);
        db.close();
        return name;
    }

    public Cursor getAllCategory(){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME_CATEGORY;
        Cursor c = db.rawQuery(sql, null);
        return c;
    }

    private void initView(){
        addCategory("Tiet kiem online");
        addCategory("Di cho");
        addCategory("Tien hoc");
        addCategory("Tien nha");
    }
}
