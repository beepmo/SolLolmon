package model;

public class ProjectEntry extends WriteUp {

    protected Project project;

    public ProjectEntry(User user, Project p) {
        super(user);
        this.project = p;
    }
}
