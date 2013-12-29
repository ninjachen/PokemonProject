package org.pokemon.util;



import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

public class MyContentProvider extends ContentProvider
{
	private SQLiteHelper dbHelper;
	
	public static final String AUTHORITY = "org.pokemon";

	public static final Uri CONTENT_URI = Uri.parse("content://"+AUTHORITY+"/contacts");
	
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();	
		String rowId = uri.getPathSegments().get(1);
		//Log.i("","...............rowId="+rowId);
		return db.delete("contactstable","_id = "+rowId, null);
	}

	@Override
	public String getType(Uri uri) {		
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {		
		SQLiteDatabase db = dbHelper.getWritableDatabase();		
		
		long rowID = db.insert("contactstable", null, values);
		if(rowID > 0){
			Uri url = Uri.parse("content://" + AUTHORITY + "/contactstalbe" + "/" + rowID);
			Log.i("",".............run insert.........url="+url);
			return url;
		}

		return null;
	}

	@Override
	public boolean onCreate() {
		dbHelper = new SQLiteHelper(getContext());
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		//"_id = "+uri.getPathSegments().get(1)
		
		return db.query("contactstable", projection, selection, selectionArgs, null, null, sortOrder);
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();	
		String rowId = uri.getPathSegments().get(1);
		Log.i("","...............rowId="+rowId);
		return db.update("contactstable",values,"_id = "+rowId, null);
		
	}

}
