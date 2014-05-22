package com.example.androidtraining;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends Activity {

	String FILENAME = "logged_in_user";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_layout);
		
		try {
			int n;
			FileInputStream fis = this.openFileInput(FILENAME);
			

			InputStreamReader isr = new InputStreamReader ( fis ) ;
            BufferedReader buffreader = new BufferedReader ( isr ) ;

            String readString = buffreader.readLine();
			
			if(readString != null && readString.toString().length() > 0 ){
				Intent launchHomeIntent = new Intent(this, HomeActivity.class);
				launchHomeIntent.putExtra("loginName", readString);
				this.startActivity(launchHomeIntent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loginSubmit(View v){
		EditText inputName = (EditText) this.findViewById(R.id.name);

		try{
			FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
			fos.write(inputName.getText().toString().getBytes());
			fos.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		
		Intent launchHomeIntent = new Intent(this, HomeActivity.class);
		launchHomeIntent.putExtra("loginName", inputName.getText().toString());
		this.startActivity(launchHomeIntent);
	}

}
