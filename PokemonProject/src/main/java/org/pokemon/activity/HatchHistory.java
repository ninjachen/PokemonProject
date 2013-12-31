package org.pokemon.activity;


import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import org.pokemon.R;
import org.pokemon.entity.Pokemon;
import org.pokemon.util.SQLiteHelper;

import java.util.ArrayList;

public class HatchHistory extends ListActivity{
//	private ListView listview;
    private SQLiteHelper sqLiteHelper ;
	Cursor c;
	@Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.contact_list);
        sqLiteHelper = new SQLiteHelper(getApplicationContext());
        setAdapt();
	}

    @Override
    protected void onResume() {
        super.onResume();

        setAdapt();
    }

    private void setAdapt(){
        //活得查询的cursor
//        listview = (ListView)findViewById(R.id.pmlist);
        ArrayList<Pokemon> pokemonList = sqLiteHelper.queryAll();
        PokemonListAdapter pokemonListAdapter = new PokemonListAdapter(getApplicationContext(), pokemonList);
        this.setListAdapter(pokemonListAdapter);
    }
}
