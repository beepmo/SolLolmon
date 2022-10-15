package model;

import java.util.ArrayList;

public class Quest extends WriteUp {

    public Project project;
    private int seal;
    // number of sols for which this question is chosen
    private ArrayList<Soln> solutions;

    public Quest(User user, Project p) {
        super(user);
        solutions = new ArrayList<Soln>();
        this.project = p;
        seal = 0;
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
