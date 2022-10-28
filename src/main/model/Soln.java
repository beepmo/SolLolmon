package model;

import org.json.JSONObject;

// a solution writeup for a question
public class Soln extends WriteUp {

    // EFFECTS: creates a solution under a question, accredited to current user
    public Soln(User user) {
        super(user);
    }

    // EFFECTS: moves the solution to a different question in case of error
    // REQUIRES: question is not null
    public void setQuestion(Quest question) {
        question.removeSoln(this);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        json.put("tex", tex);
        json.put("contributor", contributor.toJson());
        json.put("dateAdded", dateAdded);
        json.put("nutrition", nutrition);
        json.put("source", source);

        return json;
    }

}
