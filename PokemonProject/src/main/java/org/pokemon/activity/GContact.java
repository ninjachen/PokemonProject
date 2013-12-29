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

public class GContact extends ListActivity{
	ListView contactList;
	ListAdapter adapter;
	Cursor c;
	@Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.contact_list);   
        
        contactList = (ListView)findViewById(android.R.id.list);
     
//        setAdapter();
	}

	
}
