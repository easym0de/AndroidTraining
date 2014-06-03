package com.example.androidtraining;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.example.androidtraining.adapters.ContactsListAdapter;
import com.example.androidtraining.utils.DatabaseHandler;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class AllContactsActivity extends Activity {
	
	private ContactsListAdapter contactsListAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.all_contacts);
		
		ListView classListView = (ListView) this.findViewById(R.id.contacts_list);
		contactsListAdapter = new ContactsListAdapter(this, R.id.class_list);
		classListView.setAdapter(contactsListAdapter);
		
		DatabaseHandler dbHandler = new DatabaseHandler(this);
		
		List contacts = dbHandler.getAllContacts();
		
		contactsListAdapter.addAll(contacts);
		contactsListAdapter.notifyDataSetChanged();
	}

}
