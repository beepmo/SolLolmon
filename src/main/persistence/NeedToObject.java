// built from JsonSerializationDemo

package persistence;

import org.json.JSONObject;

// Interface for all classes that need a toJson method
public interface NeedToObject {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();

}
