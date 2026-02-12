package user_management;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserManager {

    public enum Role {
        STUDENT, TEACHER, ADMIN
    }

    // Store users: username → password
    private Map<String, String> users = new HashMap<>();

    // Store roles: username → role
    private Map<String, Role> roles = new HashMap<>();

    // Store sessions: sessionId → username
    private Map<String, String> sessions = new HashMap<>();


    // ---------------- REGISTER ----------------
    public boolean registerUser(String username, String password, Role role) {
        if (username == null || password == null || role == null)
            throw new IllegalArgumentException("Invalid input");

        if (username.isBlank() || password.length() < 4)
            return false;

        if (users.containsKey(username))
            return false;

        users.put(username, password);
        roles.put(username, role);
        return true;
    }


    // ---------------- LOGIN ----------------
    public String login(String username, String password) {

        if (!users.containsKey(username))
            return null;

        if (!users.get(username).equals(password))
            return null;

        // Generate session ID
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, username);
        return sessionId;
    }


    // ---------------- LOGOUT ----------------
    public boolean logout(String sessionId) {
        return sessions.remove(sessionId) != null;
    }


    // ---------------- SESSION CHECK ----------------
    public boolean isSessionActive(String sessionId) {
        return sessions.containsKey(sessionId);
    }


    // ---------------- ROLE CHECK ----------------
    public boolean hasAccess(String sessionId, Role requiredRole) {
        if (!sessions.containsKey(sessionId))
            return false;

        String username = sessions.get(sessionId);
        return roles.get(username) == requiredRole;
    }


    // ---------------- GET USER ROLE ----------------
    public Role getUserRole(String username) {
        return roles.get(username);
    }
}