package fitness.generator.API.services;

import fitness.generator.API.models.Tool;
import fitness.generator.API.repositories.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ToolService {

     Tool saveTool(Tool tool);

     List<Tool> getAllTools();

     Optional<Tool> findToolById(Long id);

     Optional<Tool> findToolByName(String name);
}