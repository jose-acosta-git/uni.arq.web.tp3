package integrador3.dtos;

public class CourseDto {

	private String name;
	
	public CourseDto(String name) {
		super();
		this.name = name;
	}
	
	// Default constructor, needed by Hibernate
	public CourseDto() {}
	
	public String getName() { return this.name; }
}