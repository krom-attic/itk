package ru.grushetsky.itk.config;

import ru.grushetsky.itk.io.ISessionProvider;
import ru.grushetsky.itk.io.SessionJsonFileProvider;
import ru.grushetsky.itk.main.Session;

import java.util.HashMap;

public class SessionManager {
    ???? sessionReader;

    private static SessionManager outInstance = new SessionManager();

    private HashMap<String, Session> sessions = new HashMap<>();

    public static SessionManager getInstance() {
        return outInstance;
    }

    private SessionManager() {

    }

    public void createSession() {
     // TODO
    }

    public Session getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            // TODO What if stored sessionConfig doesn't exist?

            Session session = sessionReader.?????(sessionId);
            sessions.put(sessionId, Session);
            return sessionConfig;
        }
    }

    public HashMap<String, Session> getSessions() {
        return sessions;
    }
}
