package ru.grushetsky.itk.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

public class JsonSettingsWriter implements ISettingsWriter {
    final static ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public void writeSettings(Settings settings) {
        MAPPER.enable(SerializationFeature.INDENT_OUTPUT);

        String jsonConfig = null;
        try {
            jsonConfig = MAPPER.writeValueAsString(settings);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // TODO Write to file
        System.out.print(jsonConfig);
    }
}
