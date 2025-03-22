package contactsTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contacts.Contact;
import edu.snhu.tlever.schools.School;

public class TestContacts {
	
	private final String VALID_ID = "1";
	private final String MAX_NAME = "Tenletters";
	private final String MIN_NAME = "D";
	private final String VALID_PHONE = "0123456789";
	
	//////////////////////
	/// Test ID 
	//////////////////////
	
	// Not longer than 10 characters
	@Test
	public void testId_withMoreThanMaxCharacters_ThrowsIllegalArgumentException() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("01234567890"));
	}

	
	// max characters
	@Test
	public void testId_withMaxValid_IsSuccessful() {
		final String MAX_ID = "0123456789";
		
		Contact testContact = new Contact(MAX_ID);
		
		Assertions.assertEquals(MAX_ID, testContact.getID());
	}
	
	// min characters
	@Test
	public void testId_withMinValid_IsSuccessful() {
		Contact testContact = new Contact(VALID_ID);
		
		Assertions.assertEquals(VALID_ID, testContact.getID());
	}
	
	// Not null
	@Test
	public void testId_withNullValue_ThrowsIllegalArgumentException() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(null));
		
	}
	
	// Not empty
	@Test
	public void testId_withEmptyString_ThrowsIllegalArgumentException() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> new School(""));
		
	}
	
	// Not updatable
	
	
	//////////////////////
	/// Test firstName 
	//////////////////////	
	
	// max characters
	@Test
	public void testFirstName_withMaxCharacters_IsSuccessful() {
		
		Contact testContact = new Contact(VALID_ID);
		
		testContact.setFirstName(MAX_NAME);
				
		Assertions.assertEquals(MAX_NAME, testContact.getFirstName());
	}
	
	// min characters
	@Test
	public void testFirstName_withMinCharacters_IsSuccessful() {
		
	}
	
	// not numbers
	@Test
	public void testFirstName_withNumbers_ThrowsIllegalArgumentException() {
		
	}
	
	// not special characters
	@Test
	public void testFirstName_withSpecialCharacters_ThrowsIllegalArgumentException() {
		
	}
	
	// Not longer than 10 characters
	@Test
	public void testFirstName_withMoreThanMaxCharacters_ThrowsIllegalArgumentException() {
		
	}
	
	// not null
	@Test
	public void testFirstName_withNullValue_ThrowsIllegalArgumentException() {
		
	}
	
	// not empty
	@Test
	public void testFirstName_withEmptyString_ThrowsIllegalArgumentException() {
		
	}
	
	//////////////////////
	/// Test lastName
	//////////////////////
	
	// max characters
	@Test
	public void testLastName_withMaxCharacters_IsSuccessful() {
		
	}
	
	// min characters
	@Test
	public void testLastName_withMinCharacters_IsSuccessful() {
		
	}
	
	// not numbers
	@Test
	public void testLastName_withNumbers_ThrowsIllegalArgumentException() {
		
	}
	
	// not special characters
	@Test
	public void testLastName_withSpecialCharacters_ThrowsIllegalArgumentException() {
		
	}
	
	// Not longer than 10 characters
	@Test
	public void testLastName_withMoreThanMaxCharacters_ThrowsIllegalArgumentException() {
		
	}
	
	// not null
	@Test
	public void testLastName_withNullValue_ThrowsIllegalArgumentException() {
		
	}
	
	// not empty
	@Test
	public void testLastName_withEmptyString_ThrowsIllegalArgumentException() {
		
	}
	
	//////////////////////
	/// Test Number
	//////////////////////
	
	// valid number
	
	// not letters
	
	// not special characters
	
	// not longer than 10 digits
	
	// not less than 10 digits
	
	// not null
	
	//////////////////////
	/// Test address
	//////////////////////
	
	// max characters
	
	// min characters
	
	// Not longer than 30 characters
	
	// not null
	
	// not empty
}
