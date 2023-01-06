package fitness.generator.API.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tools")
public class Tool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "tool")
    private Set<ExerciseTool> exercises;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ExerciseTool> getExercises() {
        return exercises;
    }
}