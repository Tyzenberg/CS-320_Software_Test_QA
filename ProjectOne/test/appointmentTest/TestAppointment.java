package appointmentTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Appointment.Appointment;
import java.util.Date;


public class TestAppointment {

	final String VALID_ID = "37688";
	final Date VALID_DATE = new Date(10/05/2032);
	final String VALID_DESCRIPTION = "Super Descriptive";
	Date testDate = new Date(null);
	
	
	////////////////////
	/// Constructor
	////////////////////
	
	// Test Valid Constructor
	@Test
	public void testConstructor_withValidEntries_successfullyBuild() {
		Appointment testAppointment = new Appointment(VALID_ID, VALID_DATE, VALID_DESCRIPTION);
		
		Assertions.assertEquals(VALID_ID, testAppointment.getId());
		Assertions.assertEquals(VALID_DATE, testAppointment.getDate());
		Assertions.assertEquals(VALID_DESCRIPTION, testAppointment.getDescription());
	}
	
	////////////////////
	/// ID
	////////////////////
	
	// Test Max Characters
	@Test
	public void testId_withMaximumCharacters_successfullyBuilds() {
		final String maxId = "0123456789";
		Appointment testAppointment = new Appointment(maxId, VALID_DATE, VALID_DESCRIPTION);
		Assertions.assertEquals(maxId, Appointment.getId());
	}
	
	// Test More Than Max Characters
	@Test
	public void testId_withMoreThanMaximumCharacters_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Appointment("01234567890", VALID_DATE, VALID_DESCRIPTION));
	}
	
	// Test Min Characters
	
	// Test Null String
	
	// Test Empty String
	
	////////////////////
	/// Date
	////////////////////
	
	// Test Empty Date
	
	// Test Null Date
	
	// Test Past Date
	
	////////////////////
	/// Description
	////////////////////
	
	// Test Max Characters
	
	// Test More Than Max Characters
	
	// Test Min Characters
	
	// Test Empty String
	
	// Test Null String

}
