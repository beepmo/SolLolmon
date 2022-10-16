package model;

import exceptions.NoMatchingResultException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    User u1;
    Project p1;
    Quest q1;
    Soln s1;
    Quest q2;

    @BeforeEach
    void runBefore() {
        u1 = new User("Smon");
        p1 = new Project("SolLolmon");
        q1 = new Quest(u1,p1);
        s1 = new Soln(q1,u1);
        q2 = new Quest(u1,p1);
    }

    @Test
    // Covered in QuestTest
    void testAddQuestion() {

    }

    @Test
    // I will not test random
    void testChooseQuestion() {
        assertTrue(p1.getStore().contains(p1.chooseQuestion()));
    }

    @Test
    void searchProject() {
        q1.scanTex("Gu dao xi feng shou ma.");
        q2.scanTex("Xi yang xi xia.");

        try {
            assertEquals(2,p1.searchProject("xi").size());
            assertTrue(p1.searchProject("xi").contains(q1) && p1.searchProject("xi").contains(q2));
        } catch (NoMatchingResultException e) {
            System.out.println("NoMatchingResultException was thrown where I was not testing for it.");
        }

        assertThrows(NoMatchingResultException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                p1.searchProject("despacito");
            }
        });
    }

    @Test
    void setDay() {
    }

    @Test
    void setYesterQuest() {
    }

    @Test
    void setProject() {
    }
}