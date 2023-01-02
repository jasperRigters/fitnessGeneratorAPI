package fitness.generator.API.services.impl;

import fitness.generator.API.models.Tool;
import fitness.generator.API.repositories.ToolRepository;
import fitness.generator.API.services.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToolServiceImpl implements ToolService {

    private final ToolRepository toolRepository;

    @Autowired
    public ToolServiceImpl(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    @Override
    public Tool saveTool(Tool tool) {
        return toolRepository.save(tool);
    }

    @Override
    public List<Tool> getAllTools() {
        return toolRepository.findAll();
    }

    @Override
    public Optional<Tool> findToolById(Long id) {
        return toolRepository.findById(id);
    }

    @Override
    public Optional<Tool> findToolByName(String name) {
        return toolRepository.findByName(name);
    }
}
