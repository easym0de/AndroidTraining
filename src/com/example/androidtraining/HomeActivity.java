package com.example.androidtraining;

import com.example.androidtraining.adapters.ClassListAdapter;
import com.example.androidtraining.fragments.HomeGridFragment;
import com.example.androidtraining.fragments.HomeListFragment;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class HomeActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_layout);
		
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		
		if(extras.getString("loginName") != null){
			TextView nameView = (TextView) this.findViewById(R.id.welcome_name);
			nameView.setText("Welcome " + extras.getString("loginName"));
		}
		navigate("list");
		
	}
	
	public void onFooterTap(View v){
		navigate(v.getTag().toString());
	}
	
	public void navigate(String tag){
		Fragment frag = null;
		if(tag.equalsIgnoreCase("list")){
			frag = new HomeListFragment();
		} else if(tag.equalsIgnoreCase("grid")){
			frag = new HomeGridFragment();
		} else{
			return;
		}
		
		FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
      
        ft.replace(R.id.home_fragment_content, frag, null);
        ft.commitAllowingStateLoss();
      
        getSupportFragmentManager().executePendingTransactions();
	      
	}

}
