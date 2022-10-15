package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class Project {

    protected static int tick = 1;
    protected java.util.Date birthdate;
    protected String project;
    public int day;
    protected HashSet<String> nutrition;
    protected List<Quest> store;
    protected Quest yesterQuest;

    // EFFECTS: constructs a new ritual
    public Project(String project) {
        this.project = project;
        this.day = 1;
        this.store = new ArrayList<>();
        this.birthdate = new Date();
    }

    //TODO: print question, post prev. soln if any
    public Quest chooseQuestion() {
        return null;
    }

    public List<Soln> getPrevSoln() {
        return null;
    }

    // EFFECTS: add project and writeup fields in file/String
    // MODIFIES: this
    public void postPreamble() {
    }


}
