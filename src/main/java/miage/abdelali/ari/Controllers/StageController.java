package miage.abdelali.ari.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import miage.abdelali.ari.Entities.Stage;
import miage.abdelali.ari.Services.Impl.StageServiceImpl;

@RestController
@RequestMapping("stages")
public class StageController {

	@Autowired
	private StageServiceImpl stageService;

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
	public Stage createStage(@RequestParam String name, @RequestParam String description) {
		return stageService.createStage(name, description);
	}

}
