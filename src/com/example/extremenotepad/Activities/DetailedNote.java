package com.example.extremenotepad.Activities;

import com.example.extremenotepad.R;
import com.example.extremenotepad.DBCtrl.DBAdapter;
import com.example.extremenotepad.Helper.NoteHelper;
import com.example.extremenotepad.Impl.Note;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
	Note note;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.note_detailed);
		
		Bundle myInput = this.getIntent().getExtras();
		String key = myInput.getString("key");
		
		id = Integer.parseInt(key);
		viewText = (TextView) findViewById(R.id.viewText);
		
		
		for (int i = 0; i < NoteHelper.noteList.size(); i++ ) {
			
			note = NoteHelper.noteList.get(i);
		
			if ( note.getDBID() == id ) {
				
				viewText.setText(note.getNote());
				break;
			}
		
		}
		
		home = (Button) findViewById(R.id.home);
		edit = (Button) findViewById(R.id.edit);
		delete = (Button) findViewById(R.id.delete);
		
		home.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				Intent myIntent = new Intent(DetailedNote.this, MainActivity.class);
				startActivity(myIntent);
				
			}
			
		});
		
		edit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				Bundle b = new Bundle();
				b.putString("activity", "DetailedNote");
				b.putInt("id", note.getDBID());
				Intent myIntent = new Intent(DetailedNote.this, AddNote.class);
				myIntent.putExtras(b);
				startActivity(myIntent);
				
				
			}
			
		});
		
		delete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				AlertDialog.Builder alertDialog = new AlertDialog.Builder(DetailedNote.this);
				
				// Setting Dialog Title
				alertDialog.setTitle("Confirm Delete");
				
				// Setting Dialog Message
				alertDialog.setMessage("Are you sure you want to delete this entry?");

				alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
						DBAdapter db = new DBAdapter(DetailedNote.this);
						db.deleteNote(id);
						
						Intent myIntent = new Intent(DetailedNote.this, ViewNotes.class);
						startActivity(myIntent);
						
					}
				});
				
				alertDialog.setNegativeButton("No", null);
				
				alertDialog.show();
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
