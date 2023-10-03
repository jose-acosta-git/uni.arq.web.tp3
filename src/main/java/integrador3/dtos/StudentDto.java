package integrador3.dtos;

public class StudentDto {

	private int dni;
	private String name;
	private String last_name;
	private int age;
	private String gender;
	private String city;
	private int notebook_number;
	
	public StudentDto(int dni, String name, String last_name, int age, String gender, String city,
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

	public int getDni() { return dni; }
	public String getName() { return name; }
	public String getLast_name() { return last_name; }
	public int getAge() { return age; }
	public String getGender() { return gender; }
	public String getCity() { return city; }
	public int getNotebook_number() { return notebook_number; }
}