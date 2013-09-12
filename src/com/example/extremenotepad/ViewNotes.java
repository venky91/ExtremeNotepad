package com.example.extremenotepad;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.widget.ArrayAdapter;

public class ViewNotes extends ListActivity {

	public static List<Note> aList;
	ArrayList<String> list = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_notes);
		
		DBAdapter db = new DBAdapter(this);
		
		aList = db.getAllNotes();
		
		Note note;
		
		for ( int i = aList.size() - 1 ; i >= 0; i-- ) {
			
			note = aList.get(i);
			String entry = Integer.toString(note.dbID) + ": " + note.title;
			list.add(entry);
			
		} 
		
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_notes, menu);
		return true;
	}

}
