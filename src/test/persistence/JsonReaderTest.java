package persistence;

import model.Project;
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
            checkUser(userFromSmon, userFromJson); // recall that userFromSmon was written into this test file
        } catch (IOException e) {
            fail("No exception was expected.");
        }
    }

    @Test
    void testReaderP1() {
        try {
            JsonReader reader = new JsonReader("./data/testWriterProjectP1.json");
            Project projectFromJson = reader.readProject();

            checkProject(p1, projectFromJson);
        } catch (IOException e) {
            fail("No exception was expected.");
        }
    }

    @Test
    void testReaderP2() {
        try {
            JsonReader reader = new JsonReader("./data/testWriterProjectP2.json");
            Project projectFromJson = reader.readProject();

            checkProject(p2, projectFromJson);
        } catch (IOException e) {
            fail("No exception was expected.");
        }
    }
}
