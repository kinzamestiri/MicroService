package com.esprit.micro.candidatems;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.esprit.micro.candidatems.Repositories.CandidatRepository;
import com.esprit.micro.candidatems.entities.Candidat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CandidateMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandidateMsApplication.class, args);
	}

	@Autowired
	private CandidatRepository repository;

	@Bean
	public void run() {
		repository.save(new Candidat("Mariem", "Ch", "ma@esprit.tn"));
		repository.save(new Candidat("Sarra", "ab", "sa@esprit.tn"));
		repository.save(new Candidat("Mohamed", "ba", "mo@esprit.tn"));

		repository.findAll().forEach(System.out::println);
	}
}