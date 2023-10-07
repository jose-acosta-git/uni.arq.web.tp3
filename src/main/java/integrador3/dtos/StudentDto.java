package integrador3.dtos;

public class StudentDto {

	private int dni;
	private String name;
	private String lastName;
	private int age;
	private String gender;
	private String city;
	private int notebookNumber;
	
	public StudentDto(int dni, String name, String lastName, int age, String gender, String city,
			int notebookNumber) {
		super();
		this.dni = dni;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.city = city;
		this.notebookNumber = notebookNumber;
	}

	public int getDni() { return dni; }
	public String getName() { return name; }
	public String getLastName() { return lastName; }
	public int getAge() { return age; }
	public String getGender() { return gender; }
	public String getCity() { return city; }
	public int getNotebookNumber() { return notebookNumber; }
}