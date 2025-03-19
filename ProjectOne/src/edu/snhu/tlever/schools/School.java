package edu.snhu.tlever.schools;

public class School {
	
	private String id;

	private void setId(String id) {
		
		if (id==null) {
			throw new IllegalArgumentException("Id cannot be null");
		}
		
		this.id = id;
	}
	
	
	public School(String id) {
		
		setId(id);
	}

	public String getId() {

		// TODO Auto-generated method stub
		return id;
	}

}
