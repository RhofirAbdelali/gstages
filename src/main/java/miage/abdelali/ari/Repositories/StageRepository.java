package miage.abdelali.ari.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import miage.abdelali.ari.Entities.Stage;

public interface StageRepository extends JpaRepository<Stage, Long> {
	List<Stage> findByName(String name);

	List<Stage> findByDescription(String description);

	Stage findById(long id);

}
