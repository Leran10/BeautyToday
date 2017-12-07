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

/**
 * Created by qingzhi on 12/6/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    Context context;

    //database version
    private static final int database_version = 1;

    //database name
    private static final String database_name = "wardrobe2.0.db";

    //user table name
    private static final String table_name = "coat";

    //user table columns name
    private static final String column_id = "coat_id";
    private static final String column_color = "coat_color";
    private static final String column_pattern = "coat_pattern";
    private static final String column_material = "coat_material";
    private static final String column_style = "coat_style";
    private static final String column_sleeves = "coat_sleeves";
    private static final String column_length = "coat_length";

    //create table sql query
    private static final String create_coat_table = "CREATE TABLE " + table_name + "("+ column_id + " INTEGER PRIMARY KEY,"+
            column_color + " TEXT," + column_pattern + " TEXT," + column_material + " TEXT," + column_style + " TEXT," + column_sleeves + " TEXT," +
            column_length + " TEXT" + ")";

    //drop table sql query
    private static final String drop_coat_table = "drop table if exists" + table_name;

    //constructor
    public DatabaseHelper(Context context){
        super(context,database_name,null,database_version);

    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(create_coat_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion){
        db.execSQL(drop_coat_table);
        onCreate(db);
    }

    //add new coat
    public void addCoat(coat c){


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(column_color,c.getColor());
        values.put(column_pattern,c.getPattern());
        values.put(column_material,c.getMaterial());
        values.put(column_style,c.getStyle());
        values.put(column_sleeves,c.getSleeves());
        values.put(column_length,c.getLength());

        db.insert(table_name,null,values);
        db.close();

    }

    //get all coat
    public List<coat> getAllCoat(){
        String[] columns = {column_id,
                column_color,
                column_pattern,
                column_material,
                column_style,
                column_sleeves,
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
                c.setSleeves(cursor.getString(cursor.getColumnIndex(column_sleeves)));
                c.setLength(cursor.getString(cursor.getColumnIndex(column_length)));
                coatlist.add(c);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return coatlist;
    }

    //update coat
    public void updateCoat(coat c) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(column_color,c.getColor());
        values.put(column_pattern,c.getPattern());
        values.put(column_material,c.getMaterial());
        values.put(column_style,c.getStyle());
        values.put(column_sleeves,c.getSleeves());
        values.put(column_length,c.getLength());
        db.update(table_name,values,column_id + "=?",new String[]{String.valueOf(c.getId())});
        db.close();

    }

    //delete coat
    public void deleteCoat(coat c){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(table_name,column_id + "=?",new String[]{String.valueOf(c.getId())});
        db.close();
    }


    public String selectCoat(){
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

    }



}
