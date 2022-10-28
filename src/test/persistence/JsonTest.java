package persistence;

import model.Project;
import model.Quest;
import model.Soln;
import model.User;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected User userFromSmon;
    protected static Project p1;
    protected Quest q1FromSmon;
    protected Soln s1FromSmon;
    protected Quest q2FromSmon;
    protected static Project p2;

    @BeforeEach
    protected void runBefore() {
        userFromSmon = new User("Smon");
        p1 = new Project("SolLolmon");

        q1FromSmon = new Quest(userFromSmon);
        p1.addQuestion(q1FromSmon);
        q1FromSmon.scanTex("Express sin(ix) in terms of exponentials.");
        q1FromSmon.setSource("Conversation");

        s1FromSmon = new Soln(q1FromSmon, userFromSmon);
        q1FromSmon.addSoln(s1FromSmon);
        s1FromSmon.scanTex("Euler's identity");
        s1FromSmon.setSource("The same conversation");

        q2FromSmon = new Quest(userFromSmon);
        p1.addQuestion(q2FromSmon);
        q2FromSmon.scanTex("Given a compass and straight edge, and segments of length 1, z, z < 1, construct a segment of length " +
                "∑^∞_i=0 z^n.");
        q2FromSmon.setSource("Macroeconomics simple multiplier");

        p2 = new Project("SolLolmon");
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
        assertEquals(qOriginal.getSeal(), qFromJson.getSeal());
        assertEquals(qOriginal.getSolutions(), qFromJson.getSolutions());
    }

    // EFFECTS: compare original project with pFromJson
    protected static void checkProject(Project originalProject, Project projectFromJson) {
        assertEquals(originalProject.getName(), projectFromJson.getName());
        assertEquals(originalProject.getDay(), projectFromJson.getDay());
        assertEquals(originalProject.getYesterQuest(), projectFromJson.getYesterQuest());

        List<Quest> storeFromJson = projectFromJson.getStore();
        List<Quest> originalStore = originalProject.getStore();
        int storeSize = storeFromJson.size();
        for (int i = 0; i < storeSize; i++) {
            assertEquals(originalStore.get(i), storeFromJson.get(i));
        }
    }

}
