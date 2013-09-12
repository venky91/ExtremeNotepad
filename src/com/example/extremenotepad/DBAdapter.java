package com.example.extremenotepad;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAdapter extends SQLiteOpenHelper {
	
	public static final String KEY_ROWID = "id";
	public static final String KEY_TITLE = "title";
	public static final String KEY_NOTE = "note";
	
	private static final String DATABASE_NAME = "NoteDB";
	private static final String DATABASE_TABLE = "notes";
	private static final int DATABASE_VERSION = 1;
	
	private static final String DATABASE_CREATE =
			"create table if not exists " + DATABASE_TABLE + " (" + KEY_ROWID + " integer primary key " +
"	autoincrement, " + KEY_TITLE + " VARCHAR, " + KEY_NOTE + " VARCHAR);";
	
	public DBAdapter( Context context ) {
		
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL(DATABASE_CREATE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	public void addNote( Note note ) {
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_TITLE, note.title);
		values.put(KEY_NOTE, note.note);
		
		db.insert(DATABASE_TABLE, null, values);
		db.close();
		
	}
	
	public void deleteNote( int id ) {
		
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(DATABASE_TABLE, KEY_ROWID + "=" + id, null);
		db.close();
		
	}
	
	public List<Note> getAllNotes() {
		
		List<Note> aList = new ArrayList<Note>();
		
		// Select All Query
        String selectQuery = "SELECT * FROM " + DATABASE_TABLE;
        
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        
        if ( cursor.moveToFirst() ) {
        	
        	do {
        		
        		Note note = new Note();
        		note.setDBID(cursor.getInt(0));
        		note.setTitle(cursor.getString(1));
        		note.setNote(cursor.getString(2));
        		
        		aList.add(note);
        	}
        	
        	while ( cursor.moveToNext() );
        }
        
        return aList;
        
	}

}
