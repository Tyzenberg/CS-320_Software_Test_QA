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
	
	public Appointment get(String id) {
		Appointment foundApp = null;
		
		for (Appointment currApp: appointments) {
				if (currApp.getId().equals(id)) {
					foundApp = currApp;
					break;
				}
		}
		
		return foundApp;
	}
	
	public void add(Appointment newApp) {
		if (newApp == null) {
			throw new IllegalArgumentException("Cannot add a null appointment");
		}
		
		if (this.get(newApp.getId()) != null) {
			throw new IllegalArgumentException("Cannot add an appointment with a duplicate id");
		}
		
		appointments.add(newApp);	
	}
	
	public void delete(String id) {
		if (id == null) {
			throw new IllegalArgumentException("cannot delete a null id");
		}
		if (id.length() < 1) {
			throw new IllegalArgumentException("Cannot delete an empty id");
		}
		
		Appointment tempApp = this.get(id);
		if (tempApp == null) {
			throw new NoSuchElementException("Could not find an appointment with that id");
		}
		
		appointments.remove(tempApp);
	}

}
