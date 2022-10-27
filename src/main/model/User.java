package model;

import org.json.JSONObject;
import persistence.NeedToObject;

// Represents a single sign-on user; writeups contributed will be accredited to this user
public class User implements NeedToObject {
    String name; // name of the user
    // TODO fields for all write-ups contributed by this user

    // EFFECTS: signs in a user with this name
    // REQUIRES: name is a non-empty string
    public User(String name) {
        this.name = name;
    }

    // EFFECTS: changes user's name in all write-ups contributed in this session
    //  TODO persistence
    // REQUIRES: name is a non-empty string
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        return json;
    }

}
