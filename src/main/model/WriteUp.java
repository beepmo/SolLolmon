package model;

import java.io.File;
import java.util.Date;
import java.util.List;

public abstract class WriteUp {
    File tex;
    User contributor;
    java.util.Date dateAdded;
    List<String> nutrition;
    String source;

    // EFFECTS: construct writeup with date, contributor
    public WriteUp(User user) {
        super();
        this.contributor = user;
    }

    // EFFECTS: create writeup (likely String or tex File from console)
    public void scanTex() {}

    // EFFECTS: check basic elements for tex file to compile/valid writeup
    //TODO this will always return true for now
    public boolean checkBones() {
        return true;
    }

    // EFFECTS: repair basic elements for tex file to compile/valid writeup
    // MODIFIES: this
    //TODO this does nothing for now
    public void bareBones() {

    }

    // EFFECTS: add project and writeup fields in file/String
    // MODIFIES: this
    public void postPreamble() {

    }

    // EFFECTS: add string to describe source/credit attribution
    // MODIFIES: this
    protected void setSource(String s) {
        this.source = s;
    }

    // EFFECTS: add string to tag relevant fields/theorems/tricks
    // TODO update in hashset if absent
    // MODIFIES: this, super.nutrition
    protected void setNutrition(String n) {
        this.nutrition.add(n);
    }

    // EFFECTS: return nutrition
    protected List<String> getNutrition() {
        return nutrition;
    }

    // EFFECTS: return contributor
    protected User getContributor() {
        return contributor;
    }

    // EFFECTS: return date added
    protected Date getDateAdded() {
        return dateAdded;
    }

}
