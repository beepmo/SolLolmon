package persistence;

import model.Project;
import model.Quest;
import model.User;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected User userFromSmon;
    protected Project projFromSmon;
    protected Quest q1FromSmon;

    @BeforeEach
    protected void runBefore() {
        userFromSmon = new User("Smon");
        projFromSmon = new Project("SolLolmon");
        q1FromSmon = new Quest(userFromSmon, projFromSmon);
    }

    // EFFECTS: compare userFromSmon with userFromJson
    protected void checkUser(User userFromJson) {
        assertEquals(userFromSmon.getName(), userFromJson.getName());
    }

}
