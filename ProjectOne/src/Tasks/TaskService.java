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
	
	// Public entrance to get a task using an id
	public Task getTask(String id) {
		Task foundTask = null;
		
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
		
		boolean taskExists = false;
		for(Task currTask: tasks) {
			if (currTask.getId().equals(id)) {
				// Set the null task as the found task
				foundTask = currTask;
				taskExists = true;
				break;
			}
		}

		if (taskExists) {
			return foundTask;
		} else {
			return null;
		}
	}
	
	// Add Task to list
	public void addTask(Task newTask) {
		
		// error handling of input
		if (newTask == null) {
			throw new IllegalArgumentException("Cannot add a null task");
		}
		
		// error handling if list already has a task with the same id
		if (this.getTask(newTask.getId()) != null) {
			throw new IllegalArgumentException("Cannot add a task with a duplicate Id");
		}
		
		// add task to list if no error
		tasks.add(new Task(newTask));
	}
	
	// Delete task from list
	public void deleteTask(String id) {
		
		// search for task using public function - use same error handling
		Task tempTask = this.getTask(id);
		 if (tempTask == null) {
			 throw new NoSuchElementException("Can not delete task that doesn't exist");
		 } else {
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
		if (editTask == null) {
			throw new NoSuchElementException("Cannot edit task that doesn't exist");
		} else {
		editTask.setName(newName);;
		}
	}
	
	// Public function to edit description
	public void editDescription(String id, String newDesc) {
		Task editTask = this.getTask(id);
		if (editTask == null) {
			throw new NoSuchElementException("Cannot edit task that doesn't exist");
		} else {
			editTask.setDescription(newDesc);
		}
	}

}
