package model;

import java.util.List;

public interface Project {
    default Quest chooseQuestion() {
        return null;
    }

    default List<Soln> getPrevSoln() {
        return null;
    }

    /* EFFECTS: increments sol at specified interval
     */
    // MODIFIES: this
    default void tick() {
    }

    // EFFECTS: for a chosen question, annotates it with day, remembers to post solution
    // MODIFIES: this
    default void seal(Quest q) {
    }
}
