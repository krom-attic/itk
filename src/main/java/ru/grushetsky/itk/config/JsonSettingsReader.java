package ru.grushetsky.itk.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonSettingsReader implements ISettingsReader {
    final static ObjectMapper MAPPER = new ObjectMapper();

    public JsonSettingsReader(String JsonString) {

    }

    @Override
    public Settings readSettings(String sessionJson) {
        Settings settings;
        // Инициализировать объект конфига
        try {
            settings = MAPPER.readValue(sessionJson, Settings.class);
        } catch (IOException e) {
            // TODO Throw an exception!
            e.printStackTrace();
            settings = null;
        }

        return settings;
    }
}
