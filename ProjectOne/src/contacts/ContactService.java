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
	
	public void deleteContact(Contact inContact) {
		
		if (inContact == null) {
			throw new IllegalArgumentException("Cannot delete a null contact");
		}
		
		Contact delContact = this.getContact(inContact.getID());
		if (delContact == null) {
			throw new IllegalArgumentException("Cannot delete contact that doesn't exist");	
		}
		
		contacts.remove(delContact);
	}
	
	public void editContact(Contact inContact, String firstName, String lastName, String phone, String address) {
		
		if (inContact == null) {
			throw new IllegalArgumentException("Cannot edit a null contact");
		}
		
		inContact = this.getContact(inContact.getID());
		if (inContact == null) {
			throw new IllegalArgumentException("Cannot edit a contact that doesn't exist");
		}
		
		if (firstName != null) {
			inContact.setFirstName(firstName);
		}
		
		if (lastName != null) {
			inContact.setLastName(lastName);
		}
		
		if ( phone != null) {
			inContact.setPhone(phone);
		}
		
		if (address != null) {
			inContact.setAddress(address);
		}
		
	}

}
