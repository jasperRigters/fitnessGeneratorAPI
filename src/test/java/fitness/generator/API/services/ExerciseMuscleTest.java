package fitness.generator.API.services;

import fitness.generator.API.repositories.ExerciseMuscleRepository;
import fitness.generator.API.repositories.ExerciseRepository;
import fitness.generator.API.repositories.MuscleRepository;
import fitness.generator.API.services.impl.ExerciseMuscleServiceImpl;
import fitness.generator.API.services.impl.ExerciseServiceImpl;
import fitness.generator.API.services.impl.MuscleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(MockitoExtension.class)
public class ExerciseMuscleTest {

    @Autowired
    private ExerciseMuscleRepository repository;

    @Mock
    private ExerciseRepository exerciseRepository;

    @Mock
    private MuscleRepository muscleRepository;

    private ExerciseMuscleService service;

    private ExerciseService exerciseService;

    private MuscleService muscleService;

    @BeforeEach
    void setUp() {
        service = new ExerciseMuscleServiceImpl(repository);
        exerciseService = new ExerciseServiceImpl(exerciseRepository);
        muscleService = new MuscleServiceImpl(muscleRepository);
    }

    @Test
    void testCreateExerciseMuscle() {

    }

}
