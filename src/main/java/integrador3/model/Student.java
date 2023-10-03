package integrador3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
	private String last_name;
	
	@Column
	private int age;
	
	@Column
	private String gender;
	
	@Column
	private String city;
	
	@Column(unique = true)
	private int notebook_number;

	public Student(int dni, String name, String last_name, int age, String gender, String city,
			int notebook_number) {
		super();
		this.dni = dni;
		this.name = name;
		this.last_name = last_name;
		this.age = age;
		this.gender = gender;
		this.city = city;
		this.notebook_number = notebook_number;
	}
	
    // Default constructor, needed by Hibernate
    public Student() {}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getNotebook_number() {
		return notebook_number;
	}

	public void setNotebook_number(int notebook_number) {
		this.notebook_number = notebook_number;
	}

	public int getId() {
		return id;
	}
}