package integrador3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import integrador3.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	List<Student> findAllByOrderByLastNameAsc();
	Student findByNotebookNumber(int notebookNumber);
}