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
	
	// TEST VALID ID ONLY CONSTRUCTOR
	@Test
	public void testConstructor_withIdOnly_buildsTaskWithIdOnly() {
		Task testTask = new Task(VALID_ID);
		Assertions.assertEquals(VALID_ID, testTask.getId());
		Assertions.assertEquals("", testTask.getName());
		Assertions.assertEquals("", testTask.getDescription());
	}
	
	// TEST CONSTRUCTOR WITH INVALID NAME
	@Test
	public void testConstructor_withInvalidName_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(VALID_ID, "", VALID_DESC));
	}
	
	// TEST CONSTRUCTOR WITH INVALID DESCRIPTION
	@Test
	public void testConstructor_withInvalidDescription_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(VALID_ID, VALID_NAME, null));
	}
		
	///////////////////
	/// ID
	///////////////////
	
	// TEST ID WITH NULL
	@Test
	public void testId_withNull_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(null));
	}
	
	// TEST ID WITH EMPTY STRING
	@Test
	public void testId_withEmptyString_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(""));
	}
	
	// TEST ID WITH MINIMUM CHARACTERS
	@Test
	public void testId_withMinimumCharacters_successfullySetsId() {
		final String minId = "1";
		Task testTask = new Task(minId);
		Assertions.assertEquals(minId, testTask.getId());
	}
	
	// TEST ID WITH MAXIMUM CHARACTERS
	@Test
	public void testId_withMaximumCharacters_successfullySetsId() {
		final String maxId = "1234567890";
		Task testTask = new Task(maxId);
		Assertions.assertEquals(maxId, testTask.getId());
	}
	
	// TEST ID WITH MORE THAN MAXIMUM CHARATERS
	@Test
	public void testId_withMoreThanMaximumCharacters_throwsIllegalArgumentException() {
		final String badId = "01234567890";
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(badId));
	}
	
	///////////////////
	/// Name
	///////////////////
	
	// TEST NAME WITH NULL
	@Test
	public void testName_withNull_throwsIllegalArgumentException() {
		Task testTask = new Task(VALID_ID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> testTask.setName(null));
	}
	
	// TEST NAME WITH EMPTY STRING
	@Test
	public void testName_withEmptyString_throwsIllegalArgumentException() {
		Task testTask = new Task(VALID_ID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> testTask.setName(""));
	}
	
	// TEST NAME WITH MINIMUM CHARACTERS
	@Test
	public void testName_withMinimumCharacters_successfullySetsName() {
		Task testTask = new Task(VALID_ID);
		final String minName = "A";
		testTask.setName(minName);
		Assertions.assertEquals(minName, testTask.getName());
	}
	
	// TEST NAME WITH MAXIMUM CHARACTERS
	@Test
	public void testName_withMaximumCharacters_successfullySetsName() {
		Task testTask = new Task(VALID_ID);
		final String maxName = "12345678901234567890";
		testTask.setName(maxName);
		Assertions.assertEquals(maxName, testTask.getName());
	}
	
	// TEST NAME WITH MORE THAN MAXIMUM CHARACTERS
	@Test
	public void testName_withMoreThanMaximumCharacters_throwsIllegalArgumentException() {
		Task testTask = new Task(VALID_ID);
		final String badName = "012345678901234567890";
		Assertions.assertThrows(IllegalArgumentException.class, () -> testTask.setName(badName));
	}
	
	// TEST NAME WITH NON-LETTERS
	@Test
	public void testName_withNonLetters_successfullySetsName() {
		final String testString = "L33t (0d3";
		Task testTask = new Task(VALID_ID);
		testTask.setName(testString);
		Assertions.assertEquals(testString, testTask.getName());
	}
		
	///////////////////
	/// Description
	///////////////////
	
	// TEST DESCRITION WITH NULL
	@Test
	public void testDescription_withNull_throwsIllegalArgumentException() {
		Task testTask = new Task(VALID_ID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> testTask.setDescription(null));
	}
	
	// TEST DESCRIPTION WITH EMPTY STRING
	@Test
	public void testDescription_withEmptyString_throwsIllegalArgumentException() {
		Task testTask = new Task(VALID_ID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> testTask.setDescription(""));		
	}
	
	// TEST DESCRIPTION WITH MINIMUM CHARACTERS
	@Test
	public void testDescription_withMinimumCharacters_successfullySetsDescription() {
		Task testTask = new Task(VALID_ID);
		final String minString = "A";
		testTask.setDescription(minString);
		Assertions.assertEquals(minString, testTask.getDescription());
	}
	
	// TEST DESCRIPTION WITH MAXIMUM CHARACTERS
	@Test
	public void testDescription_withMaximumCharacters_successfullySetsDescription() {
		Task testTask = new Task(VALID_ID);
		final String maxString = "01234567891124567892123456789312345678941234567895";
		testTask.setDescription(maxString);
		Assertions.assertEquals(maxString, testTask.getDescription());
	}
	
	// TEST DESCRIPTION WITH MORE THAN MAXIMUM CHARACTERS
	@Test
	public void testDescription_withMoreThanMaxCharacters_successfullySetsDescription() {
		Task testTask = new Task(VALID_ID);
		final String badString = "012345678911245678921234567893123456789412345678951";
		Assertions.assertThrows(IllegalArgumentException.class, () -> testTask.setDescription(badString));
	}
	
	// TEST DESCRIPTION WITH NON-LETTERS
	@Test
	public void testDescription_withNonLetters_successfullySetsDescription() {
		Task testTask = new Task(VALID_ID);
		final String testString = "Th1$ !5 N0t SQL Inj3(tion @GetALLPasswords";
		testTask.setDescription(testString);
		Assertions.assertEquals(testString, testTask.getDescription());
	}
	
	
	
	
	
	
	
	
	
	
}
