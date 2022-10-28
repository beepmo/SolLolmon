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
    private Soln s2FromSmon;

    @BeforeEach
    protected void runBefore() {
        userFromSmon = new User("Smon");
        p1 = new Project("SolLolmon");

        q1FromSmon = new Quest(userFromSmon);
        p1.addQuestion(q1FromSmon);
        q1FromSmon.scanTex("Express sin(ix) in terms of exponentials.");
        q1FromSmon.setSource("Conversation");

        s1FromSmon = new Soln(userFromSmon);
        q1FromSmon.addSoln(s1FromSmon);
        s1FromSmon.scanTex("Euler's identity");
        s1FromSmon.setSource("The same conversation");

        s2FromSmon = new Soln(userFromSmon);
        q1FromSmon.addSoln(s1FromSmon);
        s2FromSmon.scanTex("Match Taylor expansions");
        s2FromSmon.setSource("One side of that conversation");

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
        try {
            checkUser(qOriginal.getContributor(), qFromJson.getContributor());
            assertEquals(qOriginal.getTex(), qFromJson.getTex());
            assertEquals(qOriginal.getSource(), qFromJson.getSource());
            assertEquals(qOriginal.getSeal(), qFromJson.getSeal());

            List<Soln> originalSolutions = qOriginal.getSolutions();
            List<Soln> solutionsFromJson = qFromJson.getSolutions();
            int numberOfSolutions = solutionsFromJson.size();
            for (int i = 0; i < numberOfSolutions; i++) {
                checkSoln(originalSolutions.get(i), solutionsFromJson.get(i));
            }
        } catch (NullPointerException e) {
            System.out.println("YesterQuest is null; considered equivalent.");
        }
    }

    protected void checkSoln(Soln originalSolution, Soln solutionFromJson) {
        checkUser(originalSolution.getContributor(), solutionFromJson.getContributor());
        assertEquals(originalSolution.getTex(), solutionFromJson.getTex());
        assertEquals(originalSolution.getSource(), solutionFromJson.getSource());
    }

    // EFFECTS: compare original project with pFromJson
    protected void checkProject(Project originalProject, Project projectFromJson) {
        assertEquals(originalProject.getName(), projectFromJson.getName());
        assertEquals(originalProject.getDay(), projectFromJson.getDay());
        checkQuest(originalProject.getYesterQuest(), projectFromJson.getYesterQuest());

        List<Quest> storeFromJson = projectFromJson.getStore();
        List<Quest> originalStore = originalProject.getStore();
        int storeSize = storeFromJson.size();
        for (int i = 0; i < storeSize; i++) {
            checkQuest(originalStore.get(i), storeFromJson.get(i));
        }
    }

}
