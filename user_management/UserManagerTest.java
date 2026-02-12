package user_management;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {

    UserManager um;

    @BeforeEach
    void setup() {
        um = new UserManager();
    }

    // ---------------- REGISTRATION TESTS ----------------

    @Test
    void testRegisterValidUsers() {
        assertTrue(um.registerUser("student1", "1234", UserManager.Role.STUDENT));
        assertTrue(um.registerUser("teacher1", "abcd", UserManager.Role.TEACHER));
        assertTrue(um.registerUser("admin1", "admin123", UserManager.Role.ADMIN));
    }

    @Test
    void testDuplicateRegistration() {
        um.registerUser("student1", "1234", UserManager.Role.STUDENT);
        assertFalse(um.registerUser("student1", "5678", UserManager.Role.STUDENT));
    }

    @Test
    void testWeakPasswordRegistration() {
        assertFalse(um.registerUser("user", "12", UserManager.Role.STUDENT));
    }

    @Test
    void testNullRegistration() {
        assertThrows(IllegalArgumentException.class, () ->
                um.registerUser(null, "1234", UserManager.Role.STUDENT));
    }

    // ---------------- LOGIN TESTS ----------------

    @Test
    void testSuccessfulLoginReturnsSession() {
        um.registerUser("student1", "1234", UserManager.Role.STUDENT);
        String session = um.login("student1", "1234");
        assertNotNull(session);
        assertTrue(um.isSessionActive(session));
    }

    @Test
    void testLoginWrongPassword() {
        um.registerUser("student1", "1234", UserManager.Role.STUDENT);
        assertNull(um.login("student1", "wrong"));
    }

    @Test
    void testLoginNonExistingUser() {
        assertNull(um.login("unknown", "1234"));
    }

    // ---------------- ROLE BASED ACCESS TESTS ----------------

    @Test
    void testAdminAccess() {
        um.registerUser("admin1", "admin123", UserManager.Role.ADMIN);
        String session = um.login("admin1", "admin123");

        assertTrue(um.hasAccess(session, UserManager.Role.ADMIN));
        assertFalse(um.hasAccess(session, UserManager.Role.STUDENT));
    }

    @Test
    void testTeacherAccess() {
        um.registerUser("teacher1", "abcd", UserManager.Role.TEACHER);
        String session = um.login("teacher1", "abcd");

        assertTrue(um.hasAccess(session, UserManager.Role.TEACHER));
        assertFalse(um.hasAccess(session, UserManager.Role.ADMIN));
    }

    // ---------------- LOGOUT & SESSION TESTS ----------------

    @Test
    void testLogoutInvalidatesSession() {
        um.registerUser("student1", "1234", UserManager.Role.STUDENT);
        String session = um.login("student1", "1234");

        assertTrue(um.logout(session));
        assertFalse(um.isSessionActive(session));
    }

    @Test
    void testAccessAfterLogoutFails() {
        um.registerUser("student1", "1234", UserManager.Role.STUDENT);
        String session = um.login("student1", "1234");
        um.logout(session);

        assertFalse(um.hasAccess(session, UserManager.Role.STUDENT));
    }

    @Test
    void testInvalidSessionAccess() {
        assertFalse(um.hasAccess("fake-session", UserManager.Role.ADMIN));
    }

    // ---------------- MULTIPLE SESSION TEST ----------------

    @Test
    void testMultipleSessionsSameUser() {
        um.registerUser("student1", "1234", UserManager.Role.STUDENT);

        String session1 = um.login("student1", "1234");
        String session2 = um.login("student1", "1234");

        assertNotEquals(session1, session2);
        assertTrue(um.isSessionActive(session1));
        assertTrue(um.isSessionActive(session2));
    }
}