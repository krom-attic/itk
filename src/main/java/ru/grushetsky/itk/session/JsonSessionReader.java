package ru.grushetsky.itk.session;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonSessionReader implements ISessionReader {
    final static ObjectMapper MAPPER = new ObjectMapper();
    String sessionJson;

    public JsonSessionReader(String jsonString) {
        this.sessionJson = jsonString;
    }

    @Override
    public Session readSession() {
        Session session;
        try {
            session = MAPPER.readValue(sessionJson, Session.class);
        } catch (IOException e) {
            // TODO Throw an exception!
            e.printStackTrace();
            session = null;
        }
        return session;
    }
}
