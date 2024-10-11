package miage.abdelali.ari.Repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import miage.abdelali.ari.Entities.Student;

@SpringBootTest
public class StudentRepositoryTest {
	@Autowired
	private StudentRepository studentRepository;

	@Test
	void testFindByFirstName() {
		String firstName = "Karim";
		List<Student> students = studentRepository.findByFirstName(firstName);
		assertThat(students).isNotEmpty();
		assertThat(students.size()).isGreaterThan(0);
		assertThat(students.get(0).getFirstName()).isEqualTo(firstName);
	}

}
