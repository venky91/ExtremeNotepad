package com.example.extremenotepad.Activities;

import com.example.extremenotepad.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button addNote;
	Button viewNotes;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		addNote = (Button) findViewById(R.id.addNote);
		viewNotes = (Button) findViewById(R.id.viewNotes);
		
		addNote.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				Bundle b = new Bundle();
				b.putString("activity", "main");
				b.putInt("id", 0);
					
				Intent myIntent = new Intent(MainActivity.this, AddNote.class);
				myIntent.putExtras(b);
				startActivity(myIntent);
				
			}
			
		});
		
		viewNotes.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				Intent myIntent = new Intent(MainActivity.this, ViewNotes.class);
				startActivity(myIntent);
				
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
