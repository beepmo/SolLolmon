package persistence;

import model.User;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected User userFromSmon;

    @BeforeEach
    protected void runBefore() {
        userFromSmon = new User("Smon");
    }

    // EFFECTS: compare userFromSmon with userFromJson
    protected void checkUser(User userFromJson) {
        assertEquals(userFromSmon.getName(), userFromJson.getName());
    }

}
