package miage.abdelali.ari.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miage.abdelali.ari.Dto.StudentDto;
import miage.abdelali.ari.Entities.Student;

@Service
public class StudentDtoMapper {
	@Autowired
	private ModelMapper modelMapper;

	public StudentDto toDto(Student entity) {
		return modelMapper.map(entity, StudentDto.class);
	}

	public void updateEntity(StudentDto src, Student target) {
		modelMapper.map(src, target);
	}

	public Student toEntity(StudentDto student) {
		return modelMapper.map(student, Student.class);
	}
}
