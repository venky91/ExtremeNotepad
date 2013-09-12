package com.example.extremenotepad;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class DetailedNote extends Activity {

	int id;
	
	TextView viewText;
	
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
		
 	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detailed_note, menu);
		return true;
	}

}
