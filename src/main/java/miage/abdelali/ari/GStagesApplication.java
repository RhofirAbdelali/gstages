package miage.abdelali.ari;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import miage.abdelali.ari.Entities.Stage;
import miage.abdelali.ari.Entities.Student;
import miage.abdelali.ari.Repositories.StageRepository;
import miage.abdelali.ari.Repositories.StudentRepository;

@SpringBootApplication
public class GStagesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GStagesApplication.class, args);
	}

	@Bean
	CommandLineRunner demo(StudentRepository studentRepository, StageRepository stageRepository) {
		return (args) -> {
			studentRepository.save(new Student("Abdelali", "Rhofir", "Abdo.rhofir@gmail.com"));
			studentRepository.save(new Student("Karim", "Benlala", "karim@gmail.com"));
			studentRepository.save(new Student("Sami", "Essou", "Sami@gmail.com"));
			stageRepository.save(new Stage("Application Mobile", "Développement d'une application mobile avec Flutter"));
			stageRepository.save(new Stage("Dashboard", "Développement d'un tableau de bord avec Power BI"));
			stageRepository.save(new Stage("Application Web", "Développement d'une application web avec Spring Boot et React"));
		};
	}

}
