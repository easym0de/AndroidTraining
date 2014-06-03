package com.example.androidtraining.adapters;

import com.example.androidtraining.HomeActivity;
import com.example.androidtraining.R;
import com.example.androidtraining.models.Contact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ContactsListAdapter extends ArrayAdapter<Contact>{
	private final Context context;
	private String[] values = new String[]{};
	
	public ContactsListAdapter(Context context, int resource) {
		super(context, resource);
		this.context = context;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ContactsListAdapter self = this;
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View rowView = inflater.inflate(R.layout.class_list_item, parent, false);
		final TextView label = (TextView) rowView.findViewById(R.id.class_title);
		ImageView detailsIcon = (ImageView) rowView.findViewById(R.id.class_details_icon);
		
		Contact contact = this.getItem(position);
		
		label.setText(contact.getName() + " - " + contact.getEmail());
		
		detailsIcon.setVisibility(View.GONE);
		
		return rowView;
	}
	
}