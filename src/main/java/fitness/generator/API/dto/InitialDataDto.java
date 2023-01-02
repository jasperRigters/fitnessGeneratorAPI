package fitness.generator.API.dto;

import fitness.generator.API.models.Muscle;
import fitness.generator.API.models.Tool;

import java.util.List;

public class InitialDataDto {
    private List<Muscle> muscles;

    private List<Tool> tools;

    public List<Muscle> getMuscles() {
        return muscles;
    }

    public void setMuscles(List<Muscle> muscles) {
        this.muscles = muscles;
    }

    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }
}
