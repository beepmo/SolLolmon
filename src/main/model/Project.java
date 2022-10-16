package model;

import exceptions.NoMatchingResultException;

import java.util.*;

public class Project {

    protected static int tick = 1;
    protected java.util.Date birthdate;
    protected String project;
    protected int day;
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

    public void addQuestion(Quest q) {
        store.add(q);
    }

    // EFFECTS: returns random question from project
    public Quest chooseQuestion() {
        Random random = new Random();
        int randIndex = random.nextInt(store.size());
        return store.get(randIndex);
    }

    public List<Quest> searchProject(String s) throws NoMatchingResultException {
        List<Quest> results = new ArrayList();
        for (Quest q : store) {
            if (q.getTex().contains(s)) {
                results.add(q);
            }
        }
        if (results.size() == 0) {
            throw new NoMatchingResultException();
        }
        return results;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Quest getYesterQuest() {
        return yesterQuest;
    }

    public void setYesterQuest(Quest yesterQuest) {
        this.yesterQuest = yesterQuest;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public List<Quest> getStore() {
        return store;
    }
}
