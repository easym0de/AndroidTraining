package com.example.androidtraining.adapters;

import com.example.androidtraining.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ClassListAdapter extends ArrayAdapter<String>{
	private final Context context;
	private String[] values = new String[]{};
	
	public ClassListAdapter(Context context, int resource) {
		super(context, resource);
		this.context = context;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View rowView = inflater.inflate(R.layout.class_list_item, parent, false);
		TextView label = (TextView) rowView.findViewById(R.id.class_title);
		ImageView detailsIcon = (ImageView) rowView.findViewById(R.id.class_details_icon);
		
		final String value = this.getItem(position);
		
		label.setText(value);
		
		detailsIcon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Toast.makeText(context, value, Toast.LENGTH_LONG).show();
            }
        });
		
		return rowView;
	}
	
}