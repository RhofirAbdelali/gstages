package miage.abdelali.ari.Controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import miage.abdelali.ari.Dto.StudentDto;
import miage.abdelali.ari.Entities.Student;
import miage.abdelali.ari.Mapper.StudentDtoMapper;
import miage.abdelali.ari.Services.Impl.StudentServiceImpl;

@RestController
@RequestMapping("students")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

	@Autowired
	public StudentServiceImpl studentService;

	@Autowired
	private StudentDtoMapper studentDtoMapper;

	@GetMapping
	public List<StudentDto> getAllStudents() {
		List<Student> students = studentService.getAllStudents();
		return students.stream().map(studentDtoMapper::toDto).collect(Collectors.toList());
	}

	@GetMapping("/id/{id}")
	public StudentDto getStudentById(@PathVariable long id) {
		Student student = studentService.getStudentById(id);
		return studentDtoMapper.toDto(student);
	}

	@GetMapping("/firstname/{firstName}")
	public List<StudentDto> getStudentsByFirstName(@PathVariable String firstName) {
		List<Student> students = studentService.getStudentsByFirstName(firstName);
		return students.stream().map(studentDtoMapper::toDto).collect(Collectors.toList());
	}

	@GetMapping("/lastname/{lastName}")
	public List<StudentDto> getStudentsByLastName(@PathVariable String lastName) {
		List<Student> students = studentService.getStudentsByLastName(lastName);
		return students.stream().map(studentDtoMapper::toDto).collect(Collectors.toList());
	}

	@GetMapping("/email/{email}")
	public StudentDto getStudentByEmail(@PathVariable String email) {
		Student student = studentService.getStudentByEmail(email);
		return studentDtoMapper.toDto(student);
	}

	@PostMapping("/addstudent")
	public StudentDto createStudent(@RequestBody StudentDto studentDto) {
		Student student = studentDtoMapper.toEntity(studentDto);
		Student createStudent = studentService.save(student);
		return studentDtoMapper.toDto(createStudent);
	}
	
	@DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
    }
	
	@PutMapping("/update/{id}")
    public StudentDto updateStudent(@PathVariable long id, @RequestBody StudentDto studentDto) {
		Long stageId = studentDto.getStageId();
        Student updatedStudent = studentService.updateStudent(id, studentDto.getFirstName(), studentDto.getLastName(), studentDto.getEmail(), stageId);
        return studentDtoMapper.toDto(updatedStudent);
    }
}
