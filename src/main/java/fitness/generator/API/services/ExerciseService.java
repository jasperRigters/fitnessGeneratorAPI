package fitness.generator.API.services;

import fitness.generator.API.models.Exercise;

import java.util.List;

public interface ExerciseService {

    public Exercise saveExercise(Exercise exercise);

    public List<Exercise> findAllExercises();

}
