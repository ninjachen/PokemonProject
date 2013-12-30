package org.pokemon.util;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.pokemon.entity.Pokemon;

import java.util.ArrayList;

public class SQLiteHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "Pokemon.db";
    public static final String TABLE_NAME = "HATCH_HISTORY";
    private final static int VERSION = 1;

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "pokemonIndex INTEGER, " +
                "name TEXT, " +
                "gender TEXT, " +
                "hp INTEGER, " +
                "atk INTEGER, " +
                "def INTEGER, " +
                "spatk INTEGER, " +
                "spdef INTEGER, " +
                "speed INTEGER, " +
                "via1 TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("onUpgrade");
//        db.execSQL("DROP TABLE IF EXISTS contactstable");
//        onCreate(db);
    }


    public boolean insert(Pokemon pm){
        //默认袋龙
        String sql ="INSERT INTO " + TABLE_NAME +
                " (pokemonIndex, name, gender, hp, atk, def, spatk, spdef, speed) VALUES (115, Kangaskhan, female, ?, ?, ?, ?, ?, ?)";
        Object [] params = new Object[] { pm.getHp(), pm.getAtk(), pm.getDef(), pm.getSpAtk(), pm.getSpDef(), pm.getSpeed()};
        getWritableDatabase().execSQL(sql, params);
        return true;
    }

    public ArrayList<Pokemon> queryAll() {
        ArrayList<Pokemon> pmList = new ArrayList<Pokemon>();
        Cursor c1 = null;
        String sql = "selcet * from " + SQLiteHelper.TABLE_NAME;
        try {
            c1 = getWritableDatabase().rawQuery(sql, null);
            while(c1.moveToNext()){
                Pokemon pm = new Pokemon();
                pm.setHp(c1.getColumnIndex("hp"));
                pm.setAtk(c1.getColumnIndex("atk"));
                pm.setDef(c1.getColumnIndex("def"));
                pm.setSpAtk(c1.getColumnIndex("spatk"));
                pm.setSpDef(c1.getColumnIndex("spdef"));
                pm.setSpeed(c1.getColumnIndex("speed"));
                pmList.add(pm);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DATABASE ERROR " + e);

        }
        return pmList;

    }
}