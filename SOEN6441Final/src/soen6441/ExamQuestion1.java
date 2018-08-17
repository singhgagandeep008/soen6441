package soen6441;



import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import soen6441.Course.Program;

public class ExamQuestion1 {

	public static void main(String[] args) {
		System.out.println("Hello, SOEN6411 Exam Question 1!");
		
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
		List<Course> fourCreditCourses = courses.stream().filter(course-> 4==course.getCredits()).collect(toList());
		System.out.println("a) " + fourCreditCourses);

		// Subtask b)
		int sumCredits = courses.stream().map(course->course.getCredits()).reduce(0, (a,b)->a+b);
		System.out.println("b) " + sumCredits);

		// Subtask c)
		boolean hasMegaCourse = courses.stream().anyMatch(course-> 50>course.getCredits());
		System.out.println("c) " + hasMegaCourse);
		
		// Subtask d)
		Optional<Course> c6441 = courses.stream().filter(course->"6441".equals(course.getNumber())).findFirst();
		System.out.println("d) " + c6441);
		
		// Subtask e)
		Set<String> courseWords = courses.stream().map(course->course.getName()).collect(toSet());
		System.out.println("e) " + courseWords);
		
		System.out.println("Goodbye, SOEN6411 Exam Question 1!");
	}
}
