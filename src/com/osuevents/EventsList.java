package com.osuevents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class EventsList extends ArrayAdapter<Event> {
	
	private Event[] eventsArray;
	private Context context;
	
	public EventsList(Context context, int textViewResourceId, Event[] eventsArray) {
		super(context, textViewResourceId, eventsArray);
		this.eventsArray = eventsArray;
		this.context = context;
	}
	
	@Override
	public View getView (int position, View convertView, ViewGroup parent){
		View v = convertView;
		if (v == null) {
			LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.list_item, null);
		}
		Event e = eventsArray[position];
		if (e != null) {
			TextView eventName = (TextView) v.findViewById(R.id.eventName);
			TextView eventStartDate = (TextView) v.findViewById(R.id.eventStartDate);
			if (eventName != null)
				eventName.setText(e.getEventName());
			if (eventStartDate != null)
				eventStartDate.setText(e.getStartDate().toString());
		}
		return v;
	}

}