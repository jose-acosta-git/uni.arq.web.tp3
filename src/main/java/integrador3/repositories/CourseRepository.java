package integrador3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import integrador3.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {}