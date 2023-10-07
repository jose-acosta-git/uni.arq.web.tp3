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
public class Student {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private int dni;
	
	@Column	
	private String name;
	
	@Column
	private String lastName;
	
	@Column
	private int age;
	
	@Column
	private String gender;
	
	@Column
	private String city;
	
	@Column(unique = true)
	private int notebookNumber;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
	private List<Enrollment> courses;

	public Student(int dni, String name, String lastName, int age, String gender, String city,
			int notebookNumber) {
		super();
		this.dni = dni;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.city = city;
		this.notebookNumber = notebookNumber;
		this.courses = new ArrayList<>();
	}
	
    // Default constructor, needed by Hibernate
    public Student() {}

	public int getDni() {
		return dni;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getCity() {
		return city;
	}

	public int getNotebookNumber() {
		return notebookNumber;
	}

	public int getId() {
		return id;
	}
}