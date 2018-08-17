package soen6441;

import java.util.List;
import java.util.Optional;

public class Student {
	private String name;
	private Long id;
	private Optional<List<Course>> courses;
	
	public Student(String name, Long id, Optional<List<Course>> courses) {
		super();
		this.name = name;
		this.id = id;
		this.courses = courses;
	}

	public final String getName() {
		return name;
	}

	public final Long getId() {
		return id;
	}

	public final Optional<List<Course>> getCourses() {
		return courses;
	}
}
