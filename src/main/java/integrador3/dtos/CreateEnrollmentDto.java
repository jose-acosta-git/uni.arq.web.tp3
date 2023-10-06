package integrador3.dtos;

import java.time.LocalDate;

public class CreateEnrollmentDto {
	
	private Integer studentId;
	private Integer courseId;
	private LocalDate entryDate;
	private LocalDate exitDate;
	
	public CreateEnrollmentDto(Integer studentId, Integer courseId, LocalDate entryDate, LocalDate exitDate) {
		super();
		this.studentId = studentId;
		this.courseId = courseId;
		this.entryDate = entryDate;
		this.exitDate = exitDate;
	}
	
	public CreateEnrollmentDto() {}

	public Integer getStudentId() {return studentId;}
	public Integer getCourseId() {return courseId;}
	public LocalDate getEntryDate() {return entryDate;}
	public LocalDate getExitDate() {return exitDate;}
}
