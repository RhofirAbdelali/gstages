package miage.abdelali.ari.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import miage.abdelali.ari.Entities.Stage;
import miage.abdelali.ari.Repositories.StageRepository;

@RestController
@RequestMapping("stages")
public class StageController {
	
	@Autowired
	private StageRepository stageRepository;
	
	@GetMapping
	public List<Stage> getAllStage() {
		return stageRepository.findAll();
	}
	
	@GetMapping("/id/{id}")
	public Stage getStageById(@PathVariable long id) {
		return stageRepository.findById(id);
	}
	
	@GetMapping("/name/{name}")
	public List<Stage> getStageByName(@PathVariable String name){
		return stageRepository.findByName(name);
	}

}
