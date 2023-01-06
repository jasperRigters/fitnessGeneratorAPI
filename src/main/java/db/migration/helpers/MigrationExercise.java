package db.migration.helpers;

import java.util.Map;

public class MigrationExercise {
    public MigrationExercise(String name, String instructions, Map<String, Integer> muscles, Map<String, Boolean> tools) {
        this.name = name;
        this.muscles = muscles;
        this.tools = tools;
    }

    public String name;
    public String instructions;
    public Map<String, Integer> muscles;
    public Map<String, Boolean> tools;
}


