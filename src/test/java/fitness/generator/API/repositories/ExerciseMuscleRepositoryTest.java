package fitness.generator.API.repositories;

import fitness.generator.API.models.Exercise;
import fitness.generator.API.models.ExerciseMuscle;
import fitness.generator.API.models.Muscle;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ExerciseMuscleRepositoryTest {

    @Autowired
    private ExerciseMuscleRepository repository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private MuscleRepository muscleRepository;
@Disabled
    @Test
    void testSaveExerciseMuscle() {
        Exercise exercise = new Exercise();
        exercise.setName("Bench Press");
        exerciseRepository.save(exercise);

        Muscle muscle = new Muscle();
        muscle.setName("Chest");
        muscleRepository.save(muscle);

        ExerciseMuscle exerciseMuscle = new ExerciseMuscle();
        exerciseMuscle.setExercise(exercise);
        exerciseMuscle.setMuscle(muscle);
        exerciseMuscle.setLoad(100);
        ExerciseMuscle savedExerciseMuscle = repository.save(exerciseMuscle);

        assertThat(savedExerciseMuscle.getExercise().getName()).isEqualTo("Bench Press");
        assertThat(savedExerciseMuscle.getMuscle().getName()).isEqualTo("Chest");
    }
}
