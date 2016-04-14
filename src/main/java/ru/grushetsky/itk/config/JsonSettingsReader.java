package ru.grushetsky.itk.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonSettingsReader implements ISettingsReader {
    final static ObjectMapper MAPPER = new ObjectMapper();
    String settingsJson;

    public JsonSettingsReader(String jsonString) {
        this.settingsJson = jsonString;
    }

    @Override
    public Settings readSettings() {
        Settings settings;
        try {
            settings = MAPPER.readValue(settingsJson, Settings.class);
        } catch (IOException e) {
            // TODO Throw an exception!
            e.printStackTrace();
            settings = null;
        }
        return settings;
    }
}
