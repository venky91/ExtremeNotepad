package com.example.extremenotepad;

public class Note {
	
	String title;
	String note;
	int dbID;
	
	public Note( String title, String note ) {
		
		this.title = title;
		this.note = note;
		
	}
	
	public Note() {
		
		
	}
	
	public void setTitle( String title ) {
		
		this.title = title;
		
	}
	
	public void setNote( String note ) {
		
		this.note = note;
		
	}
	
	public void setDBID( int id ) {
		
		this.dbID = id;
		
	}

}
