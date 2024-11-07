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
			Stage stage1 = new Stage("Application Mobile", "Développement d'une application mobile avec Flutter");
			Stage stage2 = new Stage("Dashboard", "Développement d'un tableau de bord avec Power BI");
			Stage stage3 = new Stage("Application Web", "Développement d'une application web avec Spring Boot et React");
			stageRepository.save(stage1);
			stageRepository.save(stage2);
			stageRepository.save(stage3);
			Student student1 = new Student("Abdelali", "Rhofir", "Abdo.rhofir@gmail.com");
			Student student2 =new Student("Karim", "Benlala", "karim@gmail.com");
			Student student3 =new Student("Sami", "Essou", "Sami@gmail.com");
			student1.setStage(stage1);
			student2.setStage(stage2);
			student3.setStage(stage3);
			studentRepository.save(student1);
			studentRepository.save(student2);
			studentRepository.save(student3);
		};
	}

}
