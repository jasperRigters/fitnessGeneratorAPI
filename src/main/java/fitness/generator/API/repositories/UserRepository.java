package fitness.generator.API.repositories;

import fitness.generator.API.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
