package ru.grushetsky.itk.session;

import ru.grushetsky.itk.io.StringFileReader;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.UUID;

public class SessionManager {
    private static SessionManager outInstance = new SessionManager();

    private HashMap<String, Session> sessions = new HashMap<>();

    public static SessionManager getInstance() {
        return outInstance;
    }

    private SessionManager() {

    }

    public Session createSession() {
        String sessionId = UUID.randomUUID().toString().substring(8);
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        if (sessionId == null) {
            return createSession();
        }
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            // TODO What if stored session doesn't exist?
            String storedSession = "{\"destinations\": [\"C:\\\\test\\\\player\\\\\"]}";
//            String storedSession = getStoredSession(sessionId);
            ISessionReader sessionReader = new JsonSessionReader(storedSession);
            Session session = sessionReader.readSession();
            sessions.put(sessionId, session);
            return session;
        }
    }

    public HashMap<String, Session> getSessions() {
        return sessions;
    }

    private String getStoredSession(String sessionId) {
        return StringFileReader.readFile(Paths.get(".", sessionId + ".json"));
    }
}
