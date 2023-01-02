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

    private int load;

    // getters and setters
}