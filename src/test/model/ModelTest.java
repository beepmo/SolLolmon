package model;

import org.junit.jupiter.api.BeforeEach;


public class ModelTest {
    User u1;
    Project p1;
    Quest q1;
    Soln s1;
    Quest q2;

    @BeforeEach
    void runBefore() {
        u1 = new User("Smon");
        p1 = new Project("SolLolmon");
        q1 = new Quest(u1);
        p1.addQuestion(q1);
        s1 = new Soln(q1, u1);
        q2 = new Quest(u1);
        p1.addQuestion(q2);
    }
}
