package model;

import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User u1;

    @BeforeEach
    void runBefore() {
        u1 = new User("Smon");
    }

    @Test
    void testUser() {
        assertEquals("Smon",u1.getName());
    }

    @Test
    void setName() {
        u1.setName("Lolmon");
        assertEquals("Lolmon",u1.getName());
    }
}