package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents a write-up that belongs to a specific project
public class ProjectEntry extends WriteUp implements Writable {

    protected Project project;

    public ProjectEntry(User user, Project p) {
        super(user);
        this.project = p;
    }

    public JSONObject toJson() {
        JSONObject json = super.toJson();
        json.put("project", project.toJson());
        return json;
    }
}
