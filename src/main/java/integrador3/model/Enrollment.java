package integrador3.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Enrollment {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;
	
	@Column
	private LocalDate entryDate;
	
	@Column
	private LocalDate exitDate;

	public Enrollment(Student student, Course course, LocalDate entryDate, LocalDate exitDate) {
		super();
		this.student = student;
		this.course = course;
		this.entryDate = entryDate;
		this.exitDate = exitDate;
	}
	
	// Default constructor, needed by Hibernate
	public Enrollment() {}

	public int getId() { return id; }
	public Student getStudent() { return student; }
	public Course getCourse() { return course; }
	public LocalDate getEntryDate() { return entryDate; }
	public LocalDate getExitDate() { return exitDate; }
}