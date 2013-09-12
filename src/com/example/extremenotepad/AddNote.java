package com.example.extremenotepad;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddNote extends Activity {

	EditText enterText;
	Button save;
	Button cancel;
	String title;
	String note;
	Note noteEntry;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_note);
		
		Bundle myInput = getIntent().getExtras();
		final String activity = myInput.getString("activity");
		int noteId = myInput.getInt("id");
		
		enterText = (EditText) findViewById(R.id.enterText);
		save = (Button) findViewById(R.id.save);
		cancel = (Button) findViewById(R.id.cancel);
		
		if ( activity.equalsIgnoreCase("main")) {
			
		}
		
		//Detailed Note called AddNote
		else {
			
			for ( int i = 0; i < ViewNotes.aList.size(); i++ ) {
				
				noteEntry = ViewNotes.aList.get(i);
				if ( noteId == noteEntry.dbID) {
					
					enterText.setText(noteEntry.note);
					break;
				}
			}
		}
		
		save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {	
				
				AlertDialog.Builder alertDialog = new AlertDialog.Builder(AddNote.this);
				
				alertDialog.setTitle("Save Note");
				alertDialog.setMessage("Enter a title for this note (required)");
				
				final EditText input = new EditText(AddNote.this);
				
				if ( activity.equalsIgnoreCase("DetailedNote")) {
					
					input.setText(noteEntry.title);
					
				}
				alertDialog.setView(input);
				
				alertDialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
						title = input.getText().toString();
						note = enterText.getText().toString();
						
						if ( activity.equalsIgnoreCase("main")) {
							Note noteEntry = new Note( title, note );
						
							DBAdapter db = new DBAdapter(AddNote.this);
							db.addNote(noteEntry);
							db.close();
						
							Intent myIntent = new Intent(AddNote.this, MainActivity.class);
							startActivity(myIntent);
						}
						
						// run update query on existing record
						else {
							
							
						}
							
					}
				});
				
				alertDialog.setNegativeButton("Cancel", null);
				
				alertDialog.show();
				   
			}
			
		});
		
		cancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				Intent myIntent = new Intent(AddNote.this, MainActivity.class);
				startActivity(myIntent);
				
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_note, menu);
		return true;
	}

}
