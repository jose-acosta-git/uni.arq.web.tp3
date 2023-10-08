package integrador3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import integrador3.model.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
	
	@Query("SELECT e FROM Enrollment e " +
			"WHERE e.course.name = :courseName " +
			"AND e.student.city = :cityName")
    List<Enrollment> findEnrollmentsByCourseNameAndCityName(@Param("courseName") String courseName, @Param("cityName") String cityName);
}