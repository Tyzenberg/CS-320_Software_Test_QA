package tasksTest;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Tasks.TaskService;
import Tasks.Task;


public class TestTaskService {

	final String VALID_ID = "0780";
	final String VALID_NAME = "A task has no name";
	final String VALID_DESCRIPTION = "Not vague at all";
	
	Task startingTask = new Task(VALID_ID, VALID_NAME, VALID_DESCRIPTION);
	List<Task> tasks = new ArrayList<>();
	
	@BeforeEach
	public void setup() {
		tasks.add(startingTask);
	}
	
	///////////////
	/// Get
	///////////////
	
	// TEST GET WITH VALID ID
	@Test
	public void testGet_withExistingId_successfullyGetsTask() {
		TaskService testService = new TaskService(tasks);
		Task testTask = testService.getTask(VALID_ID);
		
		Assertions.assertEquals(VALID_NAME, testTask.getName());
		Assertions.assertEquals(VALID_DESCRIPTION, testTask.getDescription());
	}
	
	// TEST GET WITH NULL ID
	@Test
	public void testGet_withNullId_throwsIllegalArgumentException() {
		TaskService testService = new TaskService(tasks);
		Assertions.assertThrows(IllegalArgumentException.class, () -> testService.getTask(null));
	}
	
	// TEST GET WITH EMPTY ID
	@Test
	public void testGet_withEmptyId_throwsIllegalArgumentException() {
		TaskService testService = new TaskService(tasks);
		Assertions.assertThrows(IllegalArgumentException.class, () -> testService.getTask(""));
	}
	
	// TEST GET WITH MORE THAN MAX CHARACTERS
	@Test
	public void testGet_withMoreThanMaxCharacters_throwsIllegalArgumentException() {
		TaskService testService = new TaskService(tasks);
		Assertions.assertThrows(IllegalArgumentException.class, () -> testService.getTask("01234567890"));
	}
	
	///////////////
	/// Add
	///////////////
	
	// TEST ADD INTO EMPTY TASKSERVICE
	@Test
	public void testAdd_withEmptyServiceAndUniqueId() {
		TaskService testService = new TaskService();
		testService.addTask(startingTask);
		Task newTask = testService.getTask(VALID_ID);
		Assertions.assertEquals(VALID_NAME, newTask.getName());
		Assertions.assertEquals(VALID_DESCRIPTION, newTask.getDescription());
	}
	
	// TEST ADD INTO POPULATED SERVICE WITH UNIQUE TASK
	@Test
	public void testAdd_withUniqueIdAndPopulatedService_successfullyAdds() {
		TaskService testService = new TaskService(tasks);
		final String testId = "702";
		final String testName = "unique task";
		final String testDesc = "Not Ambiguous or vague";
		
		Task newTask = new Task(testId, testName, testDesc);
		testService.addTask(newTask);
		
		Task recalledTask = testService.getTask(testId);
		
		Assertions.assertEquals(recalledTask.getName(), newTask.getName());
		Assertions.assertEquals(recalledTask.getDescription(), newTask.getDescription());
	}
	
	// TEST ADD WITH ALREADY EXISTING ID
	@Test
	public void testAdd_withExistingId_throwsIllegalArgumentException() {
		TaskService testService = new TaskService(tasks);
		Task newTask = new Task(VALID_ID, "New Name", "New Description");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> testService.addTask(newTask));
	}
	
	// TEST ADD NULL TASK
	@Test
	public void testAdd_withNullTask_throwsIllegalArgumentException() {
		TaskService testService = new TaskService();
		Task nullTask = null;
		Assertions.assertThrows(IllegalArgumentException.class, () -> testService.addTask(nullTask));
	}
	
	///////////////
	/// Delete
	///////////////
	
	// TEST A VALID DELETE
	@Test
	public void testDelete_deleteExistingTask_successfullyDeletes() {
		TaskService testService = new TaskService(tasks);
		Assertions.assertEquals(testService.getTask(VALID_ID).getName(), VALID_NAME);
		
		testService.deleteTask(VALID_ID);
		
		Assertions.assertNull(testService.getTask(VALID_ID));
	}
	
	// TEST DELETING NON-EXISTANT TASK FROM POPULATED SERVICE
	@Test
	public void testDelete_taskDoesntExist_throwsNoSuchElementException() {
		TaskService testService = new TaskService(tasks);
		Assertions.assertThrows(NoSuchElementException.class, () -> testService.deleteTask("7"));
	}
	
	// TEST DELETING TASK FROM EMPTY SERVICE
	@Test
	public void testDelete_fromEmptyService_throwsNoSuchElementException() {
		TaskService testService = new TaskService();
		Assertions.assertThrows(NoSuchElementException.class, () -> testService.deleteTask(VALID_ID));
	}
	
	///////////////
	/// Edit Name
	///////////////

	// TEST VALID NAME EDIT
	@Test
	public void testEditName_validEdit_successfullyEditsName() {
		TaskService testService = new TaskService(tasks);
		final String newName = "Successfull Change";
		
		testService.editName(VALID_ID, newName);
		
		Assertions.assertEquals(newName, testService.getTask(VALID_ID).getName());
	}
	

	// TEST EDIT NAME ON NON-EXISTANT TASK
	@Test
	public void testEditName_editNonExistantTask_throwsNoSuchElementException() {
		TaskService testService = new TaskService();
		Assertions.assertThrows(NoSuchElementException.class, () -> testService.editName(VALID_ID, "failed edit"));
	}
	
	// TEST EDIT NAME WITH NULL NAME
	@Test
	public void testEditName_withNullName_throwsIllegalArgumentException() {
		TaskService testService = new TaskService(tasks);
		Assertions.assertThrows(IllegalArgumentException.class, () -> testService.editName(VALID_ID, null));
	}
	
	///////////////
	/// Edit Description
	///////////////
	
	// TEST VALID DESCRIPTION EDIT
	@Test
	public void testEditDescription_withValidEdit_successfullyEditsDescription() {
		TaskService testService = new TaskService(tasks);
		final String editDesc = "Description has changed";
		testService.editDescription(VALID_ID, editDesc);
		Assertions.assertEquals(editDesc, testService.getTask(VALID_ID).getDescription());
	}
	
	// TEST EDIT DESCRIPTION ON NON-EXISTANT TASK
	@Test
	public void testEditDescription_withNonExistantTask_throwsNoSuchElementException() {
		TaskService testService = new TaskService();
		Assertions.assertThrows(NoSuchElementException.class, () -> testService.editDescription(VALID_ID, "failed edit"));
	}
	
	// TEST EDIT DESCRIPTION WITH EMPTY DESCRIPTION
	@Test
	public void testEditDescription_withEmptyString_throwIllegalArgumentException() {
		TaskService testService = new TaskService(tasks);
		Assertions.assertThrows(IllegalArgumentException.class, () -> testService.editDescription(VALID_ID, ""));
	}
	
	
	
	///////////////
	/// Functionality
	///////////////
	
	// TEST DELETING TASK AND ADDING TASK WITH SAME ID
	@Test
	public void testFunctionality_deleteThenAddTaskWithSameId_successfullyAddsTask() {
		TaskService testService = new TaskService(tasks);
		final String newName = "new task";
		final String newDesc = "new info";
		Task newTask = new Task(VALID_ID, newName, newDesc);
		
		testService.deleteTask(VALID_ID);
		testService.addTask(newTask);
		
		Assertions.assertEquals(newName, testService.getTask(VALID_ID).getName());
		Assertions.assertEquals(newDesc, testService.getTask(VALID_ID).getDescription());	
	}
	
	// TEST EDITING TASK AFTER DELETING IT
	@Test
	public void testFunctionality_deleteTaskThenEditSameTask_throwsNoSuchElementException() {
		TaskService testService = new TaskService(tasks);
		testService.deleteTask(VALID_ID);
		Assertions.assertThrows(NoSuchElementException.class, () -> testService.editName(VALID_ID, "failed edit"));
	}
	
	// TEST DELETING TASK ADDING IT BACK AND EDITING IT
	@Test
	public void testFunctionality_deleteTaskReAddSameTaskThenEdit_successfullyEditsTask() {
		TaskService testService = new TaskService(tasks);
		final String newName = "it works";
		
		testService.deleteTask(VALID_ID);
		testService.addTask(startingTask);
		testService.editName(VALID_ID, newName);
		
		Assertions.assertEquals(newName, testService.getTask(VALID_ID).getName());
	}
}
