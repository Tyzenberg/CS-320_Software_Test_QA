package contactsTest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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

	
	@BeforeEach
	public void setup() {
		service = new ContactService();
	}
	
	///////////////////////////
	/// GET
	///////////////////////////
	
	// TEST A VALID GET
	@Test
	public void testGet_withValidContact_IsSuccessful() {
		// Arrange - create a service list with an existing contact
		Contact testContact = new Contact(ID, FIRST_NAME, LAST_NAME, PHONE, ADDRESS);
		List<Contact> contacts;
		contacts = new ArrayList<>();
		contacts.add(testContact);
		service = new ContactService(contacts);
		
		// Act - create new contact from getContact()
		Contact newContact = service.getContact(ID);
		
		// Assert - new contact will have same values as original contact
		Assertions.assertEquals(ID, newContact.getID());
		Assertions.assertEquals(FIRST_NAME, newContact.getFirstName());
		Assertions.assertEquals(LAST_NAME, newContact.getLastName());
		Assertions.assertEquals(PHONE, newContact.getPhone());
		Assertions.assertEquals(ADDRESS, newContact.getAddress());
	}
	
	// TEST GET WITH NULL
	@Test
	public void testGet_withNullId_ThrowIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.getContact(null));
	}
	
	// TEST GET WITH EMPTY ID
	@Test
	public void testGet_withEmptyId_ReturnsNullContact() {
		Assertions.assertNull(service.getContact(""));
	}
	
	// TEST GET WITH VALID ID BUT EMPTY SERVICE
	@Test
	public void testGet_withEmptyService_ReturnsNull() {
		Assertions.assertNull(service.getContact(ID));
	}
	
	///////////////////////////
	/// ADD
	///////////////////////////

	// TEST VALID ADD
	@Test
	public void testAdd_withNewValidContact_successfullyAdds() {
		// Arrange - create new contact
		Contact testContact = new Contact(ID, FIRST_NAME, LAST_NAME, PHONE, ADDRESS);
		
		// Act - add contact to service
		service.addContact(testContact);
		
		// Assert - verify contact was added
		Assertions.assertEquals(FIRST_NAME, service.getContact(ID).getFirstName());
		Assertions.assertEquals(LAST_NAME, service.getContact(ID).getLastName());
		Assertions.assertEquals(PHONE, service.getContact(ID).getPhone());
		Assertions.assertEquals(ADDRESS, service.getContact(ID).getAddress());
		Assertions.assertNotEquals(testContact, service.getContact(ID));
	}
	
	// TEST ADDING DUPLICATE
	@Test
	public void testAdd_withDuplicateContact_throwsIllegalArgumentException() {
		// Arrange - create new contact
		Contact testContact = new Contact(ID, FIRST_NAME, LAST_NAME, PHONE, ADDRESS);
		
		// Act - add to service
		service.addContact(testContact);
		
		// Assert - get illegal argument when trying to add class again
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.addContact(testContact));
	}
	
	// TEST ADDING NULL
	@Test
	public void testAdd_withNullContact_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
	}
	
	///////////////////////////////
	/// DELTE
	///////////////////////////////

	// TEST DELETING VALID EXISTING CONTACT
	@Test
	public void testDelete_withValidExistingContact_successfullyRemoves() {
		// Arrange - create new contact
		// add contact to service
		Contact testContact = new Contact(ID, FIRST_NAME, LAST_NAME, PHONE, ADDRESS);
		service.addContact(testContact);
		
		// Act - remove contact from service	
		service.deleteContact(testContact.getID());
		
		// Assert - Searching for contact in service returns null
		Assertions.assertNull(service.getContact(ID));
	}
	
	// TEST DELETING NULL ID
	@Test
	public void testDelete_withNullId_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.deleteContact(null));
	}
	
	// TEST DELETING CONTACT THAT DOESN'T EXIST
	@Test
	public void testDelete_withValidContactNotInService_ThrowsIllegalArgumentException() {
		Assertions.assertThrows(NoSuchElementException.class, () -> service.deleteContact(ID));
	}

	
	///////////////////////////////
	/// EDIT
	///////////////////////////////
	
	// TEST EDITING ALL NON-ID FIELDS
	@Test
	public void testEdit_withValidContactAllEditableFields_SuccessfullyChangesFields() {
		// Arrange - create new contact
		// create list of field inputs
		Contact testContact = new Contact(ID, FIRST_NAME, LAST_NAME, PHONE, ADDRESS);
		final String[] inputs = {"Harry", "Potter", "9876543210", "4 Privet Drive"};
		
		// Act - add contact to service
		// edit all fields
		service.addContact(testContact);
		service.editContact(ID, inputs[0], inputs[1], inputs[2], inputs[3]);
		
		// Assert - all fields have been changed
		Assertions.assertEquals(inputs[0], service.getContact(ID).getFirstName());
		Assertions.assertEquals(inputs[1], service.getContact(ID).getLastName());
		Assertions.assertEquals(inputs[2], service.getContact(ID).getPhone());
		Assertions.assertEquals(inputs[3], service.getContact(ID).getAddress());

	}
	// TEST EDITING ONE FIELD
	@Test
	public void testEdit_withValidContactOnlyOneField_SuccessfullyChangesOneField() {
		// Arrange - create new contact
		// set new value of phone
		Contact testContact = new Contact(ID, FIRST_NAME, LAST_NAME, PHONE, ADDRESS);
		final String newPhone = "9876543210";
		
		// Act - add contact to service
		// edit one field
		service.addContact(testContact);
		service.editContact(ID, null, null, newPhone, null);
		
		// Assert - only phone should have changed with no errors
		Assertions.assertEquals(FIRST_NAME, service.getContact(ID).getFirstName());
		Assertions.assertEquals(LAST_NAME, service.getContact(ID).getLastName());
		Assertions.assertEquals(newPhone, service.getContact(ID).getPhone());
		Assertions.assertEquals(ADDRESS, service.getContact(ID).getAddress());
	}
	
	// TEST EDITING CONTACT THAT DOESN'T EXIST
	@Test
	public void testEdit_withNonExistingContact_throwsIllegalArgumentException() {
		// Arrange - create new contact
		Contact testContact = new Contact(ID, FIRST_NAME, LAST_NAME, PHONE, ADDRESS);
		
		// Act - verify contact doesn't exist
		Assertions.assertNull(service.getContact(ID));
		
		// Assert - throw IllegalArgumentException when trying to edit field of contact that doesn't exist in service
		Assertions.assertThrows(NoSuchElementException.class, () -> service.editContact(ID, "Bob", null, null, null));
	}
	
	// TEST EDITING A NULL ID
	@Test
	public void testEdit_withNullId_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.editContact(null, "Bob", null, null, null));
	}
	
	// TEST EDITING A EMPTY ID
	@Test
	public void testEdit_withEmptyId_throwsIllegalArgumentException() {
		Assertions.assertThrows(NoSuchElementException.class, () -> service.editContact("", "Bob", null, null, null));
	}
	
	// TEST EDITING AN EMPTY FIELD
	@Test
	public void testEdit_withEmptyField_throwsIllegalArgumentException() {
		Contact testContact = new Contact(ID, FIRST_NAME, LAST_NAME, PHONE, ADDRESS);
		service.addContact(testContact);
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.editContact(ID, "", null, null, null));
	}
	
	

}
