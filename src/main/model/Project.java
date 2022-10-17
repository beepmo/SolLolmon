package model;

import exceptions.NoMatchingResultException;

import java.util.*;

// Represents a project with a collection of questions that runs question of the day, counting days
public class Project {

    protected String project; // project name
    protected int day; // counts number of days
    protected List<Quest> store; // questions collected in the project
    protected Quest yesterQuest; // remembers yesterday's question to track its solution
    protected java.util.Date birthdate; // records project creation date
    // TODO implement nutrition
    protected HashSet<String> nutrition; // tags of relevant disciplines/theorems associated with questions in project


    // EFFECTS: constructs a new project
    // REQUIRES: project name is non-empty
    public Project(String project) {
        this.project = project;
        this.day = 0;
        this.store = new ArrayList<>();
        this.birthdate = new Date();
    }

    // EFFECTS: adds a question to the store
    // REQUIRES: the new question's tex does not match verbatim a question in store
    // TODO implement connecting a question to another
    public void addQuestion(Quest q) {
        store.add(q);
    }

    // EFFECTS: returns a random question from project store
    public Quest chooseQuestion() {
        Random random = new Random();
        int randIndex = random.nextInt(store.size());
        return store.get(randIndex);
    }

    // EFFECTS: returns a list of questions that contain a given string
    // REQUIRES: search string is non-empty
    public List<Quest> searchProject(String s) throws NoMatchingResultException {
        List<Quest> results = new ArrayList<>();
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

    // EFFECTS: establishes a chosen question as question of the day
    // REQUIRES: chosen question is in project store
    // MODIFIES: this, chosen question
    public Quest sealQuest() {
        Quest chosen = chooseQuestion();
        chosen.incrementSeal();
        setYesterQuest(chosen);
        return chosen;
    }

    public List<Quest> getStore() {
        return store;
    }

    public int getDay() {
        return day;
    }

    // EFFECTS: sets a day, usually increment, could be negative (countdown) or zero
    // MODIFIES: this
    public void setDay(int day) {
        this.day = day;
    }

    // EFFECTS: increments day count
    // MODIFIES: this
    public void newDay() {
        day++;
    }

    public Quest getYesterQuest() {
        return yesterQuest;
    }

    // EFFECTS: set yesterQuest to the day's new question, to remember to post its solution the next day
    // MODIFIES: this
    // REQUIRES: input question in an element of store
    public void setYesterQuest(Quest yesterQuest) {
        this.yesterQuest = yesterQuest;
    }

    public String getProject() {
        return project;
    }

    // EFFECTS: change project name
    // MODIFIES: this
    // REQUIRES: input string is non-empty
    // TODO implement settings in user interface
    public void setProject(String project) {
        this.project = project;
    }
}
