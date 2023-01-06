package fitness.generator.API.models;

import jakarta.persistence.*;

import java.util.Set;

@Table(name = "exercises")
@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String instructions;

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL)
    private Set<ExerciseMuscle> exerciseMuscles;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL)
    private Set<ExerciseTool> tools;

    // getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Set<ExerciseMuscle> getExerciseMuscles() {
        return exerciseMuscles;
    }

    public void setExerciseMuscles(Set<ExerciseMuscle> exerciseMuscles) {
        this.exerciseMuscles = exerciseMuscles;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<ExerciseTool> getTools() {
        return tools;
    }

    public void setTools(Set<ExerciseTool> tools) {
        this.tools = tools;
    }
}
