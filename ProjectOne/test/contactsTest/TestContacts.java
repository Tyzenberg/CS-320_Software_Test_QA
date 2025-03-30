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
	
	// TEST CONSTRUCTOR WITH MINIMUM VALID INPUTS
	// validate non-id fields get populated with empty strings
	@Test
	public void testConstructor_minValidInputs_IsSuccessful() {
		Contact testContact = new Contact(VALID_ID);
				
		// Not checking id - that is verified in other tests
		Assertions.assertEquals("", testContact.getFirstName());
		Assertions.assertEquals("", testContact.getLastName());
		Assertions.assertEquals("", testContact.getPhone());
		Assertions.assertEquals("", testContact.getAddress());
	}
	
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
	
	// TEST CONSTRUCTOR WITH INVALID FIRSTNAME
	// validate constructor uses firstname setter
	@Test
	public void testConstructor_withInvalidFirstname_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, "", VALID_NAME, VALID_PHONE, VALID_ADDRESS));
	}
	
	// TEST CONSTRUCTOR WITH INVALID LASTNAME
	// validate constructor uses lastname setter
	@Test
	public void testConstructor_withInvalidLastname_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, "", VALID_PHONE, VALID_ADDRESS));
	}
	
	// TEST CONSTRUCTOR WITH INVALID PHONE
	// validate constructor uses phone setter
	@Test
	public void testConstructor_withInvalidPhone_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, VALID_NAME, "", VALID_ADDRESS));
	}
	
	// TEST CONSTRUCTOR WITH INVALID ADDRESS
	// validate constructor uses address setter
	@Test
	public void testConstructor_withInvalidAddress_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_NAME, VALID_NAME, VALID_PHONE, ""));
	}
	
	//////////////////////
	/// Test ID 
	//////////////////////
	
	// TEST ID WITH MORE THAN MAXIMUM CHARACTERS
	@Test
	public void testId_withMoreThanMaxCharacters_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("01234567890"));
	}

	
	// TEST ID WITH MAXIUM CHARACTERS
	@Test
	public void testId_withMaxValid_IsSuccessful() {
		final String MAX_ID = "0123456789";
		Contact testContact = new Contact(MAX_ID);
		Assertions.assertEquals(MAX_ID, testContact.getID());
	}
	
	// TEST ID WITH MINIMUM CHARACTERS
	@Test
	public void testId_withMinValid_IsSuccessful() {
		Contact testContact = new Contact(VALID_ID);
		Assertions.assertEquals(VALID_ID, testContact.getID());
	}
	
	// TEST ID WITH NULL
	@Test
	public void testId_withNullValue_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(null));
	}
	
	// TEST ID WITH EMPTY STRING
	@Test
	public void testId_withEmptyString_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(""));
	}
	
	// TEST ID WITH LETTER
	@Test
	public void testID_withLetters_ThrowsIllegalArgumentException() {
		String testId = "23s21";
		Assertions.assertThrows(IllegalArgumentException.class, ()-> new Contact(testId));
	}
	
	// TEST ID WITH SPECIAL CHARACTER
	@Test
	public void testID_withSpecialCharacters_ThrowsIllegalArgumentException() {
		String testId = "12#45";
		Assertions.assertThrows(IllegalArgumentException.class, ()-> new Contact(testId));
	}
	
	
	//////////////////////
	/// Test firstName 
	//////////////////////	
	
	// TEST FIRSTNAME SETTER WITH MAXIMUM CHARACTERS
	@Test
	public void testFirstName_withMaxCharacters_IsSuccessful() {
		Contact testContact = new Contact(VALID_ID);
		testContact.setFirstName(MAX_NAME);
		Assertions.assertEquals(MAX_NAME, testContact.getFirstName());
	}
	
	// TEST FIRSTNAME SETTER WITH MINIMUM CHARACTERS
	@Test
	public void testFirstName_withMinCharacters_IsSuccessful() {
		Contact testContact = new Contact(VALID_ID);
		testContact.setFirstName(MIN_NAME);
		Assertions.assertEquals(MIN_NAME, testContact.getFirstName());
	}
	
	// TEST FIRSTNAME SETTER WITH A NUMBER
	@Test
	public void testFirstName_withNumbers_ThrowsIllegalArgumentException() {
		Contact testContact = new Contact(VALID_ID);
		final String firstName = "Chr1s";
		Assertions.assertThrows(IllegalArgumentException.class, () -> testContact.setFirstName(firstName));
	}
	
	// TEST FIRSTNAME SETTER WITH A SPECIAL CHARACTER
	@Test
	public void testFirstName_withSpecialCharacters_ThrowsIllegalArgumentException() {
		Contact testContact = new Contact(VALID_ID);
		final String firstName = "P@ul";
		Assertions.assertThrows(IllegalArgumentException.class, () -> testContact.setFirstName(firstName));
	}
	
	// TEST FIRSTNAME SETTER WITH MORE THAN MAXIMUM CHARACTERS
	@Test
	public void testFirstName_withMoreThanMaxCharacters_ThrowsIllegalArgumentException() {
		Contact testContact = new Contact(VALID_ID);
		final String firstName = MAX_NAME + "a";
		Assertions.assertThrows(IllegalArgumentException.class, () -> testContact.setFirstName(firstName));
	}
	
	// TEST FIRSTNAME SETTER WITH NULL
	@Test
	public void testFirstName_withNullValue_ThrowsIllegalArgumentException() {
		Contact testContact = new Contact(VALID_ID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> testContact.setFirstName(null));	
	}
	
	// TEST FIRSTNAME SETTER WITH EMPTY STRING
	@Test
	public void testFirstName_withEmptyString_ThrowsIllegalArgumentException() {
		Contact testContact = new Contact(VALID_ID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> testContact.setFirstName(""));
	}
	
	//////////////////////
	/// Test lastName
	//////////////////////
	
	// TEST LASTNAME SETTER WITH MAXIMUM CHARACTERS
	@Test
	public void testLastName_withMaxCharacters_IsSuccessful() {
		Contact testContact = new Contact(VALID_ID);
		testContact.setLastName(MAX_NAME);
		Assertions.assertEquals(MAX_NAME, testContact.getLastName());
	}
	
	// TEST LASTNAME SETTER WITH MINIMUM CHARACTERS
	@Test
	public void testLastName_withMinCharacters_IsSuccessful() {
		Contact testContact = new Contact(VALID_ID);
		testContact.setLastName(MIN_NAME);
		Assertions.assertEquals(MIN_NAME, testContact.getLastName());
	}
	
	// TEST LASTNAME SETTER WITH A NUMBER
	@Test
	public void testLastName_withNumbers_ThrowsIllegalArgumentException() {
		Contact testContact = new Contact(VALID_ID);
		String lastName = "Chr1s";
		Assertions.assertThrows(IllegalArgumentException.class, () -> testContact.setLastName(lastName));
	}
	
	// TEST LASTNAME SETTER WITH A SPECIAL CHARACTER
	@Test
	public void testLastName_withSpecialCharacters_ThrowsIllegalArgumentException() {
		Contact testContact = new Contact(VALID_ID);
		String lastName = "P@ul";
		Assertions.assertThrows(IllegalArgumentException.class, () -> testContact.setLastName(lastName));	
	}
	
	// TEST LASTNAME SETTER WITH MORE THAN MAXIMUM CHARACTERS
	@Test
	public void testLastName_withMoreThanMaxCharacters_ThrowsIllegalArgumentException() {
		Contact testContact = new Contact(VALID_ID);
		String lastName = MAX_NAME + "a";
		Assertions.assertThrows(IllegalArgumentException.class, () -> testContact.setLastName(lastName));
	}
	
	// TEST LASTNAME SETTER WITH NULL
	@Test
	public void testLastName_withNullValue_ThrowsIllegalArgumentException() {
		Contact testContact = new Contact(VALID_ID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> testContact.setLastName(null));
	}
	
	// TEST LASTNAME SETTER WITH EMPTY STRING
	@Test
	public void testLastName_withEmptyString_ThrowsIllegalArgumentException() {
		Contact testContact = new Contact(VALID_ID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> testContact.setLastName(""));
	}
	
	//////////////////////
	/// Test Phone
	//////////////////////
	
	// TEST PHONE SETTER WITH VALID INPUT
	@Test
	public void testPhone_withValidInput_IsSuccessful() {
		Contact testContact = new Contact(VALID_ID);
		testContact.setPhone(VALID_PHONE);
		Assertions.assertEquals(VALID_PHONE, testContact.getPhone());
	}
	
	// TEST PHONE SETTER WITH A LETTER
	@Test
	public void testPhone_withLetters_ThrowsIllegalArgumentException() {
		Contact testContact = new Contact(VALID_ID);
		String phone = "01234s6789";
		Assertions.assertThrows(IllegalArgumentException.class, () -> testContact.setPhone(phone));
	}
	
	// TEST PHONE SETTER WITH A SPECIAL CHARACTER
	@Test
	public void testPhone_withSpecialCharacters_ThrowsIllegalArgumentException() {
		Contact testContact = new Contact(VALID_ID);
		String phone = "01234$6789";
		Assertions.assertThrows(IllegalArgumentException.class, () -> testContact.setPhone(phone));
	}
	
	// TEST PHONE SETTER WITH MORE THAN 10 CHARACTERS
	@Test
	public void testPhone_withMoreThanMaxNumbers_ThrowsIllegalArgumentException() {
		Contact testContact = new Contact(VALID_ID);
		String phone = VALID_PHONE + "1";
		Assertions.assertThrows(IllegalArgumentException.class, () -> testContact.setPhone(phone));
	}
	
	// TEST PHONE SETTER WITH LESS THAN 10 CHARACTERS
	@Test
	public void testPhone_withLessThanMinCharacters_ThrowsIllegalArgumentException() {
		Contact testContact = new Contact(VALID_ID);
		String phone = "123456789";
		Assertions.assertThrows(IllegalArgumentException.class, () -> testContact.setPhone(phone));
	}
	
	// TEST PHONE SETTER WITH NULL
	@Test
	public void testPhone_withNull_ThrowsIllegalArgumentException() {
		Contact testContact = new Contact(VALID_ID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> testContact.setPhone(null));
	}
	
	//////////////////////
	/// Test address
	//////////////////////
	
	// TEST ADDRESS SETTER WITH MAXIMUM CHARACTERS
	@Test
	public void testAddress_withMaxCharacters_IsSuccessful() {
		String address = "12345678 This is 30 characters";
		Contact testContact = new Contact(VALID_ID);
		testContact.setAddress(address);
		Assertions.assertEquals(address, testContact.getAddress());
	}
	
	// TEST ADDRESS SETTER WITH 1 CHARACTER
	@Test
	public void testAddress_withMinCharacters_IsSuccessful() {
		String address = "1";
		Contact testContact = new Contact(VALID_ID);
		testContact.setAddress(address);
		Assertions.assertEquals(address, testContact.getAddress());
	}
	
	// TEST ADDRESS SETTER WITH MORE THAN MAXIMUM CHARACTERS
	@Test
	public void testAddress_withMoreThanMaxCharacters_ThrowsIllegalArgumentException() {
		Contact testContact = new Contact(VALID_ID);
		String address = "123456789 This is 31 characters";
		Assertions.assertThrows(IllegalArgumentException.class, () -> testContact.setAddress(address));
	}
	
	// TEST ADDRESS SETTER WITH NUL
	@Test
	public void testAddress_withNullValue_ThrowsIllegalArgumentException() {
		Contact testContact = new Contact(VALID_ID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> testContact.setAddress(null));
	}
	
	// TEST ADDRESS SETTER WITH EMPTY STRING
	@Test
	public void testAddress_withEmptyString_ThrowsIllegalArgumentException() {
		Contact testContact = new Contact(VALID_ID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> testContact.setAddress(""));
	}
}
