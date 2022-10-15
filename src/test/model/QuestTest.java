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
        q1 = new Quest(u1,p1);
        s1 = new Soln(q1,u1);
    }

    @Test
    void testQuest() {
        assertEquals(u1,q1.getContributor());
        assertEquals(0,q1.getSeal());
        assertEquals(new ArrayList<Soln>(),q1.getSolutions());
        // TODO how to test date added? Need time taken simultaneously at creation of Quest object and Date object
        // assertEquals(1,q1.getDateAdded());
        // dependency inversion
    }

    @Test
    void testAddSoln() {
        q1.addSoln(s1);
        //assertEquals(new ArrayList<Soln>().add(s1),q1.getSolutions());
    }
}