// code from JsonSerializationDemo

package persistence;

import model.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }


    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // Cluster begins
    // EFFECTS: reads user from file and returns it;
    // throws IOException if an error occurs reading data from file
    public User readUser() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseUser(jsonObject);
    }

    public Project readProject() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseProject(jsonObject);
    }

    // TODO: Project & WriteUp: parse hashset || date
// Parsing begins. for each class
    // EFFECTS: parses project from JSON object and returns it
    private Project parseProject(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Project projectFromJson = new Project(name);

        int day = jsonObject.getInt("day");
        projectFromJson.setDay(day);

        try {
            Quest yesterQuest = parseQuest(jsonObject.getJSONObject("yesterQuest"));
            projectFromJson.setYesterQuest(yesterQuest);
        } catch (JSONException e) {
            // do not print anything
        }

        JSONArray jsonStore = jsonObject.getJSONArray("store");
        for (Object jsonObject1 : jsonStore) {
            Quest quest = parseQuest((JSONObject) jsonObject1);
            projectFromJson.addQuestion(quest);
        }

        return projectFromJson;
    }

    // EFFECTS: parses quest from JSON object and returns it
    private Quest parseQuest(JSONObject jsonObject) {
        User user = parseUser(jsonObject.getJSONObject("contributor"));
        Quest questFromJson = new Quest(user);

        questFromJson.setSource(jsonObject.getString("source"));
        questFromJson.setTex(jsonObject.getString("tex"));
        questFromJson.setSeal(jsonObject.getInt("seal"));

        JSONArray jsonSolutions = jsonObject.getJSONArray("solutions");
        for (Object jsonObject1 : jsonSolutions) {
            Soln soln = parseSoln((JSONObject) jsonObject1);
            questFromJson.addSoln(soln);
        }

        return questFromJson;
    }

    // EFFECTS: parses solution from JSON object and returns it
    private Soln parseSoln(JSONObject jsonObject) {
        User user = parseUser(jsonObject.getJSONObject("contributor"));
        Soln solnFromJson = new Soln(user);
        solnFromJson.setSource(jsonObject.getString("source"));
        solnFromJson.setTex(jsonObject.getString("tex"));
        return solnFromJson;
    }

    // EFFECTS: parses user from JSON object and returns it
    private User parseUser(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        return new User(name);
    }
}
