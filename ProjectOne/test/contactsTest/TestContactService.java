package contactsTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import contacts.Contact;
import contacts.ContactService;

public class TestContactService {
	
	private ContactService service;
	private final String ID = "12345";
	private final String FIRST_NAME = "John";
	private final String LAST_NAME = "Doe";
	private final String PHONE = "0123456789";
	private final String ADDRESS = "1 Cool Place";
	private final Contact testContact = new Contact(ID, FIRST_NAME, LAST_NAME, PHONE, ADDRESS);
	
	@BeforeEach
	public void setup() {
		service = new ContactService();
	}
	
	///////////////////////////
	/// ADD
	///////////////////////////

	// valid add
	@Test
	public void testAdd_withNewContact_successfullyAdds() {
		service.addContact(testContact);
		
		Assertions.assertEquals(testContact, service.getContact(testContact.getID()));
	}
	
	// add duplicate
	@Test
	public void testAdd_withDuplicateContact_throwsIllegalArgumentException() {
		service.addContact(testContact);
		Assertions.assertNotNull(service.getContact(testContact.getID()));
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.addContact(testContact));
	}
	
	// add null contact
	@Test
	public void testAdd_withNullContact_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
	}
	
	///	///////////////////////////
	/// DELTE
	///////////////////////////

	///	///////////////////////////
	/// ADD
	///////////////////////////

}
