package fitness.generator.API.models;

import jakarta.persistence.*;

@Entity
@Table(name = "exercise_muscle")
public class ExerciseMuscle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name = "muscle_id")
    private Muscle muscle;

    private Integer load;

    // getters and setters

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Muscle getMuscle() {
        return muscle;
    }

    public void setMuscle(Muscle muscle) {
        this.muscle = muscle;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }
}