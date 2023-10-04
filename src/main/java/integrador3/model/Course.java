package integrador3.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Course {
	
	@Id @GeneratedValue (strategy = GenerationType.AUTO)
	private int id;

	@Column(unique = true)
	private String name;
	
	@OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
	private List<Enrollment> students;
	
	public Course(String name) {
		super();
		this.name = name;
		this.students = new ArrayList<>();
	}

	// Default constructor, needed by Hibernate
	public Course() {}

	public int getId() { return id; }
	public String getName() { return name; }
}
