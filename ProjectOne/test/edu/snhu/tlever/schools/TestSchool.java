package edu.snhu.tlever.schools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSchool {
	
	/*
	 *******************
	 ***** Test ID *****
	 *******************
	 */
	
	@Test
	public void testId_withValid_IsSuccessful() {
		
		final String VALID_ID = "1";
		
		School myTestSchool = new School(VALID_ID);
		
		Assertions.assertEquals(VALID_ID, myTestSchool.getId());
	}
	
	@Test
	public void testId_withNullValue_ThrowsIllegalArgumentException() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> new School(null));
		
	}

	/*
	 *******************
	 **** Test Name ****
	 *******************
	 */
	
}
