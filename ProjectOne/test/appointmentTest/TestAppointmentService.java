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
	
	// Static Variables
	final String VALID_ID = "749115";
	final Date VALID_DATE = new Date();
	final String VALID_DESCRIPTION = "Better be retired";
	
	////////////////////////
	/// Add
	////////////////////////
	
	// Valid add in empty AppointmentService
	@Test
	public void testAdd_intoEmptyService_successfullyAdds() {
		// Arrange - build empty service
		VALID_DATE.setYear(VALID_DATE.getYear()+1901);
		Appointment validApp = new Appointment(VALID_ID, VALID_DATE, VALID_DESCRIPTION);
		List<Appointment> testList = new ArrayList<>();
		AppointmentService testService = new AppointmentService();
		
		// Act - add appointment to service
		testService.addAppointment(validApp);
		
		// Assert - the returned appointment from getAppointment is not validApp, but contains same information
		Assertions.assertEquals(validApp.getDescription(), testService.getAppointment(VALID_ID).getDescription());
		Assertions.assertEquals(validApp.getId(), testService.getAppointment(VALID_ID).getId());
		Assertions.assertEquals(validApp.getDate(), testService.getAppointment(VALID_ID).getDate());
		Assertions.assertNotEquals(validApp, testService.getAppointment(VALID_ID));
	}
	
	// Add null appointment
	@Test
	public void testAdd_withNullAppointment() {
		// Arrange - build empty service and null appointment
		AppointmentService testService = new AppointmentService();
		Appointment newApp = null;
		
		// Act & Assert - adding null appointment throws IllegalArgumentException
		Assertions.assertThrows(IllegalArgumentException.class, ()->testService.addAppointment(newApp));
	}
	
	// Valid add in populated AppointmentService
	@Test
	public void testAdd_uniqueIdIntoPopulatedService_successfullyAdds() {
		// Arrange - build populate service
		VALID_DATE.setYear(VALID_DATE.getYear()+1901);
		Appointment validApp = new Appointment(VALID_ID, VALID_DATE, VALID_DESCRIPTION);
		List<Appointment> testList = new ArrayList<>();
		testList.add(validApp);
		AppointmentService testService = new AppointmentService(testList);
		
		// Act - build new appointment and add to service
		final String newId = "109942";
		final Date newDate = new Date(2033, 2, 8);
		final String newDesc = "Meet Karen for lunch";
		Appointment newApp = new Appointment(newId, newDate, newDesc);
		testService.addAppointment(newApp);
		
		// Assert - Same details are added, but not same appointment
		Assertions.assertEquals(newApp.getDescription(), testService.getAppointment(newId).getDescription());
		Assertions.assertEquals(newApp.getId(), testService.getAppointment(newId).getId());
		Assertions.assertEquals(newApp.getDate(), testService.getAppointment(newId).getDate());
		Assertions.assertNotEquals(newApp, testService.getAppointment(newId));
	}
	
	// Add appointment with duplicate ID
	@Test
	public void testAdd_withDuplicatedId_throwsIllegalArgumentException() {
		// Arrange - build populated service
		VALID_DATE.setYear(VALID_DATE.getYear()+1901);
		Appointment validApp = new Appointment(VALID_ID, VALID_DATE, VALID_DESCRIPTION);
		List<Appointment> testList = new ArrayList<>();
		testList.add(validApp);
		AppointmentService testService = new AppointmentService(testList);
		
		// Act - build new appointment with duplicate id
		final Date newDate = new Date(2033, 2, 8);
		final String newDesc = "Meet Karen for lunch";
		Appointment newApp = new Appointment(VALID_ID, newDate, newDesc);
		
		// Assertion - Adding newApp throws IllegalArgumentException
		Assertions.assertThrows(IllegalArgumentException.class, ()-> testService.addAppointment(newApp));
	}
	
	// Add appointment with duplicate Date
	@Test
	public void testAdd_withDuplicatedDate_successfullyAdds() {
		// Arrange - build populated service
		VALID_DATE.setYear(VALID_DATE.getYear()+1901);
		Appointment validApp = new Appointment(VALID_ID, VALID_DATE, VALID_DESCRIPTION);
		List<Appointment> testList = new ArrayList<>();
		testList.add(validApp);
		AppointmentService testService = new AppointmentService(testList);
		
		// Act - build newApp and add to service
		final String newId = "109942";
		final String newDesc = "Meet Karen for lunch";
		Appointment newApp = new Appointment(newId, VALID_DATE, newDesc);
		testService.addAppointment(newApp);
		
		// Assert - newApp is return when using newApp's id in get method
		Assertions.assertEquals(newApp.getDescription(), testService.getAppointment(newId).getDescription());
	}
	
	// Add appointment with duplicate Description
	@Test
	public void testAdd_withDuplicatedDescription_successfullyAdds() {
		// Arrange - build populated service
		VALID_DATE.setYear(VALID_DATE.getYear()+1901);
		Appointment validApp = new Appointment(VALID_ID, VALID_DATE, VALID_DESCRIPTION);
		List<Appointment> testList = new ArrayList<>();
		testList.add(validApp);
		AppointmentService testService = new AppointmentService(testList);
		
		// Act - build newApp and add to service
		final String newId = "109942";
		final Date newDate = new Date(2033, 2, 8);
		Appointment newApp = new Appointment(newId, newDate, VALID_DESCRIPTION);
		testService.addAppointment(newApp);
		
		// Assert - newApp is return when using newApp's id in get method
		Assertions.assertEquals(newApp.getDescription(), testService.getAppointment(newId).getDescription());
	}
	
	////////////////////////
	/// Delete
	////////////////////////
	
	// Valid delete appointment
	@Test
	public void testDelete_withExistingAppointment_successfullyDeletes() {
		// Arrange - build populated service
		VALID_DATE.setYear(VALID_DATE.getYear()+1901);
		Appointment validApp = new Appointment(VALID_ID, VALID_DATE, VALID_DESCRIPTION);
		List<Appointment> testList = new ArrayList<>();
		testList.add(validApp);
		AppointmentService testService = new AppointmentService(testList);
		
		// Act - delete appointment
		testService.delete(VALID_ID);
		
		// Assertions - null is returned when searching for VALID_ID
		Assertions.assertNull(testService.getAppointment(VALID_ID));
	}
	
	// Delete appointment that doesn't exist
	@Test
	public void testDelete_withNonExistingAppointment_throwsNoSuchElementException() {
		// Arrange - build populated service
		VALID_DATE.setYear(VALID_DATE.getYear()+1901);
		Appointment validApp = new Appointment(VALID_ID, VALID_DATE, VALID_DESCRIPTION);
		List<Appointment> testList = new ArrayList<>();
		testList.add(validApp);
		AppointmentService testService = new AppointmentService(testList);
		
		// Act & Assert - throws NoSuchElementException when deleting an id that doesn't exist
		Assertions.assertThrows(NoSuchElementException.class, ()->testService.delete("902330441"));
	}
	
	// Delete appointment from empty list
	@Test
	public void testDelete_withEmptyService_throwsNoSuchElementException() {
		// Arrange - build empty service
		AppointmentService testService = new AppointmentService();
		
		// Act & Assert - throws IllegalArgumentException when deleting any id
		Assertions.assertThrows(NoSuchElementException.class, ()->testService.delete(VALID_ID));
	}
	
	// Delete null id
	@Test
	public void testDelete_withNullId_throwsIllegalArgumentException() {
		// Arrange - build populated service
		VALID_DATE.setYear(VALID_DATE.getYear()+1901);
		Appointment validApp = new Appointment(VALID_ID, VALID_DATE, VALID_DESCRIPTION);
		List<Appointment> testList = new ArrayList<>();
		testList.add(validApp);
		AppointmentService testService = new AppointmentService(testList);
		
		// Act & Assert - throws IllegalArgumentException when deleting a null value
		Assertions.assertThrows(IllegalArgumentException.class, ()->testService.delete(null));
	}
	// Delete empty id
	@Test
	public void testDelete_withEmptyId_throwsIllegalArgumentException() {
		// Arrange - build populated service
		VALID_DATE.setYear(VALID_DATE.getYear()+1901);
		Appointment validApp = new Appointment(VALID_ID, VALID_DATE, VALID_DESCRIPTION);
		List<Appointment> testList = new ArrayList<>();
		testList.add(validApp);
		AppointmentService testService = new AppointmentService(testList);
		
		// Act & Assert - throws IllegalArgumentException when deleting an empty value
		Assertions.assertThrows(IllegalArgumentException.class, ()->testService.delete(""));
	}
	
	////////////////////////
	/// Functionality
	////////////////////////
	
	// Delete appointment then add new appointment with same id
	@Test
	public void testFunctionality_deleteThenAddSameId_successfullyAdds() {
		// Arrange
		// build populated service
		VALID_DATE.setYear(VALID_DATE.getYear()+1901);
		Appointment validApp = new Appointment(VALID_ID, VALID_DATE, VALID_DESCRIPTION);
		List<Appointment> testList = new ArrayList<>();
		testList.add(validApp);
		AppointmentService testService = new AppointmentService(testList);
		// build new appointment with same id
		final Date newDate = new Date(2033, 2, 8);
		final String newDesc = "Meet Karen for lunch";
		Appointment newApp = new Appointment(VALID_ID, newDate, newDesc);
		
		
		// Act - delete old appointment from service, then add new appointment with same id
		testService.delete(VALID_ID);
		testService.addAppointment(newApp);
		
		// Assert - using id on get method returns newApp
		Assertions.assertEquals(newApp.getDescription(), testService.getAppointment(VALID_ID).getDescription());
		Assertions.assertEquals(newApp.getId(), testService.getAppointment(VALID_ID).getId());
		Assertions.assertEquals(newApp.getDate(), testService.getAppointment(VALID_ID).getDate());
		Assertions.assertNotEquals(newApp, testService.getAppointment(VALID_ID));
	}
	
	// Delete appointment then add same appointment
	@Test
	public void testFunctionality_deleteThanAddSameAppointment_successfullyAdds() {
		// Arrange - build populated service
		VALID_DATE.setYear(VALID_DATE.getYear()+1901);
		Appointment validApp = new Appointment(VALID_ID, VALID_DATE, VALID_DESCRIPTION);
		List<Appointment> testList = new ArrayList<>();
		testList.add(validApp);
		AppointmentService testService = new AppointmentService(testList);
		
		// Act - delete appointment, then add same appointment
		testService.delete(VALID_ID);
		testService.addAppointment(validApp);
		
		// Assert - using id on get method returns validApp
		Assertions.assertEquals(validApp.getDescription(), testService.getAppointment(VALID_ID).getDescription());
		Assertions.assertEquals(validApp.getId(), testService.getAppointment(VALID_ID).getId());
		Assertions.assertEquals(validApp.getDate(), testService.getAppointment(VALID_ID).getDate());
		Assertions.assertNotEquals(validApp, testService.getAppointment(VALID_ID));
	}
	
	
	
	
	

}
