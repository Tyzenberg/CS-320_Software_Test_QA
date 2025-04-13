package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ContactService {
	
	private List<Contact> contacts;
	
	public ContactService() {
		contacts = new ArrayList<>();
	}
	
	public ContactService(List<Contact> preBuilt) {
		contacts = preBuilt;
	}
	
	public void addContact(Contact newContact) {
		
		if (newContact == null) {
			throw new IllegalArgumentException("Cannot add a null contact");
		}
		
		if (this.getContact(newContact.getID()) != null) {
			throw new IllegalArgumentException("Cannot add contact with same id: " + newContact.getID());
		} else {
			contacts.add(new Contact(newContact));
		}
	}
	
	/*
	 *  Get the contact by id
	 *  Return contact if found, or return null
	 *  @param id - the contact id
	 *  @return - the contact or null if none exists
	 */
	public Contact getContact(String id) {
		Contact foundContact = null;
		
		if (id == null) {
			throw new IllegalArgumentException("Cannot search for id with null value");
		}
		
		boolean contactExists = false;
		for (Contact contact: contacts ) {
			if (contact.getID().equals(id)) {
				foundContact = contact;
				contactExists = true;
				break;
			}
		}
		
		if (contactExists) {
			return foundContact;
		} else {
			return null;
		}
	}
	
	/*
	 *  Delete a contact by id
	 *  Delete contact if found, throw illegal argument exception if contact doesn't exist
	 *  @param id - the contact to be deleted
	 */
	public void deleteContact(String id) {
		
		if (id == null) {
			throw new IllegalArgumentException("Cannot delete a null contact");
		}
		
		Contact delContact = this.getContact(id);
		if (delContact == null) {
			throw new NoSuchElementException("Cannot delete a contact that doesn't exist");	
		}
		
		contacts.remove(delContact);
	}
	
	/*
	 * Edit a contact by id
	 * Change any field of a contact
	 * @param id - id of the contact to edit
	 * @param firstName - updated value of the field - input null to not change
	 * @param lastName - updated value of the field - input null to not change
	 * @param phone - updated value of the field - input null to not change
	 * @param address - updated value of the field - input null to not change 
	 */
	public void editContact(String id, String firstName, String lastName, String phone, String address) {
		
		if (id == null) {
			throw new IllegalArgumentException("Cannot edit a contact with a null id");
		}
		
		Contact contact = this.getContact(id);
		if (contact == null) {
			throw new NoSuchElementException("Cannot edit a contact that doesn't exist");
		}
		
		if (firstName != null) {
			contact.setFirstName(firstName);
		}
		
		if (lastName != null) {
			contact.setLastName(lastName);
		}
		
		if (phone != null) {
			contact.setPhone(phone);
		}
		
		if (address != null) {
			contact.setAddress(address);
		}

	}

}
