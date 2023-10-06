package integrador3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import integrador3.model.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {}