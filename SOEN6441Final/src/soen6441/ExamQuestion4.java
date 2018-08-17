package soen6441;

import java.util.List;

import soen6441.Course.Program;

public class ExamQuestion4 {

	public static int getCredits (List<Course> courses, Program program, String number) {
		int credits = 0;
		if( courses != null) {
			for( Course c: courses ) {
				if( c.getProgram() == program && c.getNumber() == number) {
					credits = c.getCredits();
				}
			}
		}
		return credits;
	}
}
