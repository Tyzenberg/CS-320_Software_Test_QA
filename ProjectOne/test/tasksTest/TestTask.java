package tasksTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Tasks.Task;

public class TestTask {
	
	// Constants
	String VALID_ID = "1035";
	String VALID_NAME = "Test Task Class";
	String VALID_DESC = "Thouroughly tests the Task Class";
	
	///////////////////
	/// Constructors
	///////////////////
	
	// TEST FULL VALID CONSTRUCTOR
	@Test
	public void testConstructor_withFullConstructor_buildsValidTask() {
		Task testTask = new Task(VALID_ID, VALID_NAME, VALID_DESC);
		
		Assertions.assertEquals(VALID_ID, testTask.getId());
		Assertions.assertEquals(VALID_NAME, testTask.getName());
		Assertions.assertEquals(VALID_DESC, testTask.getDescription());
	}
	
	// TEST CONSTRUCTOR WITH NULL TASK
	@Test
	public void testConstructor_withNullTask_throwsNullPointerException() {
		Assertions.assertThrows(NullPointerException.class, () -> new Task(null));
	}
	
	// TEST CONSTRUCTOR WITH VALID TASK
	@Test
	public void testConstructor_withValidTask_successfullyCopiesTask() {
		Task validTask = new Task(VALID_ID, VALID_NAME, VALID_DESC);
		Task copiedTask = new Task(validTask);
		
		Assertions.assertEquals(validTask.getDescription(), copiedTask.getDescription());
		Assertions.assertEquals(validTask.getId(), copiedTask.getId());
		Assertions.assertEquals(validTask.getName(), copiedTask.getName());
		Assertions.assertNotEquals(validTask, copiedTask);
	}
		
	///////////////////
	/// ID
	///////////////////
	
	// TEST ID WITH NULL
	@Test
	public void testId_withNull_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(null, VALID_NAME, VALID_DESC));
	}
	
	// TEST ID WITH EMPTY STRING
	@Test
	public void testId_withEmptyString_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Task("", VALID_NAME, VALID_DESC));
	}
	
	// TEST ID WITH MINIMUM CHARACTERS
	@Test
	public void testId_withMinimumCharacters_successfullySetsId() {
		final String minId = "1";
		Task testTask = new Task(minId, VALID_NAME, VALID_DESC);
		Assertions.assertEquals(minId, testTask.getId());
	}
	
	// TEST ID WITH MAXIMUM CHARACTERS
	@Test
	public void testId_withMaximumCharacters_successfullySetsId() {
		final String maxId = "1234567890";
		Task testTask = new Task(maxId, VALID_NAME, VALID_DESC);
		Assertions.assertEquals(maxId, testTask.getId());
	}
	
	// TEST ID WITH MORE THAN MAXIMUM CHARATERS
	@Test
	public void testId_withMoreThanMaximumCharacters_throwsIllegalArgumentException() {
		final String badId = "01234567890";
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(badId, VALID_NAME, VALID_DESC));
	}
	
	///////////////////
	/// Name
	///////////////////
	
	// TEST NAME WITH NULL
	@Test
	public void testName_withNull_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(VALID_ID, null, VALID_DESC));
	}
	
	// TEST NAME WITH EMPTY STRING
	@Test
	public void testName_withEmptyString_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(VALID_ID, "", VALID_DESC));
	}
	
	// TEST NAME WITH MINIMUM CHARACTERS
	@Test
	public void testName_withMinimumCharacters_successfullySetsName() {
		final String minName = "A";
		Task testTask = new Task(VALID_ID, minName, VALID_DESC);
		Assertions.assertEquals(minName, testTask.getName());
	}
	
	// TEST NAME WITH MAXIMUM CHARACTERS
	@Test
	public void testName_withMaximumCharacters_successfullySetsName() {
		final String maxName = "12345678901234567890";
		Task testTask = new Task(VALID_ID, maxName, VALID_DESC);
		Assertions.assertEquals(maxName, testTask.getName());
	}
	
	// TEST NAME WITH MORE THAN MAXIMUM CHARACTERS
	@Test
	public void testName_withMoreThanMaximumCharacters_throwsIllegalArgumentException() {
		final String badName = "012345678901234567890";
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(VALID_ID, badName, VALID_DESC));
	}
	
	// TEST NAME WITH NON-LETTERS
	@Test
	public void testName_withNonLetters_successfullySetsName() {
		final String testString = "L33t (0d3";
		Task testTask = new Task(VALID_ID, testString, VALID_DESC);
		Assertions.assertEquals(testString, testTask.getName());
	}
		
	///////////////////
	/// Description
	///////////////////
	
	// TEST DESCRITION WITH NULL
	@Test
	public void testDescription_withNull_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(VALID_ID, VALID_NAME, null));
	}
	
	// TEST DESCRIPTION WITH EMPTY STRING
	@Test
	public void testDescription_withEmptyString_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(VALID_ID, VALID_NAME, ""));		
	}
	
	// TEST DESCRIPTION WITH MINIMUM CHARACTERS
	@Test
	public void testDescription_withMinimumCharacters_successfullySetsDescription() {
		final String minString = "A";
		Task testTask = new Task(VALID_ID, VALID_NAME, minString);
		Assertions.assertEquals(minString, testTask.getDescription());
	}
	
	// TEST DESCRIPTION WITH MAXIMUM CHARACTERS
	@Test
	public void testDescription_withMaximumCharacters_successfullySetsDescription() {
		final String maxString = "01234567891124567892123456789312345678941234567895";
		Task testTask = new Task(VALID_ID, VALID_NAME, maxString);
		Assertions.assertEquals(maxString, testTask.getDescription());
	}
	
	// TEST DESCRIPTION WITH MORE THAN MAXIMUM CHARACTERS
	@Test
	public void testDescription_withMoreThanMaxCharacters_successfullySetsDescription() {
		final String badString = "012345678911245678921234567893123456789412345678951";
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(VALID_ID, VALID_NAME, badString));
	}
	
	// TEST DESCRIPTION WITH NON-LETTERS
	@Test
	public void testDescription_withNonLetters_successfullySetsDescription() {
		final String testString = "Th1$ !5 N0t SQL Inj3(tion @GetALLPasswords";
		Task testTask = new Task(VALID_ID, VALID_NAME, testString);
		Assertions.assertEquals(testString, testTask.getDescription());
	}
	
	
	
	
	
	
	
	
	
	
}
