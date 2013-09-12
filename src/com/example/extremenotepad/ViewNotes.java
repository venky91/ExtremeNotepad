package com.example.extremenotepad;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ViewNotes extends ListActivity implements OnClickListener {

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

	@Override
	public void onListItemClick(ListView parent, View v, int position, long id)  {
		
		String key = getListAdapter().getItem(position).toString();
		String[] str = key.split(": ");
		String entryId = str[0];
		
		Intent myIntent = new Intent(ViewNotes.this, DetailedNote.class);
		myIntent.putExtra("key", entryId);

		startActivity(myIntent);
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}



}
