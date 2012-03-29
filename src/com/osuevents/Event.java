/**
 * 
 */
package com.osuevents;

import java.util.Date;

/**
 * @author farhang
 *
 */
public class Event {
	private long event_id;
	private String name,
		contact_email,
		contact_name,
		contact_number,
		event_type,
		event_link,
		details_link,
		description;
	private Date start_date,
	end_date;
	private int category,
	location;
	private boolean status;
	
	public Event(long id) {
		event_id = id;
	}
	
	public long getEventId() {
		return this.event_id;
	}
	public String getEventName() {
		return this.name;
	}
	public String getEventContactEmail() {
		return this.contact_email;
	}
	public String getEventContactName() {
		return this.contact_name;
	}
	public String getEventContactNumber() {
		return this.contact_number;
	}
	public String getEventType() {
		return this.event_type;
	}
	public String getEventLink() {
		return this.event_link;
	}
	public String getEventDetailsLink() {
		return this.details_link;
	}
	public String getEventDescription() {
		return this.description;
	}
	public Date getStartDate() {
		return this.start_date;
	}
	public Date getEndDate() {
		return this.end_date;
	}
	public int getEventCategory() {
		return this.category;
	}
	public int getEventLocation() {
		return this.location;
	}
	public boolean getEventStatus() {
		return this.status;
	}
	
	public void setName(String event_name) {
		this.name = event_name;
	}
	public void setContactName(String event_contact_name) {
		this.contact_name = event_contact_name;
	}
	public void setContactEmail(String event_contact_email) {
		this.contact_email = event_contact_email;
	}
	public void setContactNumber(String event_contact_number) {
		this.contact_number = event_contact_number;
	}
	public void setEventType(String event_event_type) {
		this.event_type = event_event_type;
	}
	public void setEventLink(String event_event_link) {
		this.event_link = event_event_link;
	}
	public void setDetailsLink(String event_details_link) {
		this.details_link = event_details_link;
	}
	public void setDescription(String event_description) {
		this.description = event_description;
	}
	public void setStartDate(Date event_start_date) {
		this.start_date = event_start_date;
	}
	public void setEndDate(Date event_end_date) {
		this.end_date = event_end_date;
	}
	public void setCategory(int event_category) {
		this.category = event_category;
	}
	public void setLocation(int event_location) {
		this.location = event_location;
	}
	public void setStatus(boolean event_status) {
		this.status = event_status;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
