package com.example.androidtraining;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_layout);
	}
	
	public void loginSubmit(View v){
		EditText inputName = (EditText) this.findViewById(R.id.name);
		
		Intent launchHomeIntent = new Intent(this, HomeActivity.class);
		launchHomeIntent.putExtra("loginName", inputName.getText().toString());
		this.startActivity(launchHomeIntent);
	}

}
