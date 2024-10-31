package miage.abdelali.ari.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miage.abdelali.ari.Entities.Stage;
import miage.abdelali.ari.Repositories.StageRepository;
import miage.abdelali.ari.Services.StageService;

@Service
public class StageServiceImpl implements StageService {

	@Autowired
	private StageRepository stageRepository;

	@Override
	public List<Stage> getAllStages() {
		return stageRepository.findAll();
	}

	@Override
	public Stage getStageById(long id) {
		return stageRepository.findById(id);
	}

	@Override
	public List<Stage> getStageByName(String name) {
		return stageRepository.findByName(name);
	}

	@Override
	public Stage createStage(String name, String description) {
		Stage stage = new Stage(name, description);
		stageRepository.save(stage);
		return stage;
	}

	@Override
	public void deleteStage(long id) {
		stageRepository.deleteById(id);
	}

	@Override
	public Stage updateStage(long id, String name, String description) {
		Stage stageToUpdate = stageRepository.findById(id);
		if (stageToUpdate == null) {
			throw new RuntimeException("Stage not found with id: " + id);
		}
		stageToUpdate.setName(name);
		stageToUpdate.setDescription(description);
		return stageRepository.save(stageToUpdate);
	}

}
