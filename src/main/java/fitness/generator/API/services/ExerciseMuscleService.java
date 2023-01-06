package fitness.generator.API.services;

import fitness.generator.API.models.Exercise;
import fitness.generator.API.models.ExerciseMuscle;
import fitness.generator.API.models.Muscle;

import java.util.Set;

public interface ExerciseMuscleService {
    ExerciseMuscle createExerciseMuscle(Exercise exercise, Muscle muscle, Integer load);

    ExerciseMuscle saveExerciseMuscle(ExerciseMuscle exerciseMuscle);

    void saveExerciseMuscles(Set<ExerciseMuscle> exerciseMuscles);

}
