package fitness.generator.API.services.impl;

import fitness.generator.API.models.Muscle;
import fitness.generator.API.repositories.MuscleRepository;
import fitness.generator.API.services.MuscleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MuscleServiceImpl implements MuscleService {

    private final MuscleRepository muscleRepository;

    @Autowired
    public MuscleServiceImpl(MuscleRepository muscleRepository) {
        this.muscleRepository = muscleRepository;
    }

    @Override
    public Muscle saveMuscle(Muscle muscle){
        return muscleRepository.save(muscle);
    }
}
