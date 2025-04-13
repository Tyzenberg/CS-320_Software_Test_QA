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
	
	// TEST CONSTRUCTOR WITH FULL VALID INPUTS
	// validate constructor successfully populates all fields
	@Test
	public void testConstructor_fullValidInputs_IsSuccessful() {
		String[] inputs = {VALID_ID, VALID_NAME, VALID_NAME, VALID_PHONE, VALID_ADDRESS};
		Contact testContact = new Contact(inputs[0], inputs[1], inputs[2], inputs[3], inputs[4]);
		
		String[] outputs = new String[5];
		outputs[0] = testContact.getID();
		outputs[1] = testContact.getFirstName();
		outputs[2] = testContact.getLastName();
		outputs[3] = testContact.getPhone();
		outputs[4] = testContact.getAddress();
		
		Assertions.assertArrayEquals(inputs, outputs);
	}
	
	// TEST CONSTRUCTOR WITH NULL Contact
	@Test
	public void testConstructors_withNullContact_throwsNullPointerException() {
		Assertions.assertThrows(NullPointerException.class, ()-> new Contact(null));
	}
	
	// TEST CONSTRUCTOR WITH VALID CONTACT
	@Test
	public void testConstructors_withValidContact_successfullyCopiesContact() {
		Contact validContact = new Contact(VALID_ID, VALID_NAME, VALID_NAME, VALID_PHONE, VALID_ADDRESS);
		Contact copiedContact = new Contact(validContact);
		
		Assertions.assertNotEquals(validContact, copiedContact);
		Assertions.assertEquals(validContact.getAddress(), copiedContact.getAddress());
		Assertions.assertEquals(validContact.getFirstName(), copiedContact.getFirstName());
		Assertions.assertEquals(validContact.getLastName(), copiedContact.getLastName());
		Assertions.assertEquals(validContact.getID(), copiedContact.getID());
		Assertions.assertEquals(validContact.getPhone(), copiedContact.getPhone());
	}
	
	//////////////////////
	/// Test ID 
	//////////////////////
	
	// TEST ID WITH MORE THAN MAXIMUM CHARACTERS
	@Test
	public void testId_withMoreThanMaxCharacters_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("01234567890", VALID_NAME, VALID_NAME, VALID_PHONE, VALID_ADDRESS));
	}

	
	// TEST ID WITH MAXIUM CHARACTERS
	@Test
	public void testId_withMaxValid_IsSuccessful() {
		final String MAX_ID = "0123456789";
		Contact testContact = new Contact(MAX_ID, VALID_NAME, VALID_NAME, VALID_PHONE, VALID_ADDRESS);
		Assertions.assertEquals(MAX_ID, testContact.getID());
	}
	
	// TEST ID WITH MINIMUM CHARACTERS
	@Test
	public void testId_withMinValid_IsSuccessful() {
		final String MIN_ID = "0";
		Contact testContact = new Contact(MIN_ID, VALID_NAME, VALID_NAME, VALID_PHONE, VALID_ADDRESS);
		Assertions.assertEquals(MIN_ID, testContact.getID());
	}
	
	// TEST ID WITH NULL
	@Test
	public void testId_withNullValue_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(null, VALID_NAME, VALID_NAME, VALID_PHONE, VALID_ADDRESS));
	}
	
	// TEST ID WITH EMPTY STRING
	@Test
	public void testId_withEmptyString_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("", VALID_NAME, VALID_NAME, VALID_PHONE, VALID_ADDRESS));
	}
	
	// TEST ID WITH LETTER
	@Test
	public void testID_withLetters_ThrowsIllegalArgumentException() {
		String testId = "23s21";
		Assertions.assertThrows(IllegalArgumentException.class, ()-> new Contact(testId, VALID_NAME, VALID_NAME, VALID_PHONE, VALID_ADDRESS));
	}
	
	// TEST ID WITH SPECIAL CHARACTER
	@Test
	public void testID_withSpecialCharacters_ThrowsIllegalArgumentException() {
		String testId = "12#45";
		Assertions.assertThrows(IllegalArgumentException.class, ()-> new Contact(testId, VALID_NAME, VALID_NAME, VALID_PHONE, VALID_ADDRESS));
	}
	
	
	//////////////////////
	/// Test firstName 
	//////////////////////	
	
	// TEST FIRSTNAME SETTER WITH MAXIMUM CHARACTERS
	@Test
	public void testFirstName_withMaxCharacters_IsSuccessful() {
		Contact testContact = new Contact(VALID_ID, MAX_NAME, VALID_NAME, VALID_PHONE, VALID_ADDRESS);
		Assertions.assertEquals(MAX_NAME, testContact.getFirstName());
	}
	
	// TEST FIRSTNAME SETTER WITH MINIMUM CHARACTERS
	@Test
	public void testFirstName_withMinCharacters_IsSuccessful() {
		Contact testContact = new Contact(VALID_ID, MIN_NAME, VALID_NAME, VALID_PHONE, VALID_ADDRESS);
		Assertions.assertEquals(MIN_NAME, testContact.getFirstName());
	}
	
	// TEST FIRSTNAME SETTER WITH A NUMBER
	@Test
	public void testFirstName_withNumbers_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, "Chr1s", VALID_NAME, VALID_PHONE, VALID_ADDRESS));
	}
	
	// TEST FIRSTNAME SETTER WITH A SPECIAL CHARACTER
	@Test
	public void testFirstName_withSpecialCharacters_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, "P@ul", VALID_NAME, VALID_PHONE, VALID_ADDRESS));
	}
	
	// TEST FIRSTNAME SETTER WITH MORE THAN MAXIMUM CHARACTERS
	@Test
	public void testFirstName_withMoreThanMaxCharacters_ThrowsIllegalArgumentException() {
		final String firstName = MAX_NAME + "a";
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, firstName, VALID_NAME, VALID_PHONE, VALID_ADDRESS));
	}
	
	// TEST FIRSTNAME SETTER WITH NULL
	@Test
	public void testFirstName_withNullValue_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, null, VALID_NAME, VALID_PHONE, VALID_ADDRESS));	
	}
	
	// TEST FIRSTNAME SETTER WITH EMPTY STRING
	@Test
	public void testFirstName_withEmptyString_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, "", VALID_NAME, VALID_PHONE, VALID_ADDRESS));
	}
	
	//////////////////////
	/// Test lastName
	//////////////////////
	
	// TEST LASTNAME SETTER WITH MAXIMUM CHARACTERS
	@Test
	public void testLastName_withMaxCharacters_IsSuccessful() {
		Contact testContact = new Contact(VALID_ID, VALID_NAME, MAX_NAME, VALID_PHONE, VALID_ADDRESS);
		Assertions.assertEquals(MAX_NAME, testContact.getLastName());
	}
	
	// TEST LASTNAME SETTER WITH MINIMUM CHARACTERS
	@Test
	public void testLastName_withMinCharacters_IsSuccessful() {
		Contact testContact = new Contact(VALID_ID, VALID_NAME, MIN_NAME, VALID_PHONE, VALID_ADDRESS);
		Assertions.assertEquals(MIN_NAME, testContact.getLastName());
	}
	
	// TEST LASTNAME SETTER WITH A NUMBER
	@Test
	public void testLastName_withNumbers_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, "Chr1s", VALID_PHONE, VALID_ADDRESS));
	}
	
	// TEST LASTNAME SETTER WITH A SPECIAL CHARACTER
	@Test
	public void testLastName_withSpecialCharacters_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, "P@ul", VALID_PHONE, VALID_ADDRESS));	
	}
	
	// TEST LASTNAME SETTER WITH MORE THAN MAXIMUM CHARACTERS
	@Test
	public void testLastName_withMoreThanMaxCharacters_ThrowsIllegalArgumentException() {
		String lastName = MAX_NAME + "a";
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, lastName, VALID_PHONE, VALID_ADDRESS));
	}
	
	// TEST LASTNAME SETTER WITH NULL
	@Test
	public void testLastName_withNullValue_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, null, VALID_PHONE, VALID_ADDRESS));
	}
	
	// TEST LASTNAME SETTER WITH EMPTY STRING
	@Test
	public void testLastName_withEmptyString_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, "", VALID_PHONE, VALID_ADDRESS));
	}
	
	//////////////////////
	/// Test Phone
	//////////////////////
	
	// TEST PHONE SETTER WITH A LETTER
	@Test
	public void testPhone_withLetters_ThrowsIllegalArgumentException() {
		String phone = "01234s6789";
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, VALID_NAME, phone, VALID_ADDRESS));
	}
	
	// TEST PHONE SETTER WITH A SPECIAL CHARACTER
	@Test
	public void testPhone_withSpecialCharacters_ThrowsIllegalArgumentException() {
		String phone = "01234$6789";
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, VALID_NAME, phone, VALID_ADDRESS));
	}
	
	// TEST PHONE SETTER WITH MORE THAN 10 CHARACTERS
	@Test
	public void testPhone_withMoreThanMaxNumbers_ThrowsIllegalArgumentException() {
		String phone = VALID_PHONE + "1";
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, VALID_NAME, phone, VALID_ADDRESS));
	}
	
	// TEST PHONE SETTER WITH LESS THAN 10 CHARACTERS
	@Test
	public void testPhone_withLessThanMinCharacters_ThrowsIllegalArgumentException() {
		String phone = "123456789";
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, VALID_NAME, phone, VALID_ADDRESS));
	}
	
	// TEST PHONE SETTER WITH NULL
	@Test
	public void testPhone_withNull_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, VALID_NAME, null, VALID_ADDRESS));
	}
	
	//////////////////////
	/// Test address
	//////////////////////
	
	// TEST ADDRESS SETTER WITH MAXIMUM CHARACTERS
	@Test
	public void testAddress_withMaxCharacters_IsSuccessful() {
		String address = "12345678 This is 30 characters";
		Contact testContact = new Contact(VALID_ID, VALID_NAME, VALID_NAME, VALID_PHONE, address);
		Assertions.assertEquals(address, testContact.getAddress());
	}
	
	// TEST ADDRESS SETTER WITH 1 CHARACTER
	@Test
	public void testAddress_withMinCharacters_IsSuccessful() {
		String address = "1";
		Contact testContact = new Contact(VALID_ID, VALID_NAME, VALID_NAME, VALID_PHONE, address);
		Assertions.assertEquals(address, testContact.getAddress());
	}
	
	// TEST ADDRESS SETTER WITH MORE THAN MAXIMUM CHARACTERS
	@Test
	public void testAddress_withMoreThanMaxCharacters_ThrowsIllegalArgumentException() {
		String address = "123456789 This is 31 characters";
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, VALID_NAME, VALID_PHONE, address));
	}
	
	// TEST ADDRESS SETTER WITH NUL
	@Test
	public void testAddress_withNullValue_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, VALID_NAME, VALID_PHONE, null));
	}
	
	// TEST ADDRESS SETTER WITH EMPTY STRING
	@Test
	public void testAddress_withEmptyString_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, VALID_NAME, VALID_PHONE, ""));
	}
}
