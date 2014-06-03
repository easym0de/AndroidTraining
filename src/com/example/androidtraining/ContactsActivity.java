package com.example.androidtraining;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import com.example.androidtraining.adapters.ClassListAdapter;
import com.example.androidtraining.adapters.ContactsListAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class ContactsActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contacts_main);
	}
	
	public void viewAllContacts(View v){
		Intent launchAllContactsIntent = new Intent(this, AllContactsActivity.class);
		this.startActivity(launchAllContactsIntent);
	}
	
	public void createNewContact(View v){
		Intent launchCreateContactIntent = new Intent(this, CreateContactActivity.class);
		this.startActivity(launchCreateContactIntent);
	}

}
