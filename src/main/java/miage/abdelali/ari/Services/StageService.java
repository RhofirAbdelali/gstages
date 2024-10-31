package miage.abdelali.ari.Services;

import java.util.List;

import miage.abdelali.ari.Entities.Stage;

public interface StageService {
	public List<Stage> getAllStages();

	public Stage getStageById(long id);

	public List<Stage> getStageByName(String name);

	public Stage createStage(String name, String description);

	public Stage updateStage(long id, String name, String description);

	void deleteStage(long id);

}