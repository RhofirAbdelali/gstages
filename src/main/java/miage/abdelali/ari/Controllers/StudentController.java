package miage.abdelali.ari.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import miage.abdelali.ari.Entities.Student;
import miage.abdelali.ari.Repositories.StudentRepository;

@RestController
@RequestMapping("students")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}

	@GetMapping("/id/{id}")
	public Student getStudentById(@PathVariable long id) {
		return studentRepository.findById(id);
	}
	
	@GetMapping("/firstname/{firsName}")
	public List<Student> getStudentsByFirstName(@PathVariable String firstName){
		return studentRepository.findByFirstName(firstName);
	}
	
	@GetMapping("/lastname/{lastName}")
	public List<Student> getStudentsByLastName(@PathVariable String lastName){
		return studentRepository.findByLastName(lastName);
	}
	
	@GetMapping("/email/{email}")
	public Student getStudentByEmail(@PathVariable String email) {
		return studentRepository.findByEmail(email);
	}
}
