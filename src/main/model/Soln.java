package model;

import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errorspackage model;
import java.time.Clock;
import java.util.ArrayList;

// Solution field
public class Soln {

    public Quest quest;
    public boolean isPreMade;
    public User contributor;
    public Clock createTime;

    private File tex;
    private String source;
    private ArrayList<Nutrient> nutrition;

    // EFFECTS: create solution object
    public Soln(Quest quest, User contributor, Clock createTime) {
        // stub
    }

    // EFFECTS: add description of solution source
    // MODIFIES: this
    public void setSource(String desc) {
        source = desc;
    }

    // EFFECTS: add tag for relevant concept in solution
    // REQUIRES: concept not already in list
    // MODIFIES: this
    public void addNutrient(Nutrient n) {
        nutrition.add(n);
    }
}
