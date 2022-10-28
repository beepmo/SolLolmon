package model;

import org.json.JSONObject;

import java.util.Date;
import java.util.List;

// Represents a write-up, which may belong to a project, and be a question or solution
public class WriteUp {
    String tex; // content of the write-up
    User contributor; // username of contributor
    java.util.Date dateAdded; // creation time of the writeup
    List<String> nutrition; // relevant disciplines/theorems for this write-up
    String source; // contribution's description of their source/credit attribution

    // EFFECTS: construct writeup with date, contributor
    public WriteUp(User user) {
        this.dateAdded = new Date();
        this.contributor = user;
    }

    // EFFECTS: create writeup (likely String or tex File from console)
    // MODIFIES: this
    public void scanTex(String s) {
        this.tex = s;
    }

    public String getSource() {
        return source;
    }

    // EFFECTS: add string to describe source/credit attribution
    // MODIFIES: this
    public void setSource(String s) {
        this.source = s;
    }

    // EFFECTS: return contributor
    public User getContributor() {
        return contributor;
    }

    public String getTex() {
        return tex;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        json.put("tex", tex);
        json.put("contributor", contributor.toJson());
        json.put("dateAdded", dateAdded);
        json.put("nutrition", nutrition);
        json.put("source", source);

        return json;
    }

    /*

    // TODO unused methods

    // EFFECTS: return nutrition
    protected List<String> getNutrition() {
        return nutrition;
    }

    // EFFECTS: add string to tag relevant fields/theorems/tricks
    // TODO update in hashset if absent
    // MODIFIES: this, super.nutrition
    protected void setNutrition(String n) {
        this.nutrition.add(n);
    }

    // EFFECTS: return date added
    protected Date getDateAdded() {
        return dateAdded;
    }

    public void setTex(String tex) {
        this.tex = tex;
    }

    // EFFECTS: check basic elements for tex file to compile/valid writeup
    public boolean checkBones() {
        return true;
    }

    // EFFECTS: repair basic elements for tex file to compile/valid writeup
    // MODIFIES: this
    //TODO this does nothing for now
    public void bareBones() {

    }
    */
}
