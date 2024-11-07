package miage.abdelali.ari.Services;

import java.util.List;

import miage.abdelali.ari.Entities.Student;

public interface StudentService {
	public List<Student> getAllStudents();

	public Student getStudentById(long id);

	public List<Student> getStudentsByFirstName(String firstName);

	public List<Student> getStudentsByLastName(String lastName);

	public Student getStudentByEmail(String email);

	public Student createStudent(String firstName, String lastName, String email);
	
	public Student updateStudent(long id, String firstName, String lastName, String email, Long stageId);

	Student save(Student student);
	
	void deleteStudent(long id);
}
