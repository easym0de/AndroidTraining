package com.example.androidtraining.adapters;

import com.example.androidtraining.HomeActivity;
import com.example.androidtraining.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ClassGridAdapter extends ArrayAdapter<String>{
	private final Context context;
	private String[] values = new String[]{};
	
	public ClassGridAdapter(Context context, int resource) {
		super(context, resource);
		this.context = context;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ClassGridAdapter self = this;
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View rowView = inflater.inflate(R.layout.class_grid_item, parent, false);
		TextView label = (TextView) rowView.findViewById(R.id.class_title);
		
		final String value = this.getItem(position);

		label.setText(value);
		
		rowView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	if(value.contains("Class 6 - Make it rain")){
            		((HomeActivity)context).startRain();
            		self.remove("Class 6 - Make it rain");
            		self.add("Class 6 - Stop the rain");
            	} else if(value.contains("Class 6 - Stop the rain")){
            		((HomeActivity)context).stopRain();
            		self.remove("Class 6 - Stop the rain");
            		self.add("Class 6 - Make it rain");
            	}else {
            		Toast.makeText(context, value, Toast.LENGTH_LONG).show();
            	}
            }
        });
		
		return rowView;
	}
	
}