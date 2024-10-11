package miage.abdelali.ari.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import miage.abdelali.ari.Entities.Student;
import miage.abdelali.ari.Services.Impl.StudentServiceImpl;

@RestController
@RequestMapping("students")
public class StudentController {

	@Autowired
	public StudentServiceImpl studentService;

	@GetMapping
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@GetMapping("/id/{id}")
	public Student getStudentById(@PathVariable long id) {
		return studentService.getStudentById(id);
	}

	@GetMapping("/firstname/{firstName}")
	public List<Student> getStudentsByFirstName(@PathVariable String firstName) {
		return studentService.getStudentsByFirstName(firstName);
	}

	@GetMapping("/lastname/{lastName}")
	public List<Student> getStudentsByLastName(@PathVariable String lastName) {
		return studentService.getStudentsByLastName(lastName);
	}

	@GetMapping("/email/{email}")
	public Student getStudentByEmail(@PathVariable String email) {
		return studentService.getStudentByEmail(email);
	}

	@PostMapping("/addstudent")
	public Student createStudent(@RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String email) {
		return studentService.createStudent(firstName, lastName, email);
	}
}
