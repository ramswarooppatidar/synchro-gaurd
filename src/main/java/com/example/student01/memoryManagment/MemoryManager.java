package com.example.student01.memoryManagment;

import java.util.LinkedHashMap;
import java.util.Map;

public class MemoryManager {
    private static final int MAX_ENTRIES = 100; // Limit the session cache size
    private static Map<String, byte[]> largeSessionData = new LinkedHashMap<String, byte[]>(MAX_ENTRIES, 0.75F, true) {
        protected boolean removeEldestEntry(Map.Entry<String, byte[]> eldest) {
            return size() > MAX_ENTRIES;
        }
    };

    public static void addSessionData(String sessionId) {
        largeSessionData.put(sessionId, new byte[10 * 1024 * 1024]); // 10MB per session
    }

    public static void removeSessionData(String sessionId) {
        largeSessionData.remove(sessionId);
    }
}

