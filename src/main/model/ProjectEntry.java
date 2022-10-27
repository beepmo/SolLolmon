package model;

import org.json.JSONObject;
import persistence.NeedToObject;

// Represents a write-up that belongs to a specific project
public class ProjectEntry extends WriteUp implements NeedToObject {

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
