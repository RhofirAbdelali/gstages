package miage.abdelali.ari.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miage.abdelali.ari.Entities.Student;
import miage.abdelali.ari.Repositories.StudentRepository;
import miage.abdelali.ari.Services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(long id) {
		return studentRepository.findById(id);
	}

	@Override
	public List<Student> getStudentsByFirstName(String firstName) {
		return studentRepository.findByFirstName(firstName);
	}

	@Override
	public List<Student> getStudentsByLastName(String lastName) {
		return studentRepository.findByLastName(lastName);
	}

	@Override
	public Student getStudentByEmail(String email) {
		return studentRepository.findByEmail(email);
	}

	@Override
	public Student createStudent(String firstName, String lastName, String email) {
		Student student = new Student(firstName, lastName, email);
		studentRepository.save(student);
		return student;
	}

	@Override
	public void deleteStudent(long id) {
		studentRepository.deleteById(id);
	}

	@Override
	public Student updateStudent(long id, String firstName, String lastName, String email) {
		Student studentToUpdate = studentRepository.findById(id);
		if (studentToUpdate == null) {
			throw new RuntimeException("Student not found with id: " + id);
		}
		studentToUpdate.setFirstName(firstName);
		studentToUpdate.setLastName(lastName);
		studentToUpdate.setEmail(email);
		return studentRepository.save(studentToUpdate);
	}

}
