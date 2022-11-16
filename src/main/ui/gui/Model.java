package ui.gui;

import model.Project;
import model.User;

public class Model {
    Project project;
    User user;
    Persistor persistor;

    public Model() {
        persistor = new Persistor();
    }

    void loadProject() {
        persistor.loadProject(this);
    }

    void createProject(String title) {
        System.out.println("Creating new project: " + title);
        this.project = new Project(title);
    }

    void logUser() {
        //
    }
}
