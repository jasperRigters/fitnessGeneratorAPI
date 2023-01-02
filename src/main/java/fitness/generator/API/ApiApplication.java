package fitness.generator.API;

import fitness.generator.API.repositories.ToolRepository;
import fitness.generator.API.services.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {




	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);

	}

}
