package db.migration;

import db.migration.helpers.MigrationExercise;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;


public class V2__Populate_Exercises extends BaseJavaMigration {

    public void migrate(Context context) throws Exception {

        for (MigrationExercise exercise : getExercises()) {
            //Insert exercise into database
            try (Statement statement = context.getConnection().createStatement()) {
                statement.execute("INSERT INTO exercises (name, instructions) VALUES ('" + exercise.name + ", " + exercise.instructions + "')");

                //Retrieve id of saved exercise
                try (ResultSet result = statement.executeQuery("SELECT id FROM exercises WHERE name = '" + exercise.name + "'")) {
                    if (result.next()) {
                        Integer exerciseId = result.getInt(1);

                        //Insert ExerciseMuscles into database
                        for (Map.Entry<String, Integer> muscle : exercise.muscles.entrySet()) {
                            insertExerciseMuscle(context, exerciseId, muscle.getKey(), muscle.getValue());
                        }

                        //Insert ExerciseTools into database
                        for (Map.Entry<String, Boolean> tool : exercise.tools.entrySet()) {
                            if(shouldBeNull().contains(tool.getKey())) {
                                insertExerciseTool(context, exerciseId, tool.getKey(), null);
                            } else {
                                insertExerciseTool(context, exerciseId, tool.getKey(), tool.getValue());
                            }
                        }
                    }
                }
            }
        }
    }

    public void insertExerciseMuscle(Context context, int exerciseId, String muscleName, int load) throws Exception {
        try (Statement statement = context.getConnection().createStatement()) {
            ResultSet result = statement.executeQuery("SELECT id FROM muscles WHERE name = '" + muscleName + "'");

            if (result.next()) {
                int muscleId = result.getInt(1);

                try {
                    statement.execute("INSERT INTO exercise_muscle (exercise_id, muscle_id, load) VALUES (" + exerciseId + ", " + muscleId + ", " + load + ")");
                } catch (Exception e) {
                    System.out.println("Error inserting exercise_muscle");
                }
            } else {
                throw new Exception("Muscle " + muscleName + " not found");
            }
        }
    }

    public void insertExerciseTool(Context context, int exerciseId, String toolName, Boolean required) throws Exception {
        try (Statement statement = context.getConnection().createStatement()){
            ResultSet result = statement.executeQuery("SELECT id FROM tools WHERE name = '" + toolName + "'");

            if (result.next()){
                int toolId = result.getInt(1);

                try {
                    statement.execute("INSERT INTO exercise_tool (exercise_id, tool_id, is_required) VALUES (" + exerciseId + ", " + toolId + ", " + required + ")");
                } catch (Exception e) {
                    System.out.println("Error inserting exercise_tool");
                }
            } else {
            throw new Exception("Tool " + toolName + " not found");
            }
        }
    }
    public List<MigrationExercise> getExercises() {
         return List.of(
             new MigrationExercise("Bench Press",
                     "Lie flat on a bench, plant your feet firmly on the ground, keep your hands shoulder-width apart and your upper arms at a 45 degree angle to your torso. Make sure your elbows do not go below your shoulders on the way down.",
                     Map.of("Chest", 3, "Triceps", 1,"Anterior Deltoids", 2),
                     Map.of("Dumbbells", false, "Barbell", false, "Bench", true)
             ),
            new MigrationExercise("Flyes",
                    "Keep your hands straight out from chest, your wrists straight and your chest puffed. Let your elbows bend slightly as you move back until your elbows are just behind your back and push back out.",
                    Map.of("Chest", 3, "Triceps", 1, "Anterior Deltoids", 1),
                    Map.of("Dumbbells", true, "Cables", false, "Bench", true)
            ),
             new MigrationExercise("Squats",
                     "Stand with your feet shoulder-width apart and your toes pointed slightly outward. Keep your back straight and your chest up. Lower your hips back and down as if you were going to sit in a chair until your upper legs are parallel to the ground. Keep your knees behind your toes and your weight in your heels.",
                     Map.of("Quadriceps", 3, "Glutes", 3, "Hamstrings", 2, "Calves", 1, "Abs", 1,"Obliques", 1, "Lower Back", 1),
                     Map.of("Dumbbells", false, "Barbell", false, "Kettlebell", false, "Bodyweight", false)
             ),
             new MigrationExercise("Deadlifts",
                     "Stand with your feet hip-width apart, bend your knees until you can reach the bar and grab it with your hands slightly wider than shoulder-width apart while keeping your back straight. Lift the bar off the ground until you stand upright, while keeping your back straight and driving your heels into the ground.",
                     Map.of("Lower Back", 3, "Glutes", 3, "Hamstrings", 3, "Quadriceps", 2, "Trapezius", 1 ,"Calves", 1,"Lattisimus Dorsi", 1, "Forearms", 1, "Abs", 1),
                     Map.of("Barbell", true)
             ),
             new MigrationExercise("Bicep Curls",
                     "Stand up straight while keeping your back straight and your chest up. Keep your elbows close to your side and locked in place as much as possible while curling the weight up and down. Make sure your arms are fully extended on the downward movement.",
                     Map.of("Biceps", 3, "Brachialis", 2),
                     Map.of("Barbell", false, "Dumbbell", false, "Cables", false, "Machine", false)
             ),
             new MigrationExercise("Push Ups",
                     "Place your hands slightly wider than shoulder-width apart. Lower your body down until your chest nearly touches the ground while making sure your elbows dont flare out too much. Keep your core engaged and your back straight and push back up. ",
                     Map.of("Chest", 3, "Triceps", 1,"Anterior Deltoids", 2),
                     Map.of("Bodyweight", true)
             ),
             new MigrationExercise("Lateral Raises",
                     "Stand with your feet shoulder-width apart and your hands to your side (in front of your hip if you are using cables) and you palms facing inwards. Keep your arms straight and raise them until they are parallel to the ground. Avoid shrugging you shoulders.",
                     Map.of("Medial Deltoids", 3, "Forearms", 1),
                     Map.of("Dumbells", true, "Cables", false, "Machine", false)
             )
         );
    }

    public List<String> shouldBeNull() {
        return List.of("Cables", "Bodyweight", "Machine");
    }
}

