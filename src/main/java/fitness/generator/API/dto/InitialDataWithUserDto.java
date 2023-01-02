package fitness.generator.API.dto;

import fitness.generator.API.models.Muscle;
import fitness.generator.API.models.Tool;
import fitness.generator.API.models.User;

import java.util.List;

public class InitialDataWithUserDto {
    private List<User> users;
    private List<Muscle> muscles;
    private List<Tool> tools;
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

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

