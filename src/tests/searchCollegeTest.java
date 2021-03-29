package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import collegematch.College;
import collegematch.CollegeManager;

class searchCollegeTest {

	@Test
	void test() {
		CollegeManager collegeManager = new CollegeManager();
		boolean isPresent = false;
		ArrayList<College> colleges = collegeManager.getColleges();
		for(College college : colleges) {
			if(college.getName().equals("Washington University")){
				isPresent = true;
			}
		}
		assertEquals(true, isPresent);
	}

}
