package persistence;

import org.json.JSONArray;

// Interface for all classes that need to become JSONObject but also
// have strictly one collection field that needs to become JSONArray
// If a class has two collection fields, this will be extended to NeedTwoToArray for that class to implement
public interface NeedFirstToArray extends NeedToObject {
    // EFFECTS: returns this as a JSON array
    JSONArray toJsonArray();
}
