package miage.abdelali.ari.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import miage.abdelali.ari.Dto.StageDto;
import miage.abdelali.ari.Entities.Stage;
import miage.abdelali.ari.Mapper.StageDtoMapper;
import miage.abdelali.ari.Services.Impl.StageServiceImpl;

@RestController
@RequestMapping("stages")
public class StageController {

	@Autowired
	private StageServiceImpl stageService;
	
	@Autowired
	private StageDtoMapper stageDtoMapper;

	@GetMapping
	public List<Stage> getAllStages() {
		return stageService.getAllStages();
	}

	@GetMapping("/id/{id}")
	public Stage getStageById(@PathVariable long id) {
		return stageService.getStageById(id);
	}

	@GetMapping("/name/{name}")
	public List<Stage> getStageByName(@PathVariable String name) {
		return stageService.getStageByName(name);
	}
	
	@PostMapping("/addstage")
    public StageDto createStage(@RequestBody StageDto stageDto) {
        Stage stage = stageDtoMapper.toEntity(stageDto);
        Stage createdStage = stageService.createStage(stage.getName(), stage.getDescription());
        return stageDtoMapper.toDto(createdStage);
    }

    @PutMapping("/update/{id}")
    public StageDto updateStage(@PathVariable long id, @RequestBody StageDto stageDto) {
        Stage stageToUpdate = stageDtoMapper.toEntity(stageDto);
        Stage updatedStage = stageService.updateStage(id, stageToUpdate.getName(), stageToUpdate.getDescription());
        return stageDtoMapper.toDto(updatedStage);
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteStage(@PathVariable long id) {
		stageService.deleteStage(id);
    }

}
