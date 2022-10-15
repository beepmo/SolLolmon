package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ProjectLolmon implements Project {

    protected static int tick = 1;
    protected static int birthdate = 1010;
    protected static String project = "SolLolmon";
    public int day;
    protected HashSet<String> nutrition;
    protected List<Quest> store;
    protected Quest yesterQuest;

    // EFFECTS: constructs a new ritual
    public ProjectLolmon() {
        this.day = 1;
        this.store = new ArrayList<>();
    }

    //TODO: print question, post prev. soln if any


    @Override
    /* EFFECTS: increments sol at specified interval
     */
    // MODIFIES: this
    public void tick() {
        day++;
    }

    @Override
    // EFFECTS: for a chosen question, annotates it with day, remembers to post solution
    // MODIFIES: this
    public void seal(Quest q) {
        int seal = q.getSeal();
        seal++;
        q.setSeal(seal);
        yesterQuest = q;
    }

}
