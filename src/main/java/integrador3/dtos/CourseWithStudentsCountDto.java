package integrador3.dtos;

public class CourseWithStudentsCountDto {
	
	private int id;
	private String name;
	private int studentsCount;
	
	public CourseWithStudentsCountDto(int id, String name, int studentsCount) {
		super();
		this.id = id;
		this.name = name;
		this.studentsCount = studentsCount;
	}
	public CourseWithStudentsCountDto() {}

	public int getId() { return id; }
	public String getName() { return name; }
	public int getStudentsCount() { return studentsCount; }
}