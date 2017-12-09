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

import model.bag;
import model.boots;
import model.coat;
import model.dress;
import model.skirt;
import model.trousers;

/**
 * Created by qingzhi on 12/6/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    Context context;

    //database version
    private static final int database_version = 1;

    //database name
    private static final String database_name = "beauty2.0.db";

    //user table name
    private static final String table_coat = "coat";
    private static final String table_dress = "dress";
    private static final String table_skirt = "skirt";
    private static final String table_trousers = "trousers";
    private static final String table_boots = "boots";
    private static final String table_bag = "bag";

    //coat table columns name
    private static final String coat_column_id = "coat_id";
    private static final String coat_column_color = "coat_color";
    private static final String coat_column_pattern = "coat_pattern";
    private static final String coat_column_material = "coat_material";
    private static final String coat_column_style = "coat_style";
    private static final String coat_column_sleeves = "coat_sleeves";
    private static final String coat_column_length = "coat_length";
    private static final String coat_column_img = "coat_img";

    //dress table columns name
    private static final String dress_column_id = "dress_id";
    private static final String dress_column_color = "dress_color";
    private static final String dress_column_pattern = "dress_pattern";
    private static final String dress_column_material = "dress_material";
    private static final String dress_column_style = "dress_style";
    private static final String dress_column_sleeves = "dress_sleeves";
    private static final String dress_column_length = "dress_length";
    private static final String dress_column_img = "dress_img";

    //skirt table columns name
    private static final String skirt_column_id = "skirt_id";
    private static final String skirt_column_color = "skirt_color";
    private static final String skirt_column_pattern = "skirt_pattern";
    private static final String skirt_column_material = "skirt_material";
    private static final String skirt_column_style = "skirt_style";
    private static final String skirt_column_length = "skirt_length";
    private static final String skirt_column_img = "skirt_img";

    //trousers table columns name
    private static final String trousers_column_id = "trousers_id";
    private static final String trousers_column_color = "trousers_color";
    private static final String trousers_column_pattern = "trousers_pattern";
    private static final String trousers_column_material = "trousers_material";
    private static final String trousers_column_style = "trousers_style";
    private static final String trousers_column_length = "trousers_length";
    private static final String trousers_column_img = "trousers_img";

    //boots table columns name
    private static final String boots_column_id = "boots_id";
    private static final String boots_column_color = "boots_color";
    private static final String boots_column_pattern = "boots_pattern";
    private static final String boots_column_material = "boots_material";
    private static final String boots_column_style = "boots_style";
    private static final String boots_column_heel = "boots_heel";
    private static final String boots_column_img = "trousers_img";

    //bags table columns name
    private static final String bag_column_id = "bag_id";
    private static final String bag_column_color = "bag_color";
    private static final String bag_column_pattern = "bag_pattern";
    private static final String bag_column_material = "bag_material";
    private static final String bag_column_style = "bag_style";
    private static final String bag_column_img = "bag_img";

    //create coat table sql query
    private static final String create_coat_table = "CREATE TABLE " + table_coat + "("+ coat_column_id + " INTEGER PRIMARY KEY,"+
            coat_column_color + " TEXT," + coat_column_pattern + " TEXT," + coat_column_material + " TEXT," + coat_column_style + " TEXT," + coat_column_sleeves + " TEXT," +
            coat_column_length + " TEXT, " +  coat_column_img  + " BYTE" + ")";

    //create dress table sql query
    private static final String create_dress_table = "CREATE TABLE " + table_dress + "("+ dress_column_id + " INTEGER PRIMARY KEY,"+
            dress_column_color + " TEXT," + dress_column_pattern + " TEXT," + dress_column_material + " TEXT," + dress_column_style + " TEXT, " + dress_column_sleeves + " TEXT,"+
            dress_column_length + " TEXT, " +  dress_column_img  + " BYTE " + ")";

    //create skirt table sql query
    private static final String create_skirt_table = "CREATE TABLE " + table_skirt + "("+ skirt_column_id + " INTEGER PRIMARY KEY,"+
            skirt_column_color + " TEXT," + skirt_column_pattern + " TEXT," + skirt_column_material + " TEXT," + skirt_column_style + " TEXT, " +
            skirt_column_length + " TEXT, " +  skirt_column_img  + " BYTE " + ")";


    //create trousers table sql query
    private static final String create_trousers_table = "CREATE TABLE " + table_trousers + "("+ trousers_column_id + " INTEGER PRIMARY KEY,"+
            trousers_column_color + " TEXT," + trousers_column_pattern + " TEXT," + trousers_column_material + " TEXT," + trousers_column_style + " TEXT, " +
            trousers_column_length + " TEXT, " +  trousers_column_img  + " BYTE " + ")";

    //create boots table sql query
    private static final String create_boots_table = "CREATE TABLE " + table_boots + "("+ boots_column_id + " INTEGER PRIMARY KEY,"+
            boots_column_color + " TEXT," + boots_column_pattern + " TEXT," + boots_column_material + " TEXT," + boots_column_style + " TEXT, " +
            boots_column_heel + " TEXT, " +  boots_column_img  + " BYTE " + ")";

    //create bag table sql query
    private static final String create_bag_table = "CREATE TABLE " + table_bag + "("+ bag_column_id + " INTEGER PRIMARY KEY,"+
            bag_column_color + " TEXT," + bag_column_pattern + " TEXT," + bag_column_material + " TEXT," + bag_column_style + " TEXT, " +
            " TEXT, " +  bag_column_img  + " BYTE " + ")";



    //drop table sql query
    private static final String drop_coat_table = "drop table if exists" + table_coat;
    private static final String drop_dress_table = "drop table if exists" + table_dress;
    private static final String drop_skirt_table = "drop table if exists" + table_skirt;
    private static final String drop_trousers_table = "drop table if exists" + table_trousers;
    private static final String drop_boots_table = "drop table if exists" + table_boots;
    private static final String drop_bag_table = "drop table if exists" + table_boots;

    //constructor
    public DatabaseHelper(Context context){
        super(context,database_name,null,database_version);

    }

    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL(create_coat_table);
        db.execSQL(create_dress_table);
        db.execSQL(create_skirt_table);
        db.execSQL(create_trousers_table);
        db.execSQL(create_boots_table);
        db.execSQL(create_bag_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion){
        db.execSQL(drop_coat_table);
        db.execSQL(drop_dress_table);
        db.execSQL(drop_skirt_table);
        db.execSQL(drop_trousers_table);
        db.execSQL(drop_boots_table);
        db.execSQL(drop_bag_table);
        onCreate(db);
    }

    //add new coat
    public void addCoat(coat c){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(coat_column_color,c.getColor());
        values.put(coat_column_pattern,c.getPattern());
        values.put(coat_column_material,c.getMaterial());
        values.put(coat_column_style,c.getStyle());
        values.put(coat_column_sleeves,c.getSleeves());
        values.put(coat_column_length,c.getLength());
        values.put(coat_column_img,c.getImage());
        db.insert(table_coat,null,values);
        db.close();

    }

    //add new dress
    public void addDress(dress d){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(dress_column_color,d.getColor());
        values.put(dress_column_pattern,d.getPattern());
        values.put(dress_column_material,d.getMaterial());
        values.put(dress_column_style,d.getStyle());
        values.put(dress_column_sleeves,d.getSleeves());
        values.put(dress_column_length,d.getLength());
        values.put(dress_column_img,d.getImage());
        db.insert(table_dress,null,values);
        db.close();

    }

    //add new skirt
    public void addSkirt(skirt s){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(skirt_column_color,s.getColor());
        values.put(skirt_column_pattern,s.getPattern());
        values.put(skirt_column_material,s.getMaterial());
        values.put(skirt_column_style,s.getStyle());
        values.put(skirt_column_length,s.getLength());
        values.put(skirt_column_img,s.getImage());
        db.insert(table_skirt,null,values);
        db.close();

    }

    //add new trousers
    public void addTrousers(trousers t){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(trousers_column_color,t.getColor());
        values.put(trousers_column_pattern,t.getPattern());
        values.put(trousers_column_material,t.getMaterial());
        values.put(trousers_column_style,t.getStyle());
        values.put(trousers_column_length,t.getLength());
        values.put(trousers_column_img,t.getImage());
        db.insert(table_trousers,null,values);
        db.close();

    }

    //add new boots
    public void addBoots(boots b){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(boots_column_color,b.getColor());
        values.put(boots_column_pattern,b.getPattern());
        values.put(boots_column_material,b.getMaterial());
        values.put(boots_column_style,b.getStyle());
        values.put(boots_column_img,b.getImage());
        db.insert(table_boots,null,values);
        db.close();

    }

    //add new bag
    public void addBag(bag a){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(bag_column_color,a.getColor());
        values.put(bag_column_pattern,a.getPattern());
        values.put(bag_column_material,a.getMaterial());
        values.put(bag_column_style,a.getStyle());
        values.put(bag_column_img,a.getImage());
        db.insert(table_bag,null,values);
        db.close();

    }



    //get all coat
   /* public List<coat> getAllCoat(){
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
                c.setImage(cursor.get(cursor.getColumnIndex(column_img)));
                cursor.
                coatlist.add(c);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return coatlist;
    }*/

    //update coat
    public void updateCoat(coat c) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(coat_column_color,c.getColor());
        values.put(coat_column_pattern,c.getPattern());
        values.put(coat_column_material,c.getMaterial());
        values.put(coat_column_style,c.getStyle());
        values.put(coat_column_sleeves,c.getSleeves());
        values.put(coat_column_length,c.getLength());
        db.update(table_coat,values,coat_column_id + "=?",new String[]{String.valueOf(c.getId())});
        db.close();

    }

    //delete coat
    public void deleteCoat(coat c){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(table_coat,coat_column_id + "=?",new String[]{String.valueOf(c.getId())});
        db.close();
    }

    //delete dress
    public void deleteDress(dress d){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(table_dress,dress_column_id + "=?",new String[]{String.valueOf(d.getId())});
        db.close();
    }

    //delete skirt
    public void deleteSkirt(skirt s){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(table_skirt,skirt_column_id + "=?",new String[]{String.valueOf(s.getId())});
        db.close();
    }

    //delete trousers
    public void deleteTrousers(trousers t){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(table_trousers,trousers_column_id + "=?",new String[]{String.valueOf(t.getId())});
        db.close();
    }

    //delete boots
    public void deleteBoots(boots b){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(table_boots,boots_column_id + "=?",new String[]{String.valueOf(b.getId())});
        db.close();
    }

    //delete boots
    public void deleteBag(bag a){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(table_bag,bag_column_id + "=?",new String[]{String.valueOf(a.getId())});
        db.close();
    }








}
