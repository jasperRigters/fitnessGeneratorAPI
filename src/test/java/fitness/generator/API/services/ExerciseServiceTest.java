package fitness.generator.API.services;

import fitness.generator.API.repositories.ExerciseRepository;
import fitness.generator.API.services.impl.ExerciseServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
public class ExerciseServiceTest {
    @Mock
    private ExerciseRepository repository;

    @Autowired
    private ExerciseServiceImpl service;

}
