package fitness.generator.API.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "muscles")
public class Muscle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "muscle")
    private Set<ExerciseMuscle> exercises;

    // getters and setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ExerciseMuscle> getExerciseMuscles() {
        return exercises;
    }

    public void setExerciseMuscles(Set<ExerciseMuscle> exerciseMuscles) {
        this.exercises = exerciseMuscles;
    }
}