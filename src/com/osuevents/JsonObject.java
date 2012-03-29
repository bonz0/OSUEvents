/**
 * 
 */
package com.osuevents;

import org.json.*;

import java.util.*;
import java.text.*;

/**
 * The Ohio State University Events Application (Android platform)
 * @author Farhang Zia
 *
 */
public class JsonObject {
	String rawJsonString;
	JsonObject(String raw_string) {
		this.rawJsonString = raw_string;
	}
	Event[] parseEvents() throws ParseException {
		Event[] eventArray = null;
		JSONObject jsonObj;
		try {
			jsonObj = new JSONObject(this.rawJsonString);
			JSONObject result = jsonObj.optJSONObject("result");
			JSONArray data = result.getJSONArray("data");
			eventArray = new Event[data.length()];
			for(int iii = 0; iii < data.length(); iii++) {
				JsonObject jObject = new JsonObject(data.getJSONObject(iii).toString());
				eventArray[iii] = jObject.parseEvent();
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eventArray;
	}
	Event parseEvent() {
		Event event = null;
		try {
			JSONObject jsonObj = new JSONObject(this.rawJsonString);
			JSONObject result = jsonObj.optJSONObject("result");
			if(result != null)
			{
				JSONObject data = result.optJSONObject("data");
				if(data != null)
				{
					int id = data.getInt("id");
					event  = new Event(id);
					String name = data.getString("name");
					if(!name.isEmpty())
						event.setName(name);
					
					String start_date_string = data.optString("start_date");
					start_date_string = start_date_string.replace(":", "");
					DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HHmmssZ");
					if(!start_date_string.isEmpty()) {
						Date start_date = formatter.parse(start_date_string);
						event.setStartDate(start_date);
					}
					
					String end_date_string = data.optString("end_date");
					if(!end_date_string.equals("null")) {
						end_date_string = end_date_string.replace(":", "");
						Date end_date = formatter.parse(end_date_string);
						event.setEndDate(end_date);
					}
					String contact_email = data.optString("contact_email");
					if(!contact_email.isEmpty())
						event.setContactEmail(contact_email);
					
					String contact_name = data.getString("contact_name");
					if(!contact_name.isEmpty())
						event.setContactName(contact_name);
					
					String contact_number = data.optString("contact_number");
					if(!contact_number.isEmpty())
						event.setContactNumber(contact_number);
					
					String event_type = data.optString("event_type");
					if(!event_type.isEmpty())
						event.setEventType(event_type);
					
					String event_link = data.optString("event_link");
					if(!event_link.isEmpty())
						event.setEventLink(event_link);
					
					String details_link = data.optString("details_link");
					if(!details_link.isEmpty())
						event.setDetailsLink(details_link);
					
					String description = data.optString("description");
					if(!description.isEmpty())
						event.setDescription(description);
					
					int category = data.optInt("category");
					event.setCategory(category);
					
					int location = data.optInt("location");
					event.setLocation(location);
				}
			}
			else {
				int id = jsonObj.getInt("id");
				event  = new Event(id);
				String name = jsonObj.optString("name");
				if(!name.isEmpty())
					event.setName(name);
				
				String start_date_string = jsonObj.optString("start_date");
				start_date_string = start_date_string.replace(":", "");
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HHmmssZ");
				if(!start_date_string.isEmpty()) {
					Date start_date = formatter.parse(start_date_string);
					event.setStartDate(start_date);
				}
				
				String end_date_string = jsonObj.optString("end_date");
				if(!end_date_string.equals("null")) {
					end_date_string = end_date_string.replace(":", "");
					Date end_date = formatter.parse(end_date_string);
					event.setEndDate(end_date);
				}
				
				String contact_email = jsonObj.optString("contact_email");
				if(!contact_email.isEmpty())
					event.setContactEmail(contact_email);
				
				String contact_name = jsonObj.optString("contact_name");
				if(!contact_name.isEmpty())
					event.setContactName(contact_name);
				
				String contact_number = jsonObj.optString("contact_number");
				if(!contact_number.isEmpty())
					event.setContactNumber(contact_number);
				
				String event_type = jsonObj.optString("event_type");
				if(!event_type.isEmpty())
					event.setEventType(event_type);
				
				String event_link = jsonObj.optString("event_link");
				if(!event_link.isEmpty())
					event.setEventLink(event_link);
				
				String details_link = jsonObj.optString("details_link");
				if(!details_link.isEmpty())
					event.setDetailsLink(details_link);
				
				String description = jsonObj.optString("description");
				if(!description.isEmpty())
					event.setDescription(description);
				
				int category = jsonObj.optInt("category");
				event.setCategory(category);
				
				int location = jsonObj.optInt("location");
				event.setLocation(location);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return event;
	}
}