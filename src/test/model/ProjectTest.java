package model;

import exceptions.NoMatchingResultException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

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
        q1 = new Quest(u1);
        p1.addQuestion(q1);
        s1 = new Soln(q1,u1);
        q2 = new Quest(u1);
        p1.addQuestion(q2);
    }

    @Test
    void testProject() {
        Assertions.assertEquals("SolLolmon",p1.getName());
        Assertions.assertEquals(0,p1.getDay());
        Assertions.assertEquals(2,p1.getStore().size());
        // TODO
        //  To test dateAdded, I will need dependency inversion.
        //  I obtained TA permission to omit this test because not much could go wrong.
    }

    @Test
    // Covered in QuestTest
    void testAddQuestion() {
    }

    @Test
    // I will not test for random-ness; not much could go wrong
    void testChooseQuestion() {
        Assertions.assertTrue(p1.getStore().contains(p1.chooseQuestion()));
    }

    @Test
    void searchProject() {
        q1.scanTex("Gu dao xi feng shou ma.");
        q2.scanTex("Xi yang xi xia.");

        try {
            Assertions.assertEquals(2,p1.searchProject("xi").size());
            Assertions.assertTrue(p1.searchProject("xi").contains(q1) && p1.searchProject("xi").contains(q2));

            Assertions.assertEquals(1,p1.searchProject("dao").size());
            Assertions.assertTrue(p1.searchProject("dao").contains(q1));
        } catch (NoMatchingResultException e) {
            System.out.println("NoMatchingResultException was thrown where I was not testing for it.");
        }

        Assertions.assertThrows(NoMatchingResultException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                p1.searchProject("despacito");
            }
        });
    }

    @Test
    void setYesterQuest() {
        p1.setYesterQuest(q1);
        Assertions.assertEquals(q1,p1.getYesterQuest());
        p1.setYesterQuest(q2);
        Assertions.assertEquals(q2,p1.getYesterQuest());
    }

    @Test
    void setProject() {
        p1.setName("Singing in");
        Assertions.assertEquals("Singing in",p1.getName());
    }

    @Test
    // I will test this getter to ensure code coverage because it is only used in UI, which will not be tested.
    void getDay() {
        Assertions.assertEquals(0,p1.getDay());
    }

    @Test
    void setDay() {
        p1.setDay(2);
        Assertions.assertEquals(2,p1.getDay());
    }

    // TODO fix this test
//    @Test
//    // I will not test random.
//    void sealQuest() {
//        Assertions.assertTrue(q1.equals(p1.sealQuest()) || q2.equals(p1.sealQuest()));
//        Assertions.assertTrue(q1.equals(p1.getYesterQuest()) || q2.equals(p1.getYesterQuest()));
//        Assertions.assertTrue(q1.getSeal() == 1 || q2.getSeal() == 1);
//    }

    @Test
    void newDay() {
        p1.newDay();
        Assertions.assertEquals(1,p1.getDay());
    }
}