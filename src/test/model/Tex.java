package model;

import java.io.File;

public interface Tex {
    // EFFECTS: import file from console
    default void scanTex() {}

    // EFFECTS: ensure basic elements for tex file to compile
    default void bareBones() {

    }

    // EFFECTS: add relevant info in file
    default void postPreamble() {

    }

    // EFFECTS: add string to describe source/credit attribution
    default void setSource(String s) {}

    // EFFECTS: add string to tag relevant fields/theorems/tricks
    default void setNutrition(Nutrient n) {}

    // EFFECTS: return contributor
    default void getContributor() {}

    // EFFECTS: set contributor
    default void setContributor() {}

    // EFFECTS: return date added
    default void getDateAdded() {}

    // EFFECTS: set date added
    default void setDateAdded() {}

}
