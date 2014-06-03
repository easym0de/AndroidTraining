package com.example.androidtraining;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import com.example.androidtraining.models.Contact;
import com.example.androidtraining.utils.DatabaseHandler;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class CreateContactActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_contact);
	}
	
	public void createContactSubmit(View v){
		EditText inputName = (EditText) this.findViewById(R.id.name);
		EditText inputEmail = (EditText) this.findViewById(R.id.email);
		
		DatabaseHandler dbHandler = new DatabaseHandler(this);
		dbHandler.addContact(new Contact(inputName.getText().toString(), inputEmail.getText().toString()));
		
		Intent launchAllContactsIntent = new Intent(this, AllContactsActivity.class);
		this.startActivity(launchAllContactsIntent);
	}
	

}
