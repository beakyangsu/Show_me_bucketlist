package test.myapplication2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.content.res.TypedArrayUtils;

import java.util.ArrayList;

/**
 * Created by yangsu on 2017-10-31.
 */

public class MyDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "DBList.db";
    public static final String DB_TABLE = "DBList";

    public MyDBHelper(Context context){
        super(context, DB_NAME, null, 1);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
            onCreate(db);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE IF NOT EXISTS " + DB_TABLE + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, address TEXT, latitude TEXT, longitude TEXT);");

    }

    public boolean DBInsert(SQLiteDatabase db, String name, String address, String latitude, String longitude){

        ContentValues value = new ContentValues();

        value.put("name", name);
        value.put("address", address);
        value.put("latitude", latitude);
        value.put("longitude", longitude);

        if(db.insert(DB_TABLE,null, value)>0)
            return true;
        else
            return false;
    }

    public boolean DBDelete(SQLiteDatabase db, Integer id ){
        String _id = String.valueOf(id);
        if(1 == db.delete(DB_TABLE,"_id=?", new String[]{_id}))
            return true;
        else
            return false;
    }
    public void DBUpgrade(SQLiteDatabase db, int id, String key, String data){

        ContentValues value = new ContentValues();
        String _id = String.valueOf(id);

        value.put(key, data);
        db.execSQL("UPDATE " + DB_TABLE + " SET " + key + " = " + data + " WHERE _id = " + _id + ";");
    }

    public Cursor DBSelect(SQLiteDatabase db, int id){
        String _id = String.valueOf(id);
        return db.rawQuery("SELECT * FROM " + DB_TABLE + " WHERE _id = " + _id, null );
      //  return db.query(DB_TABLE, null, new String(_id), null, null, null, null);
    }

    public ArrayList DBShow(SQLiteDatabase db){

        Cursor c = db.query(DB_TABLE, null, null, null, null, null, null);

        ArrayList<String> list = new ArrayList<String>();
        while(c.moveToNext()){
            int id = c.getInt(0);
            String name = c. getString(1);
            String address = c. getString(2);
            String latitude = c.getString(3);
            String longitude = c.getString(4);
            list.add(id + "|" + name + "|" + address + "|" + latitude + "|" + longitude);
        }
        c.close();
        return list;
    }

}