package model;

import exceptions.EmptyStoreException;
import exceptions.NoMatchingResultException;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.NeedFirstToArray;

import java.util.*;

// Represents a project with a collection of questions that runs question of the day, counting days
public class Project implements NeedFirstToArray {

    protected String name; // project name
    protected int day; // counts number of days
    protected List<Quest> store; // questions collected in the project
    protected Quest yesterQuest; // remembers yesterday's question to track its solution
    protected java.util.Date birthdate; // records project creation date
    // TODO implement nutrition
    protected HashSet<String> nutrition; // tags of relevant disciplines/theorems associated with questions in project


    // EFFECTS: constructs a new project
    // REQUIRES: project name is non-empty
    public Project(String name) {
        this.name = name;
        this.day = 0;
        this.store = new ArrayList<>();
        this.birthdate = new Date();
        EventLog.getInstance().logEvent(new Event("Created project: " + name));
    }

    // EFFECTS: adds a question to the store
    // REQUIRES: the new question's tex does not match verbatim a question in store
    public void addQuestion(Quest q) {
        store.add(q);
        EventLog.getInstance().logEvent(new Event("Added question by "
                + q.getContributor().getName() + " from source \"" + q.getSource() + "\" to " + this.name));
    }

    // REQUIRES: store must have at least one question
    // EFFECTS: returns a random question from project store
    public Quest chooseQuestion() throws EmptyStoreException {
        if (store.size() == 0) {
            throw new EmptyStoreException();
        }
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
    public Quest sealQuest() throws EmptyStoreException {
        Quest chosen = chooseQuestion();
        chosen.incrementSeal();
        setYesterQuest(chosen);

        EventLog.getInstance().logEvent(new Event("Sealed a question to call it a day: day " + this.day + "."));

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
    public void incrementDay() {
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

    public String getName() {
        return name;
    }

    // EFFECTS: change project name
    // MODIFIES: this
    // REQUIRES: input string is non-empty
    // TODO implement settings in user interface
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("day", day);
        json.put("store", toJsonArray());
        try {
            json.put("yesterQuest", yesterQuest.toJson());
        } catch (NullPointerException e) {
            json.put("yesterQuest", "");
            // toJson cannot be called on null
        }
        json.put("birthdate", birthdate);
        json.put("nutrition", nutrition);

        EventLog.getInstance().logEvent(new Event("Saved project: " + name));

        return json;
    }

    @Override
    public JSONArray toJsonArray() {
        JSONArray jsonArray = new JSONArray();

        for (Quest q : store) {
            jsonArray.put(q.toJson());
        }

        return jsonArray;
    }
}
