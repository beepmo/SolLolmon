package persistence;

import exceptions.EmptyStoreException;
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
    void testWriterProjectP1() {
        try {
            JsonWriter writer = new JsonWriter("./data/testWriterProjectP1.json");
            writer.open();
            writer.write(p1);
            writer.close();

            try {
                JsonReader reader = new JsonReader("./data/testWriterProjectP1.json");
                Project projectFromJson = reader.readProject();

                checkProject(p1, projectFromJson);
            } catch (IOException e) {
                fail("No exception was expected.");
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Test
    void testWriterProjectP2() {
        try {
            JsonWriter writer = new JsonWriter("./data/testWriterProjectP2.json");
            writer.open();
            writer.write(p2);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterProjectP2.json");
            Project projectFromJson = reader.readProject();

            checkProject(p2, projectFromJson);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Test
    void testWriterProjectP1Sealed() {
        try {
            p1.sealQuest();
        } catch (EmptyStoreException e) {
            // pass
        }
        testWriterProjectP1();
    }

    @Test
    void testWriterProjectP2Sealed() {
        try {
            p2.sealQuest();
        } catch (EmptyStoreException e) {
            // pass
        }
        testWriterProjectP2();
    }

    @Test
    void testClose() {
        try {
            JsonWriter writer = new JsonWriter("./data/testWriterUser.json");
            writer.open();
            writer.write(userFromSmon);
            writer.close();
        } catch (IOException e) {
            fail("No exception was expected.");
        }
    }

    @Test
    void testSaveToFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/testWriterUser.json");
            writer.open();
            writer.write(userFromSmon);
            writer.close();
        } catch (IOException e) {
            fail("No exception was expected.");
        }    }
}
