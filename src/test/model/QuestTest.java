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
    }

    @Test
    void testAddSoln() {
        q1.addSoln(s1);
        assertTrue(q1.getSolutions().contains(s1));
        assertEquals(1,q1.getSolutions().size());
        assertEquals(q1,s1.getQuestion());
    }

    @Test
    void testIncrementSeal() {
        q1.incrementSeal();
        assertEquals(1,q1.getSeal());
    }

    @Test
    void testSetSeal() {
        q1.setSeal(3);
        assertEquals(3,q1.getSeal());
    }

    @Test
    // Testing getter for code coverage
    void getSeal() {
        assertEquals(0,q1.getSeal());
    }

    @Test
    // Why not covered by addSolutions?
    void getSolutions() {
        q1.addSoln(s1);
        assertTrue(q1.getSolutions().contains(s1));
        assertEquals(1,q1.getSolutions().size());
    }

    @Test
    void removeSoln() {
        q1.addSoln(s1);
        q1.removeSoln(s1);
        assertEquals(0,q1.getSolutions().size());
        assertNull(s1.getQuestion());
    }

    @Test
    void scanTex() {
        q1.scanTex("q1 body");
        assertEquals("q1 body",q1.getTex());
        s1.scanTex("s1 body");
        assertEquals("s1 body",s1.getTex());
    }

    @Test
    void setSource() {
        q1.setSource("q1 source");
        assertEquals("q1 source",q1.getSource());
        s1.setSource("s1 source");
        assertEquals("s1 source",s1.getSource());
    }
}