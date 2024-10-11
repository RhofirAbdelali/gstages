package miage.abdelali.ari.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import miage.abdelali.ari.Entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findByFirstName(String firstName);

	List<Student> findByLastName(String lastName);

	Student findById(long id);

	Student findByEmail(String email);

}
