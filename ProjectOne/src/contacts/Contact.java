package contacts;

public class Contact {
	
	private String id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact() {
		this.id = "";
		this.firstName = "";
		this.lastName = "";
		this.phone = "";
		this.address = "";
	}
	
	public Contact(String id) {
		setID(id);
		this.firstName = "";
		this.lastName = "";
		this.phone = "";
		this.address = "";
	}

	public Contact(String id, String fName, String lName, String phoneNumber, String location) {
		setID(id);
		setFirstName(fName);
		setLastName(lName);
		setPhone(phoneNumber);
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
	
	public String getPhone() {
		return phone;
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
		
		// verify ID is only numbers
		for (char c : id.toCharArray()) {
			if (c < '0' || c > '9') {
				throw new IllegalArgumentException("Id must only contain numbers");
			}
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
	
	public void setPhone(String phoneNumber) {
		
		// General checks
		if (phoneNumber == null ) {
			throw new IllegalArgumentException("Phone Number cannot be null");
		} else if (!(phoneNumber.length() == 10)) {
			throw new IllegalArgumentException("Phone Number must contain 10 characters");
		}
		
		// verify Phone Number is only numbers
		for (char c : phoneNumber.toCharArray()) {
			if (c < '0' || c > '9') {
				throw new IllegalArgumentException("Phone Number must only contain numbers");
			}
		}
		
		this.phone = phoneNumber;
	}
	
	public void setAddress(String location) {
		
		// General checks
		if ( location == null ) {
			throw new IllegalArgumentException("Address cannout be null");
		} else if ( location.length() > 30 ) {
			throw new IllegalArgumentException("Address cannot be more than 30 characters");
		} else if ( location.length() < 1 ) {
			throw new IllegalArgumentException("Address cannot be empty");
		}
		
		this.address = location;
	}
	


}
