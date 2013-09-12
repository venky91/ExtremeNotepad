package com.example.extremenotepad;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetailedNote extends Activity {

	int id;
	
	TextView viewText;
	Button home;
	Button edit;
	Button delete;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.note_detailed);
		
		Bundle myInput = this.getIntent().getExtras();
		String key = myInput.getString("key");
		
		id = Integer.parseInt(key);
		
		viewText = (TextView) findViewById(R.id.viewText);
		
		
		for (int i = 0; i < ViewNotes.aList.size(); i++ ) {
			
			Note note = ViewNotes.aList.get(i);
		
			if ( note.dbID == id ) {
				
				viewText.setText(note.note);
				break;
			}
		
		}
		
		home = (Button) findViewById(R.id.home);
		edit = (Button) findViewById(R.id.edit);
		delete = (Button) findViewById(R.id.delete);
		
		home.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		edit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		delete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
		
 	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detailed_note, menu);
		return true;
	}

}
