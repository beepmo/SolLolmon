package model;

import java.io.File;
import java.util.Date;
import java.util.List;

public abstract class WriteUp {
    String tex;
    User contributor;
    java.util.Date dateAdded;
    List<String> nutrition;
    String source;

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
