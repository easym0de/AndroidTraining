
package com.example.androidtraining.fragments;


import com.example.androidtraining.R;
import com.example.androidtraining.adapters.ClassListAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class HomeListFragment extends Fragment {
	private ClassListAdapter classListAdapter;
	static final String[] CLASS_LIST = new String[] { "Class 1", "Class 2", "Class 3", "Class 4", "Class 5", "Class 6 - Make it rain", "Class 7"};
	
	@Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.home_list_layout, container, false);
	  }
	
	
	@Override
	public void onResume(){
		super.onResume();
		setupListAdapter();
	}

	
	public void setupListAdapter(){
		ListView classListView = (ListView) this.getActivity().findViewById(R.id.class_list);
		
		classListAdapter = new ClassListAdapter(this.getActivity(), R.id.class_list);
		classListAdapter.addAll(CLASS_LIST);
		
		classListView.setAdapter(classListAdapter);
	}
	

	
	
}
