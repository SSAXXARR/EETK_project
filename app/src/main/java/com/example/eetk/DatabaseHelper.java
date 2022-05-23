package com.example.eetk;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DB_NAME = "rasp.sqlite";
    private static final int SCHEMA = 1; // версия базы данных
    static final String TABLE = "myrasp";
    private static String DB_PATH;

    public static final String COLUMN_ID="id";
    public static final String COLUMN_ID_PREPOD = "id_prepod";
    public static final String COLUMN_NAME_PREPOD = "prepod";
    public static final String COLUMN_DAY = "day";
    public static final String COLUMN_GROUP_ID = "group_id";
    public static final String COLUMN_GROUP = "group";
    public static final String COLUMN_KABINET = "kab";
    public static final String COLUMN_POD_GROUP = "pod_group";


    public SQLiteDatabase database;
    private Context myContext;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, SCHEMA);
        this.myContext=context;
        DB_PATH = "/data/data/myraspisanie/databases/";

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {

    }

    public void create_db(){
        InputStream myInput = null;
        OutputStream myOutput = null;
        try {
            File file = new File(DB_PATH + DB_NAME);
            if (!file.exists()) {
                this.getReadableDatabase();
                myInput = myContext.getAssets().open(DB_NAME);

                String outFileName = DB_PATH + DB_NAME;
                myOutput = new FileOutputStream(outFileName);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = myInput.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }

                myOutput.flush();
                myOutput.close();
                myInput.close();
            }
        }
        catch(IOException ex){

        }
    }

    public void open() throws SQLException {
        String path = DB_PATH + DB_NAME;
        database = SQLiteDatabase.openDatabase(path, null,
                SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {
        if (database != null) {
            database.close();
        }
        super.close();
    }
}
