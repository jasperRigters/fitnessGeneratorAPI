package fitness.generator.API.services.impl;

import fitness.generator.API.models.Exercise;
import fitness.generator.API.repositories.ExerciseRepository;
import fitness.generator.API.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) { this.exerciseRepository = exerciseRepository; }

    @Override
    public Exercise saveExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }


}
