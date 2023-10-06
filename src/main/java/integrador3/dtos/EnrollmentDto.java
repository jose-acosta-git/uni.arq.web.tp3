package integrador3.dtos;

import java.time.LocalDate;

public class EnrollmentDto {

	private Integer id;
	private String student;
	private String course;
	private LocalDate entryDate;
	private LocalDate exitDate;
	
	public EnrollmentDto(Integer id, String student, String course, LocalDate entry_date, LocalDate exit_date) {
		super();
		this.id = id;
		this.student = student;
		this.course = course;
		this.entryDate = entry_date;
		this.exitDate = exit_date;
	}
	
	public EnrollmentDto() {}
	
	public Integer getId() { return id; }
	public String getStudent() { return student; }
	public String getCourse() { return course; }
	public LocalDate getEntryDate() { return entryDate; }
	public LocalDate getExitDate() { return exitDate; }
}