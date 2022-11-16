package ui.gui;

import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;

// implements persistence for class Model
public class Persistor {
    private static final String JSON_STORE = "./data/textrmProject.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    public Persistor() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    // EFFECTS: saves the project to file
    void saveProject(Model model) {
        try {
            jsonWriter.open();
            jsonWriter.write(model.project);
            jsonWriter.close();
            System.out.println("Saved " + model.project.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads project from file
    void loadProject(Model model) {
        try {
            model.project = jsonReader.readProject();
            System.out.println("Loaded " + model.project.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}
