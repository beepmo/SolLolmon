package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class QuestTest {

    User u1;
    Project p1;
    Quest q1;
    Soln s1;

    @BeforeEach
    void runBefore() {
        u1 = new User("Smon");
        p1 = new Project("SolLolmon");
        q1 = new Quest(u1,p1);
        s1 = new Soln(q1,u1);
    }

    @Test
    void testQuest() {
        assertEquals(u1,q1.getContributor());
        assertEquals(0,q1.getSeal());
        assertEquals(new ArrayList<Soln>(),q1.getSolutions());
        assertTrue(p1.getStore().contains(q1));
        // TODO
        //  To test dateAdded, I will need dependency inversion.
        //  I obtained TA permission to omit this test because not much could go wrong.
        // assertEquals(1,q1.getDateAdded());
    }

    @Test
    void testAddSoln() {
        q1.addSoln(s1);
        assertTrue(q1.getSolutions().contains(s1));
        assertEquals(1,q1.getSolutions().size());
    }
}