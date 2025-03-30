package Tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class TaskService {

	// Edit function parameters
	final private String EDIT_NAME = "NAME";
	final private String EDIT_DESCRIPTION = "DESCRIPTION";
	
	// variables
	private List<Task> tasks;
	
	// Constructor
	public TaskService() {
		tasks = new ArrayList<>();
	}
	
	// Constructor with populated list
	public TaskService(List<Task> importList) {
		tasks = importList;
	}
	
	// Private function to find a task based on id - no error handling
	private Task findTask(String id) {
		// Start with null task
		Task foundTask = null;
		
		// Search for a matching Id
		for(Task currTask: tasks) {
			if (currTask.getId().equals(id)) {
				// Set the null task as the found task
				foundTask = currTask;
				break;
			}
		}
		// Return found task or null task if not found
		return foundTask;
	}
	
	// Public entrance to get a task using an id
	public Task getTask(String id) {
		
		// error handling of input
		if (id == null) {
			throw new IllegalArgumentException("id cannot be null");
		}
		if (id == "") {
			throw new IllegalArgumentException("id cannot be empty");
		}
		if (id.length() > 10) {
			throw new IllegalArgumentException("id cannot be more than 10 characters");
		}
		
		// call private search function
		Task foundTask = this.findTask(id);
		
		// error handling if no task found
		if (foundTask == null) {
			throw new NoSuchElementException("could not find a matching task");
		}
		return foundTask;
	}
	
	// Add Task to list
	public void addTask(Task newTask) {
		
		// error handling of input
		if (newTask == null) {
			throw new IllegalArgumentException("Cannot add a null task");
		}
		
		// error handling if list already has a task with the same id
		if (this.findTask(newTask.getId()) != null) {
			throw new IllegalArgumentException("Cannot add a task with a duplicate Id");
		}
		
		// add task to list if no error
		tasks.add(newTask);
	}
	
	// Delete task from list
	public void deleteTask(String id) {
		
		// search for task using public function - use same error handling
		Task tempTask = this.getTask(id);
		 if (tempTask != null) {
			 tasks.remove(tempTask);
		 }
	}
	
	// Private function to edit tasks
	private void editTask(String param, Task currTask, String input) {
		if (param == EDIT_NAME) {
			currTask.setName(input);
		}
		if (param == EDIT_DESCRIPTION) {
			currTask.setDescription(input);
		}
	}
	
	// Public function to edit name
	public void editName(String id, String newName) {
		Task editTask = this.getTask(id);
		this.editTask(EDIT_NAME, editTask, newName);
	}
	
	// Public function to edit description
	public void editDescription(String id, String newDesc) {
		Task editTask = this.getTask(id);
		this.editTask(EDIT_DESCRIPTION, editTask, newDesc);
	}

}
