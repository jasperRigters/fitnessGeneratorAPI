package fitness.generator.API.services.impl;

import fitness.generator.API.dto.InitialDataDto;
import fitness.generator.API.models.Muscle;
import fitness.generator.API.models.Tool;
import fitness.generator.API.repositories.MuscleRepository;
import fitness.generator.API.repositories.ToolRepository;
import fitness.generator.API.services.InitialDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitialDataServiceImpl implements InitialDataService {

    private final ToolRepository toolRepository;
    private final MuscleRepository muscleRepository;

    @Autowired
    public InitialDataServiceImpl(ToolRepository toolRepository, MuscleRepository muscleRepository) {
        this.toolRepository = toolRepository;
        this.muscleRepository = muscleRepository;
    }

    @Override
    public InitialDataDto getInitialData() {
       List<Muscle> muscles = muscleRepository.findAll();
       List<Tool> tools = toolRepository.findAll();

       InitialDataDto initialDataDto = new InitialDataDto();

       initialDataDto.setMuscles(muscles);
       initialDataDto.setTools(tools);

       return initialDataDto;
    }


}
