package contacts;

public class Contact {
	
	private String id;
	private String firstName;

	
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
	
	public Contact(String id) {
		setID(id);
	}
	
	public String getID() {
		return id;
	}
	
	public void setFirstName(String name) {
		this.firstName = name;
	}
	
	public String getFirstName() {
		return firstName;
	}

}
