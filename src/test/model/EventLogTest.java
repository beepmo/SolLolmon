package model;

import exceptions.EmptyStoreException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class EventLogTest extends ModelTest {

    @BeforeEach
    void clearLog() {
        EventLog.getInstance().clear();
        q1.setSource("Differential forms"); // source must be set before adding
        p1.addQuestion(q1);
    }

    @Test
    void addQuest() {
        for (Event event : EventLog.getInstance()) {
            String desc = event.getDescription();
            if (!desc.equals("Event log cleared.")) {
                assertEquals("Added question by Smon from source \"Differential forms\" to SolLolmon",event.getDescription());
            }
        }
    }

    @Test
    void sealQuest() {
        EventLog.getInstance().clear();

        try {
            p1.sealQuest();
        } catch (EmptyStoreException e) {
            fail("something wrong in Project class, should not happen to this test");
        }
        for (Event event : EventLog.getInstance()) {
            String desc = event.getDescription();
            if (!desc.equals("Event log cleared.")) {
                assertEquals("Sealed a question to call it a day: day 1.",event.getDescription());
            }
        }
    }
}
