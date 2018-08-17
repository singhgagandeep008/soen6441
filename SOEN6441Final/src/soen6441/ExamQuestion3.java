package soen6441;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import soen6441.Course.Program;

public class ExamQuestion3 {

	// Subtask a)
	private static CompletionStage<Integer> addCredits (List<Course> courses) {
		CompletableFuture<Integer> future = new CompletableFuture<>();
		
		new Thread(() -> {
			try {
				int sumCredits = courses.stream().map(course->course.getCredits()).reduce(0, (a,b)->a+b);
				future.complete(sumCredits);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
		return future;
		
	}
	
	private static CompletionStage<Boolean> checkcourse(Integer sum) {
		CompletableFuture<Boolean> future = new CompletableFuture<>();
		
		
		new Thread(() -> {
			try {
				if(sum>50)
					future.complete(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
		return future;
		
	}
 		
 	public static void main(String[] args) {
		System.out.println("Hello, SOEN6411 Exam Question 3!");
		
		List<Course> courses = Arrays.asList(
				new Course("Advanced Programming Practices", Program.SOEN, "6441", 4),
				new Course("Materials Engineering for Aerospace", Program.ENGR, "6441", 4),
				new Course("Helicopter Flight Dynamics", Program.MECH, "6231", 4),
				new Course("Semantic Computing", Program.SOEN, "6211", 4),
				new Course("PhD Seminar", Program.ENCS, "8011", 2),		
				new Course("Parallel Programming", Program.COMP, "6281", 4),
				new Course("Doctoral Research and Thesis", Program.COMP, "8901", 70),				
				new Course("Software Systems Requirements Specifications", Program.SOEN, "6481", 4));
		
		// Subtask a) -- see method addCredits above
		final CompletionStage<Integer> futureSum = addCredits(courses);
		
		// Subtask b)
		System.out.println("Credits"+futureSum.toCompletableFuture().join());
		
		// Subtask c)
		 final CompletionStage<Boolean> futureStatus = addCredits(courses).thenCompose(sum->checkcourse(sum));
		 System.out.println("RESULT FO TEST"+futureStatus.toCompletableFuture().join());
				 
				 
		 

				 
				 
		
		System.out.println("Goodbye, SOEN6411 Exam Question 3!");
	}
}
