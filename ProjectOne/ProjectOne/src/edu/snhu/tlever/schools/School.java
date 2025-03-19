package edu.snhu.tlever.schools;

public class School {
	
	private String id;

	private void setId(String id) {
		
		if (id==null) {
			throw new IllegalArgumentException("Id cannot be null");
		} else if(id.length() > 10 ) {
			throw new IllegalArgumentException("Id cannot be more than 10 characters");
		} else if(id.length() < 1 ) {
			throw new IllegalArgumentException("Id cannot be blank");
		}
		
		this.id = id;
	}
	
	
	public School(String id) {
		
		setId(id);
	}

	public String getId() {

		return id;
	}

}
