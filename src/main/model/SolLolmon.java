package model;

public class SolLolmon {

    protected static int tick = 1;
    protected static int birthdate = 1010;
    protected static String project = "SolLolmon";

    protected static int sol;

    // EFFECTS: constructs object in new ritual
    public SolLolmon() {
        java.util.Date date = new java.util.Date();
    }

    /* EFFECTS: increments sol at specified interval
    TODO: print question, post prev. soln if any, update seals
     */
    // MODIFIES: this
    private void tick() {
        sol++;
    }
}
