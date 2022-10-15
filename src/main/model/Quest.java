package model;

import java.util.ArrayList;

public class Quest extends WriteUp {

    private int seal;
    // number of sols for which this question is chosen
    private ArrayList<Soln> solutions;

    public Quest(User user) {
        super(user);
        solutions = new ArrayList<Soln>();
        seal = 0;
    }

    @Override
    // EFFECTS: add project and writeup fields in file/String
    // MODIFIES: this
    public void postPreamble() {

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
