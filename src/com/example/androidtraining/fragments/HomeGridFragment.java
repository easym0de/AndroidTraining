
package com.example.androidtraining.fragments;


import com.example.androidtraining.R;
import com.example.androidtraining.adapters.ClassGridAdapter;
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

public class HomeGridFragment extends Fragment {
	private ClassGridAdapter classGridAdapter;
	
	static final String[] CLASS_LIST = new String[] { "Class 1", "Class 2", "Class 3", "Class 4", "Class 5", "Class 6 - Make it rain"};
	
	@Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.home_grid_layout, container, false);
	  }
	
	
	@Override
	public void onResume(){
		super.onResume();
		setupGridAdapter();
	}

	public void setupGridAdapter(){
		GridView classListView = (GridView) this.getActivity().findViewById(R.id.class_grid);
		
		classGridAdapter = new ClassGridAdapter(this.getActivity(), R.id.class_grid);
		classGridAdapter.addAll(CLASS_LIST);
		
		classListView.setAdapter(classGridAdapter);
	}
	

	
	
}
