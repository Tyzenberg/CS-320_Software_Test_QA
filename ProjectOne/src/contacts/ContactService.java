package contacts;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
	
	private List<Contact> contacts;
	
	public ContactService() {
		contacts = new ArrayList<>();
	}
	
	public void addContact(Contact newContact) {
		
		if (newContact == null) {
			throw new IllegalArgumentException("Cannot add a null contact");
		}
		
		boolean isDuplicate = false;
		for (Contact contact : contacts) {
			if (contact.getID().equals(newContact.getID())) {
				isDuplicate = true;
				break;
			}
		}
		
		if (isDuplicate) {
			throw new IllegalArgumentException("Cannot add contact with same id: " + newContact.getID());
		}
		
		contacts.add(newContact);
	}
	/*
	 *  Get the contact by id
	 *  Return contact if found, or return null
	 *  @paramid - the contact id
	 *  @return - the contact or null if none exists
	 */
	public Contact getContact(String id) {
		Contact foundContact = null;
		
		for (Contact contact: contacts ) {
			if (contact.getID().equals(id)) {
				foundContact = contact;
				break;
			}
		}
		
		return foundContact;
	}

}
