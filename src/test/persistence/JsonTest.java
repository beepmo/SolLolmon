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
        q1FromSmon.scanTex("Express sin(ix) in terms of exponentials.");
        q1FromSmon.setSource("Conversation");

    }

    // EFFECTS: compare original user with userFromJson
    protected void checkUser(User userOriginal, User userFromJson) {
        assertEquals(userOriginal.getName(), userFromJson.getName());
    }

    // EFFECTS: compare original question with qFromJson
    protected void checkQuest(Quest qOriginal, Quest qFromJson) {
        checkUser(qOriginal.getContributor(), qFromJson.getContributor());
        assertEquals(qOriginal.getTex(), qFromJson.getTex());
        assertEquals(qOriginal.getSource(), qFromJson.getSource());
    }

}
