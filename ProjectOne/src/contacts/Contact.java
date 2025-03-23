package contacts;

public class Contact {
	
	private String id;
	private String firstName;
	private String lastName;
	private String number;
	private String address;

	public Contact(String id, String fName, String lName, String pNumber, String location) {
		setID(id);
		setFirstName(fName);
		setLastName(lName);
		setNumber(pNumber);
		setAddress(location);
	}
	
	public String getID() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getAddress() {
		return address;
	}
	
	private void setID(String id) {
		
		if (id==null) {
			throw new IllegalArgumentException("Id cannot be null");
		} else if(id.length() > 10 ) {
			throw new IllegalArgumentException("Id cannot be more than 10 characters");
		} else if(id.length() < 1 ) {
			throw new IllegalArgumentException("Id cannot be blank");
		}
		
		this.id = id;
	}
	
	public void setFirstName(String name) {
		
		// General checks
		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null");
		} else if (name.length() > 10 ) {
			throw new IllegalArgumentException("Name cannot be more than 10 characters");
		} else if (name.length() < 1 ) {
			throw new IllegalArgumentException("Name cannot be blank");
		}
		
		// verify name is only letters
		for (char c : name.toCharArray()) {
	        if (!Character.isLetter(c)) {
	            throw new IllegalArgumentException("Name must only contain letters");
	        }
	    }
		
		this.firstName = name;
	}
	
	public void setLastName(String name) {
		
		// General checks
		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null");
		} else if (name.length() > 10 ) {
			throw new IllegalArgumentException("Name cannot be more than 10 characters");
		} else if (name.length() < 1 ) {
			throw new IllegalArgumentException("Name cannot be blank");
		}
		
		// verify name is only letters
		for (char c : name.toCharArray()) {
	        if (!Character.isLetter(c)) {
	            throw new IllegalArgumentException("Name must only contain letters");
	        }
	    }
		
		this.lastName = name;
	}
	
	public void setNumber(String pNumber) {
		this.number = pNumber;
	}
	
	public void setAddress(String location) {
		this.address = location;
	}
	


}
