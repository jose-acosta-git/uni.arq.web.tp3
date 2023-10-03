package integrador3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {
	
	@Id @GeneratedValue (strategy = GenerationType.AUTO)
	private int id;

	@Column(unique = true)
	private String name;
	
	public Course(String name) {
		super();
		this.name = name;
	}

	// Default constructor, needed by Hibernate
	public Course() {}

	public int getId() { return id; }
	public String getName() { return name; }
}
