package appointmentTest;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Appointment.AppointmentService;
import Tasks.Task;
import Appointment.Appointment;

public class TestAppointmentService {
	
	final String VALID_ID = "749115";
	final Date VALID_DATE = new Date(2057, 10, 19);
	final String VALID_DESCRIPTION = "Better be retired";
	
	Appointment validApp = new Appointment(VALID_ID, VALID_DATE, VALID_DESCRIPTION);
	List<Appointment> testList = new ArrayList<>();
	
		
	////////////////////////
	/// Add
	////////////////////////
	
	// Valid add in empty AppointmentService
	@Test
	public void testAdd_intoEmptyService_successfullyAdds() {
		AppointmentService testService = new AppointmentService();
		testService.add(validApp);
		Assertions.assertEquals(VALID_ID, testService.get(VALID_ID).getId());
		Assertions.assertEquals(VALID_DATE, testService.get(VALID_ID).getDate());
		Assertions.assertEquals(VALID_DESCRIPTION, testService.get(VALID_ID).getDescription());
	}
	
	// Add null appointment
	@Test
	public void testAdd_withNullAppointment() {
		AppointmentService testService = new AppointmentService();
		Appointment newApp = null;
		Assertions.assertThrows(IllegalArgumentException.class, ()->testService.add(newApp));
	}
	
	// Valid add in populated AppointmentService
	@Test
	public void testAdd_uniqueIdIntoPopulatedService_successfullyAdds() {
		testList.add(validApp);
		AppointmentService testService = new AppointmentService(testList);
		
		final String newId = "109942";
		final Date newDate = new Date(2033, 2, 8);
		final String newDesc = "Meet Karen for lunch";
		Appointment newApp = new Appointment(newId, newDate, newDesc);
		
		testService.add(newApp);
		
		Assertions.assertEquals(newDesc, testService.get(newId).getDescription());
		Assertions.assertEquals(VALID_DESCRIPTION, testService.get(VALID_ID).getDescription());
	}
	
	// Add appointment with duplicate ID
	@Test
	public void testAdd_withDuplicatedId_throwsIllegalArgumentException() {
		testList.add(validApp);
		AppointmentService testService = new AppointmentService(testList);
		
		final Date newDate = new Date(2033, 2, 8);
		final String newDesc = "Meet Karen for lunch";
		Appointment newApp = new Appointment(VALID_ID, newDate, newDesc);
	
		Assertions.assertThrows(IllegalArgumentException.class, ()-> testService.add(newApp));
	}
	
	// Add appointment with duplicate Date
	@Test
	public void testAdd_withDuplicatedDate_successfullyAdds() {
		testList.add(validApp);
		AppointmentService testService = new AppointmentService(testList);
		
		final String newId = "109942";
		final String newDesc = "Meet Karen for lunch";
		Appointment newApp = new Appointment(newId, VALID_DATE, newDesc);
			
		testService.add(newApp);
		
		Assertions.assertEquals(newDesc, testService.get(newId).getDescription());
		Assertions.assertEquals(VALID_DESCRIPTION, testService.get(VALID_ID).getDescription());
	}
	
	// Add appointment with duplicate Description
	@Test
	public void testAdd_withDuplicatedDescription_successfullyAdds() {
		testList.add(validApp);
		AppointmentService testService = new AppointmentService(testList);
		
		final String newId = "109942";
		final Date newDate = new Date(2033, 2, 8);
		Appointment newApp = new Appointment(newId, newDate, VALID_DESCRIPTION);
		
		testService.add(newApp);
		
		Assertions.assertEquals(newDate, testService.get(newId).getDate());
		Assertions.assertEquals(VALID_DATE, testService.get(VALID_ID).getDate());
	}
	
	
	////////////////////////
	/// Delete
	////////////////////////
	
	// Valid delete appointment
	@Test
	public void testDelete_withExistingAppointment_successfullyDeletes() {
		testList.add(validApp);
		AppointmentService testService = new AppointmentService(testList);
		
		testService.delete(VALID_ID);
		
		Assertions.assertNull(testService.get(VALID_ID));
	}
	
	// Delete appointment that doesn't exist
	@Test
	public void testDelete_withNonExistingAppointment_throwsNoSuchElementException() {
		testList.add(validApp);
		AppointmentService testService = new AppointmentService(testList);
		
		Assertions.assertThrows(NoSuchElementException.class, ()->testService.delete("902330441"));
	}
	
	// Delete appointment from empty list
	@Test
	public void testDelete_withEmptyService_throwsNoSuchElementException() {
		AppointmentService testService = new AppointmentService();
		Assertions.assertThrows(NoSuchElementException.class, ()->testService.delete(VALID_ID));
	}
	
	// Delete null id
	@Test
	public void testDelete_withNullId_throwsIllegalArgumentException() {
		AppointmentService testService = new AppointmentService();
		Assertions.assertThrows(IllegalArgumentException.class, ()->testService.delete(null));
	}
	// Delete empty id
	@Test
	public void testDelete_withEmptyId_throwsIllegalArgumentException() {
		AppointmentService testService = new AppointmentService();
		Assertions.assertThrows(IllegalArgumentException.class, ()->testService.delete(""));
	}
	
	////////////////////////
	/// Functionality
	////////////////////////
	
	// Delete appointment then add new appointment with same id
	@Test
	public void testFunctionality_deleteThenAddSameId_successfullyAdds() {
		testList.add(validApp);
		AppointmentService testService = new AppointmentService(testList);
		
		final Date newDate = new Date(2033, 2, 8);
		final String newDesc = "Meet Karen for lunch";
		Appointment newApp = new Appointment(VALID_ID, newDate, newDesc);
			
		testService.delete(VALID_ID);
		testService.add(newApp);
		
		Assertions.assertEquals(newDesc, testService.get(VALID_ID).getDescription());
		
	}
	
	// Delete appointment then add same appointment
	@Test
	public void testFunctionality_deleteThanAddSameAppointment_successfullyAdds() {
		testList.add(validApp);
		AppointmentService testService = new AppointmentService(testList);
		
		testService.delete(VALID_ID);
		testService.add(validApp);
		
		Assertions.assertEquals(VALID_DESCRIPTION, testService.get(VALID_ID).getDescription());
	}
	
	
	
	
	

}
