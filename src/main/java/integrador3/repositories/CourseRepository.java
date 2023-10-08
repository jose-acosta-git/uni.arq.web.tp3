package integrador3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import integrador3.dtos.CourseReportDto;
import integrador3.dtos.CourseWithStudentsCountDto;
import integrador3.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	@Query("SELECT NEW integrador3.dtos.CourseWithStudentsCountDto(c.id, c.name, SIZE(c.students)) FROM Course c WHERE SIZE(c.students) > 0 ORDER BY SIZE(c.students) DESC")
    List<CourseWithStudentsCountDto> findCoursesWithRegisteredStudentsOrderByStudentCount();
	
	@Query("SELECT NEW integrador3.dtos.CourseReportDto(c.name, YEAR(s.entryDate), COALESCE(COUNT(s), 0), COALESCE(SUM(CASE WHEN s.exitDate IS NOT NULL THEN 1 ELSE 0 END), 0)) " +
	        "FROM Course c LEFT JOIN c.students s " +
	        "GROUP BY c.name, YEAR(s.entryDate)")
	List<CourseReportDto> generateCourseReport();
}