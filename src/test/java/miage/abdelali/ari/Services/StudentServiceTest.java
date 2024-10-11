package miage.abdelali.ari.Services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import miage.abdelali.ari.Entities.Student;
import miage.abdelali.ari.Services.Impl.StudentServiceImpl;

@SpringBootTest
public class StudentServiceTest {
	@Autowired
	private StudentServiceImpl studentService;

	@Test
	void testGetStudentById() {
		Student student = studentService.getStudentById(1L);
		assertThat(student).isNotNull();
		assertThat(student.getFirstName()).isEqualTo("Abdelali");
	}

}
