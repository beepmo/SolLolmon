package model;

import java.io.File;
import java.util.List;

public abstract class WriteUp extends SolLolmon implements Tex {
    File tex;
    User contributor;
    java.util.Date dateAdded;
    List<Nutrient> nutrition;

    // EFFECTS: construct writeup with date, contributor
    public WriteUp(User user) {
        super(user);
    }
}
