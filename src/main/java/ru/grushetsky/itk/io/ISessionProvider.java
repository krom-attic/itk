package ru.grushetsky.itk.io;


import ru.grushetsky.itk.config.Session;

public interface ISessionProvider {
    Session readSession(String sessionId);

    void writeSession(Session session);
}
