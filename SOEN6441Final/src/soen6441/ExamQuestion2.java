package soen6441;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import soen6441.Course.Program;

public class ExamQuestion2 {

	private static Course findLongestName (List<Course> courses) {
		return courses.stream().collect(Collectors.maxBy(Comparator.comparing((Course c) -> c.getName().length())))
				               .orElseThrow(RuntimeException::new);
	}
 	
	public static void main(String[] args) {
		System.out.println("Hello, SOEN6411 Exam Question 2!");
		
		List<Course> courses = Arrays.asList(
				new Course("Advanced Programming Practices", Program.SOEN, "6441", 4),
				new Course("Materials Engineering for Aerospace", Program.ENGR, "6441", 4),
				new Course("Helicopter Flight Dynamics", Program.MECH, "6231", 4),
				new Course("Semantic Computing", Program.SOEN, "6211", 4),
				new Course("PhD Seminar", Program.ENCS, "8011", 2),		
				new Course("Parallel Programming", Program.COMP, "6281", 4),
				new Course("Doctoral Research and Thesis", Program.COMP, "8901", 70),				
				new Course("Software Systems Requirements Specifications", Program.SOEN, "6481", 4));
		
		// Subtask a)
		Map<Program, List<Course>> coursesByType = courses.stream().collect(groupingBy(Course::getProgram));
		System.out.println("a) " + coursesByType);
		
		// Subtask b)
		Map<Boolean, List<Course>> partitionedCourses = courses.stream().collect(partitioningBy(course->course.getProgram().equals(Program.SOEN)));
		System.out.println("b) " + partitionedCourses);
		
		// Subtask c)
		
		//final Course courseLongestName = courses.stream().collect(maxBy(courseLengthComparator)).get();
		
		final Course courseLongestName=ExamQuestion2.findLongestName(courses.stream().collect(toList()));
		System.out.println("c) " + courseLongestName.getName() );
		
		System.out.println("Goodbye, SOEN6411 Exam Question 2!");
	}
}