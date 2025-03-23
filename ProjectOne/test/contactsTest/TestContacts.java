package contactsTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contacts.Contact;

public class TestContacts {
	
	private final String VALID_ID = "12345";
	private final String VALID_NAME = "Joe";
	private final String MAX_NAME = "Tenletters";
	private final String MIN_NAME = "D";
	private final String VALID_PHONE = "0123456789";
	private final String VALID_ADDRESS = "30 Nice Place";
	
	//////////////////////
	/// Test Constructors
	//////////////////////
	
	@Test
	public void testConstructor_validInputs_IsSuccessful() {
		String[] inputs = {VALID_ID, VALID_NAME, VALID_NAME, VALID_PHONE, VALID_ADDRESS};
		Contact testContact = new Contact(inputs[0], inputs[1], inputs[2], inputs[3], inputs[4]);
		
		String[] outputs = new String[5];
		outputs[0] = testContact.getID();
		outputs[1] = testContact.getFirstName();
		outputs[2] = testContact.getLastName();
		outputs[3] = testContact.getNumber();
		outputs[4] = testContact.getAddress();
		
		Assertions.assertArrayEquals(inputs, outputs);
	}
	
	//////////////////////
	/// Test ID 
	//////////////////////
	
	// Not longer than 10 characters
	@Test
	public void testId_withMoreThanMaxCharacters_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("01234567890", VALID_NAME, VALID_NAME, VALID_PHONE, VALID_ADDRESS));
	}

	
	// max characters
	@Test
	public void testId_withMaxValid_IsSuccessful() {
		final String MAX_ID = "0123456789";
		
		Contact testContact = new Contact(MAX_ID, VALID_NAME, VALID_NAME, VALID_PHONE, VALID_ADDRESS);
		Assertions.assertEquals(MAX_ID, testContact.getID());
	}
	
	// min characters
	@Test
	public void testId_withMinValid_IsSuccessful() {
		Contact testContact = new Contact(VALID_ID, VALID_NAME, VALID_NAME, VALID_PHONE, VALID_ADDRESS);
		Assertions.assertEquals(VALID_ID, testContact.getID());
	}
	
	// Not null
	@Test
	public void testId_withNullValue_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(null, VALID_NAME, VALID_NAME, VALID_PHONE, VALID_ADDRESS));
	}
	
	// Not empty
	@Test
	public void testId_withEmptyString_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("", VALID_NAME, VALID_NAME, VALID_PHONE, VALID_ADDRESS));
	}
	
	// Not Letters
	@Test
	public void testID_withLetters_ThrowsIllegalArgumentException() {
		String testId = "23s21";
		Assertions.assertThrows(IllegalArgumentException.class, ()-> new Contact(testId, VALID_NAME, VALID_NAME, VALID_PHONE, VALID_ADDRESS));
	}
	
	// Not special characters
	@Test
	public void testID_withSpecialCharacters_ThrowsIllegalArgumentException() {
		String testId = "12#45";
		Assertions.assertThrows(IllegalArgumentException.class, ()-> new Contact(testId, VALID_NAME, VALID_NAME, VALID_PHONE, VALID_ADDRESS));
	}
	
	// Not updatable TODO
	
	
	//////////////////////
	/// Test firstName 
	//////////////////////	
	
	// max characters
	@Test
	public void testFirstName_withMaxCharacters_IsSuccessful() {
		Contact testContact = new Contact(VALID_ID, MAX_NAME, VALID_NAME, VALID_PHONE, VALID_ADDRESS);
		Assertions.assertEquals(MAX_NAME, testContact.getFirstName());
	}
	
	// min characters
	@Test
	public void testFirstName_withMinCharacters_IsSuccessful() {
		Contact testContact = new Contact(VALID_ID, MIN_NAME, VALID_NAME, VALID_PHONE, VALID_ADDRESS);
		Assertions.assertEquals(MIN_NAME, testContact.getFirstName());
		
	}
	
	// not numbers
	@Test
	public void testFirstName_withNumbers_ThrowsIllegalArgumentException() {
		
		final String firstName = "Chr1s";		
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, firstName, VALID_NAME, VALID_PHONE, VALID_ADDRESS));
	}
	
	// not special characters
	@Test
	public void testFirstName_withSpecialCharacters_ThrowsIllegalArgumentException() {
		
	final String firstName = "P@ul";		
	Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, firstName, VALID_NAME, VALID_PHONE, VALID_ADDRESS));
	}
	
	// Not longer than 10 characters
	@Test
	public void testFirstName_withMoreThanMaxCharacters_ThrowsIllegalArgumentException() {
		String firstName = MAX_NAME + "a";
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, firstName, VALID_NAME, VALID_PHONE, VALID_ADDRESS));
	}
	
	// not null
	@Test
	public void testFirstName_withNullValue_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, null, VALID_NAME, VALID_PHONE, VALID_ADDRESS));	
	}
	
	// not empty
	@Test
	public void testFirstName_withEmptyString_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, "", VALID_NAME, VALID_PHONE, VALID_ADDRESS));
	}
	
	//////////////////////
	/// Test lastName
	//////////////////////
	
	// max characters
	@Test
	public void testLastName_withMaxCharacters_IsSuccessful() {
		Contact testContact = new Contact(VALID_ID, VALID_NAME, MAX_NAME, VALID_PHONE, VALID_ADDRESS);
		Assertions.assertEquals(MAX_NAME, testContact.getLastName());
	}
	
	// min characters
	@Test
	public void testLastName_withMinCharacters_IsSuccessful() {
		Contact testContact = new Contact(VALID_ID, VALID_NAME, MIN_NAME, VALID_PHONE, VALID_ADDRESS);
		Assertions.assertEquals(MIN_NAME, testContact.getLastName());
	}
	
	// not numbers
	@Test
	public void testLastName_withNumbers_ThrowsIllegalArgumentException() {
		String lastName = "Chr1s";
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, lastName, VALID_PHONE, VALID_ADDRESS));
	}
	
	// not special characters
	@Test
	public void testLastName_withSpecialCharacters_ThrowsIllegalArgumentException() {
		String lastName = "P@ul";
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, lastName, VALID_PHONE, VALID_ADDRESS));	
	}
	
	// Not longer than 10 characters
	@Test
	public void testLastName_withMoreThanMaxCharacters_ThrowsIllegalArgumentException() {
		String lastName = MAX_NAME + "a";
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, lastName, VALID_PHONE, VALID_ADDRESS));
	}
	
	// not null
	@Test
	public void testLastName_withNullValue_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, null, VALID_PHONE, VALID_ADDRESS));
	}
	
	// not empty
	@Test
	public void testLastName_withEmptyString_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, "", VALID_PHONE, VALID_ADDRESS));
	}
	
	//////////////////////
	/// Test Phone
	//////////////////////
		
	// not letters
	@Test
	public void testPhone_withLetters_ThrowsIllegalArgumentException() {
		String phone = "01234s6789";
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, VALID_NAME, phone, VALID_ADDRESS));
	}
	
	// not special characters
	@Test
	public void testPhone_withSpecialCharacters_ThrowsIllegalArgumentException() {
		String phone = "01234$6789";
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, VALID_NAME, phone, VALID_ADDRESS));
	}
	
	// not longer than 10 digits
	@Test
	public void testPhone_withMoreThanMaxNumbers_ThrowsIllegalArgumentException() {
		String phone = VALID_PHONE + "1";
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, VALID_NAME, phone, VALID_ADDRESS));
	}
	
	// not less than 10 digits
	@Test
	public void testPhone_withLessThanMinCharacters_ThrowsIllegalArgumentException() {
		String phone = "123456789";
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, VALID_NAME, phone, VALID_ADDRESS));
	}
	
	// not null
	@Test
	public void testPhone_withNull_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, VALID_NAME, null, VALID_ADDRESS));
	}
	
	//////////////////////
	/// Test address
	//////////////////////
	
	// max characters
	@Test
	public void testAddress_withMaxCharacters_IsSuccessful() {
		String address = "12345678 This is 30 characters";
		Contact testContact = new Contact(VALID_ID, VALID_NAME, VALID_NAME, VALID_PHONE, address);
		
		Assertions.assertEquals(address, testContact.getAddress());
	}
	
	// min characters
	@Test
	public void testAddress_withMinCharacters_IsSuccessful() {
		String address = "1";
		Contact testContact = new Contact(VALID_ID, VALID_NAME, VALID_NAME, VALID_PHONE, address);
		
		Assertions.assertEquals(address, testContact.getAddress());
	}
	
	// Not longer than 30 characters
	@Test
	public void testAddress_withMoreThanMaxCharacters_ThrowsIllegalArgumentException() {
		String address = "123456789 This is 31 characters";
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, VALID_NAME, VALID_PHONE, address));
	}
	
	// not null
	@Test
	public void testAddress_withNullValue_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, VALID_NAME, VALID_PHONE, null));
	}
	
	// not empty
	@Test
	public void testAddress_withEmptyString_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, VALID_NAME, VALID_PHONE, ""));
	}
}
