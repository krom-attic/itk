package ru.grushetsky.itk.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ru.grushetsky.itk.config.Session;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SessionJsonFileProvider implements ISessionProvider {
    final static ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public Session readSession(String sessionId) {
        Path sessionPath = buildPath(sessionId);

        String sessionJson;
        try (BufferedReader reader = Files.newBufferedReader(sessionPath, StandardCharsets.UTF_8)) {
            StringBuilder builder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            sessionJson = builder.toString();

        } catch (IOException e) {
            // TODO handle non-existant (or?) file
            sessionJson = "{\"sources\": [\"C:\\\\test\\\\audiobooks\\\\\", \"C:\\\\test\\\\music\\\\\", \"C:\\\\test\\\\podcasts\\\\\"], \"destinations\": [\"C:\\\\test\\\\player\\\\\"]}";
        }

        Session session;
        // Инициализировать объект конфига
        try {
            session = MAPPER.readValue(sessionJson, Session.class);
        } catch (IOException e) {
            // TODO Throw an exception!
            e.printStackTrace();
            session = null;
        }

        return session;

    }

    @Override
    public void writeSession(Session session) {
        MAPPER.enable(SerializationFeature.INDENT_OUTPUT);

        String jsonConfig = null;
        try {
            jsonConfig = MAPPER.writeValueAsString(session);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // TODO Write to file
        System.out.print(jsonConfig);
    }

    private Path buildPath(String sessionId) {
        return Paths.get(".", sessionId + ".json");
    }
}
