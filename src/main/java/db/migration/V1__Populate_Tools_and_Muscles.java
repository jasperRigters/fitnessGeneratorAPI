package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.Statement;
import java.util.List;


public class V1__Populate_Tools_and_Muscles extends BaseJavaMigration {

    public void migrate(Context context) throws Exception {

        try (Statement insert = context.getConnection().createStatement()) {
            for (String tool:
                 getTools()) {
                insert.execute("INSERT INTO tools (name) VALUES ('" + tool + "')");
            }
        }

        try (Statement insert = context.getConnection().createStatement()) {
            for ( String muscle:
                 getMuscles()) {
                insert.execute("INSERT INTO muscles (name) VALUES ('" + muscle + "')");
            }
        }
    }

    private List<String> getTools() {
        return List.of("Dumbbells", "Barbell", "Kettlebell", "Bodyweight", "Machine", "Cables", "Bench");
    }

    private List<String> getMuscles() {
        return List.of("Chest", "Biceps", "Brachialis", "Triceps", "Obliques", "Abs", "Trapezius", "Lattisimus Dorsi", "Lower Back",
                "Anterior Deltoids", "Posterior Deltoids", "Medial Deltoids", "Forearms", "Glutes", "Quadriceps", "Hamstrings", "Calves");
    }
}

