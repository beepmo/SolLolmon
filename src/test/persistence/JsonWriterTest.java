package persistence;

import model.Project;
import model.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {
    @Test
    void testWriterInvalidFile() {
        try {
            User u = new User("Smon");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected.");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterUser() {
        try {
            JsonWriter writer = new JsonWriter("./data/testWriterUser.json");
            writer.open();
            writer.write(userFromSmon);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterUser.json");
            User userFromJson = reader.readUser();
            checkUser(userFromSmon, userFromJson);
        } catch (IOException e) {
            fail("No exception was expected.");
        }
    }

    @Test
    void testWriterProject1Question0Solution() {
        try {
            JsonWriter writer = new JsonWriter("./data/testWriterProject1Question0Solution.json");
            writer.open();
            writer.write(p1);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterProject1Question0Solution.json");
            Project projectFromJson = reader.readProject();

            checkProject(p1, projectFromJson);
        } catch (IOException e) {
            fail("No exception was expected.");
        }
    }
}
