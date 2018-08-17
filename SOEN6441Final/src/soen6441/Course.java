package soen6441;

public final class Course {
	public enum Program { SOEN, COMP, ENCS, MECH, ENGR }
	
	private final String name;
	private final Program program;
	private final String number;
	private final int credits;
	
	public final String getName() {
		return name;
	}
	public final Program getProgram() {
		return program;
	}
	
	public final String getNumber() {
		return number;
	}

	public final int getCredits() {
		return credits;
	}
	
	public Course(String name, Program program, String number, int credits) {
		this.name = name;
		this.program = program;
		this.number = number;
		this.credits = credits;
	}
	
	@Override
	public String toString() {
		return program.name() + number + " " + name + " ("+ credits +" credits)";
	}
}
