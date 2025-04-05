package Appointment;

import java.util.Date;

public class Appointment {
	
	private String id;
	private Date date;
	private String description;
	
	public Appointment(String id, Date date, String description) {
		this.setId(id);
		this.setDate(date);
		this.setDescription(description);
	}
	
	private void setId(String id) {
		if (id == null) {
			throw new IllegalArgumentException("Appointment id cannot be null");
		} else if (id.length() < 1 ) {
			throw new IllegalArgumentException("Appoint id cannot be blank");
		} else if (id.length() > 10 ) {
			throw new IllegalArgumentException("Appointment id cannot be more than 10 characters");
		}
		
		this.id = id;
	}
	
	public void setDate(Date date) {
		if (date == null) {
			throw new IllegalArgumentException("Appointment date cannot be null");
		}
		
		Date currDate = new Date();
		currDate.setYear(currDate.getYear()+1900);
		
		if (date.before(currDate)) {
			throw new IllegalArgumentException("Appointment date cannot be set before today");
		}
		
		this.date = date;
	}
	
	public void setDescription(String description) {
		if (description == null) {
			throw new IllegalArgumentException("Appointment description cannot be null");
		} else if (description.length() < 1) {
			throw new IllegalArgumentException("Appointment description cannot be empty");
		} else if (description.length() > 50 ) {
			throw new IllegalArgumentException("Appointment description cannot be more than 50 characters");
		}
		
		this.description = description;
	}
	
	public String getId() {
		return this.id;
	}
	
	public Date getDate() {
		return this.date;
	}
	public String getDescription() {
		return this.description;
	}

}
