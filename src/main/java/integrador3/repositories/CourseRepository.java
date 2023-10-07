package integrador3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import integrador3.dtos.CourseWithStudentsCountDto;
import integrador3.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	@Query("SELECT NEW integrador3.dtos.CourseWithStudentsCountDto(c.id, c.name, SIZE(c.students)) FROM Course c WHERE SIZE(c.students) > 0 ORDER BY SIZE(c.students) DESC")
    List<CourseWithStudentsCountDto> findCoursesWithRegisteredStudentsOrderByStudentCount();
}