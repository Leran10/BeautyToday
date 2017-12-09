package SQLite;

/**
 * Created by qingzhi on 12/7/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import model.coat;
import model.dress;

/**
 * Created by qingzhi on 12/6/2017.
 */

public class dressDatabaseHelper extends SQLiteOpenHelper {

    Context context;

    //database version
    private static final int database_version = 1;

    //database name
    private static final String database_name = "wardrobe3.0.db";

    //user table name
    private static final String table_name = "dress";

    //dress table columns name
    private static final String column_id = "dress_id";
    private static final String column_color = "dress_color";
    private static final String column_pattern = "dress_pattern";
    private static final String column_material = "dress_material";
    private static final String column_style = "dress_style";
    private static final String column_length = "dress_length";
    private static final String column_img = "dress_img";

    //create table sql query
    private static final String create_dress_table = "CREATE TABLE " + table_name + "("+ column_id + " INTEGER PRIMARY KEY,"+
            column_color + " TEXT," + column_pattern + " TEXT," + column_material + " TEXT," + column_style + " TEXT, " +
            column_length + " TEXT, " +  column_img  + " BYTE " + ")";

    //drop table sql query
    private static final String drop_dress_table = "drop table if exists" + table_name;

    //constructor
    public dressDatabaseHelper(Context context){
        super(context,database_name,null,database_version);

    }

    @Override
    public void onCreate(SQLiteDatabase db){ db.execSQL(create_dress_table); }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion){
        db.execSQL(drop_dress_table);
        onCreate(db);
    }

    //add new coat

    public void addDress(dress d){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(column_color,d.getColor());
        values.put(column_pattern,d.getPattern());
        values.put(column_material,d.getMaterial());
        values.put(column_style,d.getStyle());
        values.put(column_length,d.getLength());
        values.put(column_img,d.getImage());
        db.insert(table_name,null,values);
        db.close();

    }


    //get all coat
   /* public List<dress> getAlldress(){
        String[] columns = {column_id,
                column_color,
                column_pattern,
                column_material,
                column_style,
                column_length};

        String sortOrder = column_color + "ASC";
        List<coat> coatlist = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(table_name,columns,null,null,null,null,sortOrder);

        if (cursor.moveToFirst()) {
            do {
                coat c = new coat();
                c.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(column_id))));
                c.setColor(cursor.getString(cursor.getColumnIndex(column_color)));
                c.setPattern(cursor.getString(cursor.getColumnIndex(column_pattern)));
                c.setMaterial(cursor.getString(cursor.getColumnIndex(column_material)));
                c.setStyle(cursor.getString(cursor.getColumnIndex(column_style)));
                c.setLength(cursor.getString(cursor.getColumnIndex(column_length)));
                c.setImage(cursor.get(cursor.getColumnIndex(column_img)));
                cursor.
                dresslist.add(d);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return dresslist;
    }*/

    //update coat
    public void updateDress(dress d) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(column_color,d.getColor());
        values.put(column_pattern,d.getPattern());
        values.put(column_material,d.getMaterial());
        values.put(column_style,d.getStyle());
        values.put(column_length,d.getLength());
        db.update(table_name,values,column_id + "=?",new String[]{String.valueOf(d.getId())});
        db.close();

    }

    //delete coat
    public void deleteDress(dress d){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(table_name,column_id + "=?",new String[]{String.valueOf(d.getId())});
        db.close();
    }


    /*public String selectDress(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = null;
        String colorpick = "pig";
        String img = null;
        cursor =  db.rawQuery("select * from " + table_name + " where coat_id =" + 0,null);
        if(cursor!= null){
            cursor.moveToFirst();
            img = cursor.getString(cursor.getColumnIndex("sleeves"));

        }
        return img;

    }*/

}
