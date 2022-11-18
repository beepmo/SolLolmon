package ui.gui;

import model.Project;
import model.User;

// let the GUI know about SolLolmon model
public class Model {
    Project project;
    User user;
    Persistor persistor;

    // EFFECTS: construct model with pre-made persistor; no project, no user
    public Model() {
        persistor = new Persistor();
    }

    // EFFECTS: load project from file
    void loadProject() {
        persistor.loadProject(this);
    }

    // EFFECTS: save project to file
    void saveProject(Model project) {
        persistor.saveProject(project);
    }

    // EFFECTS: set project as new project with given title
    void createProject(String title) {
        System.out.println("Creating new project: " + title);
        this.project = new Project(title);
    }

    // EFFECTS: set user as given user
    void logUser(User user) {
        this.user = user;
    }
}
