package model;

import model.Project;
import model.Quest;
import model.Soln;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolnTest {
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
    void Soln() {
        assertEquals(q1,s1.getQuestion());
    }

    @Test
    void setQuestion() {
        s1.setQuestion(q2);
    }
}