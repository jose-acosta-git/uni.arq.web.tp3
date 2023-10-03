package integrador3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import integrador3.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
