package miage.abdelali.ari.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miage.abdelali.ari.Dto.StudentDto;
import miage.abdelali.ari.Entities.Stage;
import miage.abdelali.ari.Entities.Student;
import miage.abdelali.ari.Services.Impl.StageServiceImpl;

@Service
public class StudentDtoMapper {
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
    private StageServiceImpl stageService; 
	
	public StudentDto toDto(Student entity) {
		StudentDto dto = modelMapper.map(entity, StudentDto.class);
		if (entity.getStage() != null) {
            dto.setStageId(entity.getStage().getId());
        }
        return dto;
	}

	public void updateEntity(StudentDto src, Student target) {
		modelMapper.map(src, target);
		if (src.getStageId() != null) {
            Stage stage = stageService.getStageById(src.getStageId());
            target.setStage(stage);
        }
	}

	public Student toEntity(StudentDto studentDto) {
		Student student = modelMapper.map(studentDto, Student.class);
		if (studentDto.getStageId() != null) {
            Stage stage = stageService.getStageById(studentDto.getStageId());
            student.setStage(stage);
        }
        return student;
	}
}
