package ru.grushetsky.itk.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ru.grushetsky.itk.config.SessionConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SessionJsonFileProvider implements ISessionProvider {

    @Override
    public SessionConfig readSession(String sessionId) {
        Path sessionPath = buildPath(sessionId);

        String sessionJson;


        SessionConfig sessionConfig;

        return sessionConfig;

    }

    @Override
    public void writeSession(SessionConfig sessionConfig) {

    }

    private Path buildPath(String sessionId) {
        return Paths.get(".", sessionId + ".json");
    }
}
