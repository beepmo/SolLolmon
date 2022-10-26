package persistence;

import model.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest {
    @Test
    void testReaderNoSuchFile() {
        JsonReader reader = new JsonReader("noSuchFile");
        try {
            User u = reader.readUser();
            fail("IOException expected.");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderUser() {
        JsonReader reader = new JsonReader("./data/testWriterUser.json");
        try {
            User userFromJson = reader.readUser();
            checkUser(userFromJson);
        } catch (IOException e) {
            fail("No exception was expected.");
        }
    }
}
