package appointmentTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Appointment.Appointment;
import java.util.Date;


public class TestAppointment {

	final String VALID_ID = "37688";
	final Date VALID_DATE = new Date(2028, 7, 21);
	final String VALID_DESCRIPTION = "Super Descriptive";
	
	//@BeforeEach
	//public void setup() {
	//	VALID_DATE.setYear(2028);
	//	VALID_DATE.setDate(21);
	//	VALID_DATE.setMonth(7);
	//}
	
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
		Assertions.assertEquals(maxId, testAppointment.getId());
	}
	
	// Test More Than Max Characters
	@Test
	public void testId_withMoreThanMaximumCharacters_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Appointment("01234567890", VALID_DATE, VALID_DESCRIPTION));
	}
	
	// Test Min Characters

	@Test
	public void testId_withMinimumCharacters_successfullyBuilds() {
		final String minId = "4";
		Appointment testAppointment = new Appointment(minId, VALID_DATE, VALID_DESCRIPTION);
		Assertions.assertEquals(minId, testAppointment.getId());
	}
	// Test Null String
	@Test
	public void testId_withVoidString_throwsIllegalExceptionError() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->new Appointment(null, VALID_DATE, VALID_DESCRIPTION));
	}
	
	// Test Empty String
	@Test
	public void testId_withEmptyString_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->new Appointment("", VALID_DATE, VALID_DESCRIPTION));
	}
	
	////////////////////
	/// Date
	////////////////////
	
	// Test Null Date
	@Test
	public void testDate_withNullValue_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> new Appointment(VALID_ID, null, VALID_DESCRIPTION));
	}
	
	// Test Past Date
	@Test
	public void testDate_withDateInThePast_throwsIllegalArgumentException() {
		Date testDate = new Date(2000, 1, 1);
		Assertions.assertThrows(IllegalArgumentException.class, ()->new Appointment(VALID_ID, testDate, VALID_DESCRIPTION));
	}
	
	// Test Today's Date
	@Test
	public void testDate_withTodaysDate_successfullyBuilds() {
		Date testDate = new Date();
		testDate.setYear(testDate.getYear()+1900);
		Appointment testApp = new Appointment(VALID_ID, testDate, VALID_DESCRIPTION);
		Assertions.assertEquals(testDate, testApp.getDate());
	}
	
	////////////////////
	/// Description
	////////////////////
	
	// Test Max Characters
	@Test
	public void testDescription_withMaximumCharacters_successfullyBuilds() {
		final String maxDesc = "12345678911234567892123456789312345678941234567895";
		Appointment testApp = new Appointment(VALID_ID,VALID_DATE,maxDesc);
		Assertions.assertEquals(maxDesc, testApp.getDescription());
	}
	
	// Test More Than Max Characters
	@Test
	public void testDescription_withMoreThanMaximumCharacters_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> new Appointment(VALID_ID,VALID_DATE,"123456789112345678921234567893123456789412345678951"));
	}
	
	// Test Min Characters
	@Test
	public void testDescription_withMinimumCharacters_successfullyBuilds() {
		final String minDesc = "R";
		Appointment testApp = new Appointment(VALID_ID, VALID_DATE, minDesc);
		Assertions.assertEquals(minDesc, testApp.getDescription());
	}
	// Test Empty String
	@Test
	public void testDescription_withEmptyString_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> new Appointment(VALID_ID, VALID_DATE, ""));
	}
	
	// Test Null String
	@Test
	public void testDescription_withNullValue_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> new Appointment(VALID_ID, VALID_DATE, null));
	}

}
