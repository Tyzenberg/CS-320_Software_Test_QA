package Appointment;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;



public class AppointmentService {
	
	private List<Appointment> appointments;
	
	public AppointmentService() {
		appointments = new ArrayList<>();
	}
	
	public AppointmentService(List<Appointment> importList) {
		appointments = importList;
	}
	
	public Appointment getAppointment(String id) {
		Appointment foundApp = null;
		
		boolean appExists = false;
		for (Appointment currApp: appointments) {
				if (currApp.getId().equals(id)) {
					foundApp = currApp;
					appExists = true;
					break;
				}
		}
		
		if (appExists) {
			return foundApp;
		} else {
			return null;
		}
	}
	
	public void addAppointment(Appointment newApp) {
		if (newApp == null) {
			throw new IllegalArgumentException("Cannot add a null appointment");
		}
		
		if (this.getAppointment(newApp.getId()) != null) {
			throw new IllegalArgumentException("Cannot add an appointment with a duplicate id");
		}
			
		appointments.add(new Appointment(newApp));
	}
	
	public void delete(String id) {
		if (id == null) {
			throw new IllegalArgumentException("cannot delete a null id");
		}
		if (id.length() < 1) {
			throw new IllegalArgumentException("Cannot delete an empty id");
		}
		
		Appointment tempApp = this.getAppointment(id);
		if (tempApp == null) {
			throw new NoSuchElementException("Could not find an appointment with that id");
		}
		
		appointments.remove(tempApp);
	}

}
