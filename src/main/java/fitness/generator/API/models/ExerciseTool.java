package fitness.generator.API.models;

import jakarta.persistence.*;

@Entity
@Table(name = "exercise_tool")
public class ExerciseTool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name = "tool_id")
    private Tool tool;

    private Boolean isRequired;
}
