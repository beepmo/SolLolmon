package model;

import java.util.ArrayList;

// Represents a question entry in a project
public class Quest extends ProjectEntry {
    private int seal; // number of days for which this question is chosen, 0 indicating an unpublished question
    private ArrayList<Soln> solutions; // solutions for this question

    // EFFECTS: constructs new question in a project
    // MODIFIES: the project's questions store field
    public Quest(User user, Project p) {
        super(user,p);
        solutions = new ArrayList<>();
        seal = 0;
        p.addQuestion(this);
    }

    // EFFECTS: adds solution for question
    // MODIFIES: this
    // REQUIRES: the new question's tex does not match verbatim another solution in question
    public void addSoln(Soln s) {
        solutions.add(s);
    }

    // EFFECTS: removes solution for question
    // MODIFIES: this
    public void removeSoln(Soln s) {
        s.removeQuestion();
        solutions.removeIf(s::equals);
    }

    public int getSeal() {
        return seal;
    }

    public ArrayList<Soln> getSolutions() {
        return solutions;
    }

    public void setSeal(int seal) {
        this.seal = seal;
    }

    public void incrementSeal() {
        int seal = getSeal();
        seal++;
        setSeal(seal);
    }
}
