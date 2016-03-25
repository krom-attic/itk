package ru.grushetsky.itk.config;

import ru.grushetsky.itk.io.ISessionProvider;
import ru.grushetsky.itk.io.SessionJsonFileProvider;

import java.util.HashMap;

public class SessionManager {
    ISessionProvider sessionRW;

    private static SessionManager outInstance = new SessionManager();

    private HashMap<String, Session> sessions = new HashMap<>();

    public static SessionManager getInstance() {
        return outInstance;
    }

    private SessionManager() {
        sessionRW = new SessionJsonFileProvider();
    }

    public void createSession() {
     // TODO
    }

    public Session getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            // TODO What if stored session doesn't exist?
            Session session = sessionRW.readSession(sessionId);
            sessions.put(sessionId, session);
            return session;
        }
    }

    public HashMap<String, Session> getSessions() {
        return sessions;
    }
}
