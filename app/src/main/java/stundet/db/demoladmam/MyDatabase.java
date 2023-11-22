package stundet.db.demoladmam;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDatabase extends SQLiteOpenHelper {
   static String DBNAME="MyDB";
   static int VERSION=1;
    MyDatabase(Context context)
    {
        super(context,DBNAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String tbl_user="CREATE TABLE user(name text,mobile text)";

        db.execSQL(tbl_user);
        Log.i("Status","User Table Created.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    boolean insertUser(String name,String mobile)
    {
        SQLiteDatabase db;
        try{
            String q="insert into user(name,mobile) values('"+name+"','"+mobile+"') ";
            db=this.getReadableDatabase();
            db.execSQL(q);
            Log.i("Query ",q);
            return true;
        }catch (Exception e)
        {
            Log.e("Error is ",e.getMessage());
            return false;
        }
    }

}
