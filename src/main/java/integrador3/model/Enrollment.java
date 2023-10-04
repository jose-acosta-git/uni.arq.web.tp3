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
	private LocalDate entry_date;
	
	@Column
	private LocalDate exit_date;

	public Enrollment(Student student, Course course, LocalDate entry_date, LocalDate exit_date) {
		super();
		this.student = student;
		this.course = course;
		this.entry_date = entry_date;
		this.exit_date = exit_date;
	}
	
	// Default constructor, needed by Hibernate
	public Enrollment() {}

	public int getId() { return id; }
	public Student getStudent() { return student; }
	public Course getCourse() { return course; }
	public LocalDate getEntry_date() { return entry_date; }
	public LocalDate getExit_date() { return exit_date; }
}