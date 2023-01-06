package fitness.generator.API.services.impl;

import fitness.generator.API.models.Exercise;
import fitness.generator.API.models.ExerciseMuscle;
import fitness.generator.API.models.Muscle;
import fitness.generator.API.repositories.ExerciseMuscleRepository;
import fitness.generator.API.services.ExerciseMuscleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExerciseMuscleServiceImpl implements ExerciseMuscleService {

    private final ExerciseMuscleRepository exerciseMuscleRepository;

    @Autowired
    public ExerciseMuscleServiceImpl(ExerciseMuscleRepository exerciseMuscleRepository) {
        this.exerciseMuscleRepository = exerciseMuscleRepository;
    }

    @Override
    public ExerciseMuscle saveExerciseMuscle(ExerciseMuscle exerciseMuscle) {
        return exerciseMuscleRepository.save(exerciseMuscle);
    }

    @Override
    public ExerciseMuscle createExerciseMuscle(Exercise exercise, Muscle muscle, Integer load) {
        ExerciseMuscle exerciseMuscle = new ExerciseMuscle();
        exerciseMuscle.setExercise(exercise);
        exerciseMuscle.setMuscle(muscle);
        exerciseMuscle.setLoad(load);

        return exerciseMuscle;
    }

    @Override
     public void saveExerciseMuscles(Set<ExerciseMuscle> exerciseMuscles) {
        exerciseMuscleRepository.saveAll(exerciseMuscles);
    }
}
