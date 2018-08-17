package soen6441;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import soen6441.Course.Program;

public class ExamQuestion5 {
	
	public static void main(String[] args) {
		System.out.println("Hello, SOEN6411 Exam Question 5!");
		
		List<Course> coursesJoe = Arrays.asList(
				new Course("Advanced Programming Practices", Program.SOEN, "6441", 4),
				new Course("Software Systems Requirements Specifications", Program.SOEN, "6481", 4));
		
		List<Student> students = Arrays.asList(
				new Student("Jane", 199999999L, Optional.empty()),
				new Student("Joe", 200000000L, Optional.of(coursesJoe))
				);
		
		// a) 
		//students.stream().map(student-> student.getCourses().ifPresent(student-> student.stream().map(student->String.format("%d :: %s", student.))));
	List<String> studnetlist=	students.stream().filter(student-> 
			student.getCourses().isPresent()).map(stud->
					String.format("%s::%s", stud.getId(),stud.getCourses().get())).collect(toList());
			System.out.println(studnetlist);
		
		
		// b) 
			
			List<String> studnetlist1=students.stream()
			.map(student->String.format("%s  ::  %s", student.getId(),student.getCourses())).collect(toList());
			
			System.out.println(studnetlist1);
		System.out.println("Goodbye, SOEN6411 Exam Question 5!");
	}
}
