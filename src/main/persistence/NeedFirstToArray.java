package persistence;

import org.json.JSONArray;

public interface NeedFirstToArray extends NeedToObject {
    // EFFECTS: returns this as a JSON array
    JSONArray toJsonArray();
}
