package Tasks;

public class Task {
	
	String id;
	String name;
	String description;
	
	public Task(Task copyTask) {
		this(copyTask.id, copyTask.name, copyTask.description);
	}
	
	public Task(String id, String name, String description) {
		this.setId(id);
		this.setName(name);
		this.setDescription(description);
	}
	
	private void setId(String id) {
		if (id == null) {
			throw new IllegalArgumentException("id cannot be null");
		}
		if (id == "") {
			throw new IllegalArgumentException("id cannot be empty");
		}
		if (id.length() > 10) {
			throw new IllegalArgumentException("id cannot be more than 10 characters");
		}
		
		this.id = id;
	}
	
	public void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("name cannot be null");
		}
		if (name == "") {
			throw new IllegalArgumentException("name cannot be empty");
		}
		if (name.length() > 20) {
			throw new IllegalArgumentException("name cannot be more than 20 characters");
		}
		
		this.name = name;
	}
	
	public void setDescription(String description) {
		if (description == null) {
			throw new IllegalArgumentException("description cannot be null");
		}
		if (description == "") {
			throw new IllegalArgumentException("description cannot be empty");
		}
		if (description.length() > 50) {
			throw new IllegalArgumentException("description cannot be more than 50 characters");
		}
		
		this.description = description;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}

}
