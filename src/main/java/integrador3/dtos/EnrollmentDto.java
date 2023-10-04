package integrador3.dtos;

import java.time.LocalDate;

public class EnrollmentDto {

	private StudentDto student;
	private CourseDto course;
	private LocalDate entryDate;
	private LocalDate exitDate;
	
	public EnrollmentDto(StudentDto student, CourseDto course, LocalDate entry_date, LocalDate exit_date) {
		super();
		this.student = student;
		this.course = course;
		this.entryDate = entry_date;
		this.exitDate = exit_date;
	}
	
	public EnrollmentDto() {}
	
	public StudentDto getStudent() { return student; }
	public CourseDto getCourse() { return course; }
	public LocalDate getEntryDate() { return entryDate; }
	public LocalDate getExitDate() { return exitDate; }
}