package miage.abdelali.ari.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miage.abdelali.ari.Dto.StageDto;
import miage.abdelali.ari.Entities.Stage;

@Service
public class StageDtoMapper {
	@Autowired
	private ModelMapper modelMapper;

	public StageDto toDto(Stage entity) {
		return modelMapper.map(entity, StageDto.class);
	}

	public void updateEntity(StageDto src, Stage target) {
		modelMapper.map(src, target);
	}

	public Stage toEntity(StageDto stage) {
		return modelMapper.map(stage, Stage.class);
	}
}