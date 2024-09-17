package com.example.student01.memoryManagment;

import java.util.concurrent.ConcurrentHashMap;
import java.util.UUID;
import java.util.*;

public class SessionManager {
    private Map<String, String> sessions = new ConcurrentHashMap<>();

    public String login(String userId) {
        if (sessions.containsKey(userId)) {
            return "User already logged in.";
        }
        String sessionId = "SESSION_" + UUID.randomUUID().toString();
        sessions.put(userId, sessionId);

        // Here, Redis or a distributed cache can be used to synchronize session data
        return "Login successful. Session ID: " + sessionId;
    }

    public String logout(String userId) {
        if (!sessions.containsKey(userId)) {
            return "User not logged in.";
        }
        sessions.remove(userId);
        return "Logout successful.";
    }

    public String getSessionDetails(String userId) {
        if (!sessions.containsKey(userId)) {
            throw new RuntimeException("Session not found for user " + userId);
        }
        return "Session ID for user " + userId + ": " + sessions.get(userId);
    }
}

