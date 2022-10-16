package model;

import java.util.ArrayList;

public class Quest extends ProjectEntry {
    private int seal;
    // number of sols for which this question is chosen
    private ArrayList<Soln> solutions;

    // EFFECTS: constructs new question in project p
    // MODIFIES: Project p
    public Quest(User user, Project p) {
        super(user,p);
        solutions = new ArrayList<Soln>();
        seal = 0;
        p.addQuestion(this);
    }

    public void addSoln(Soln s) {
        solutions.add(s);
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
}
