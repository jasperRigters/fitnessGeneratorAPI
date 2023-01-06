package fitness.generator.API;

import jakarta.annotation.PostConstruct;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class ApiApplication {
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;


	public static void main(String[] args) {

		SpringApplication.run(ApiApplication.class, args);
	}
	@PostConstruct
	public void runFlywayMigrations() {
		Flyway flyway = Flyway.configure()
				.dataSource(dataSource)
				.baselineOnMigrate(true)
				.baselineVersion("0")
				.javaMigrations()
				.load();
		flyway.migrate();
	}
}
