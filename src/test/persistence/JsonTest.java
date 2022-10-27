package persistence;

import model.Project;
import model.Quest;
import model.User;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected User userFromSmon;
    protected Project p1;
    protected Quest q1FromSmon;

    @BeforeEach
    protected void runBefore() {
        userFromSmon = new User("Smon");
        p1 = new Project("SolLolmon");

        q1FromSmon = new Quest(userFromSmon, p1);
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
        // TODO finish check quest
    }

    // EFFECTS: compare original project with pFromJson
    protected void checkProject(Project originalProject, Project projectFromJson) {
        assertEquals(originalProject.getName(), projectFromJson.getName());
        assertEquals(originalProject.getDay(), projectFromJson.getDay());
        assertEquals(originalProject.getYesterQuest(), projectFromJson.getYesterQuest());
        //see if no checkQuest is needed?
    }

}
