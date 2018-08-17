package soen6441;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import soen6441.Course.Program;


public class ExamQuestion4Test {

	static List<Course>  courseList = new ArrayList();
	
	@BeforeClass
	public static void setup(){
		courseList = Arrays.asList(
				new Course("Advanced Programming Practices", Program.SOEN, "6441", 4),
				new Course("Materials Engineering for Aerospace", Program.ENGR, "6441", 4),
				new Course("Helicopter Flight Dynamics", Program.MECH, "6231", 4),
				new Course("Semantic Computing", Program.SOEN, "6211", 4),
				new Course("PhD Seminar", Program.ENCS, "8011", 2),		
				new Course("Software Systems Requirements Specifications", Program.SOEN, "6481", 4));
	}
	
	
	@Test
	public void testNoCOurseFound(){
		int credits=ExamQuestion4.getCredits(courseList, Program.COMP, "6441");
		assertEquals(0,credits);
	}
	
	@Test
	public void testNullList(){
		List<Course> courseList = null;
		int credits=ExamQuestion4.getCredits(courseList, Program.COMP, "6441");
		assertEquals(0,credits);
	}
	
	@Test
	public void testCreditsFromList(){
		
		int credits=ExamQuestion4.getCredits(courseList, Program.SOEN, "6441");
		System.out.println(credits);
		assertEquals(4,credits);
	}
}
