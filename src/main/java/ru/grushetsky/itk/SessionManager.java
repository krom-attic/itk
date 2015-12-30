package ru.grushetsky.itk;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ru.grushetsky.itk.model.Session;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SessionManager {
    final static ObjectMapper MAPPER = new ObjectMapper();
    File settingsFile;
    Session session;

    public SessionManager(File settingsFile) {
        this.settingsFile = settingsFile;
    }

    public SessionManager(String settingsFileName) {
        this(new File(settingsFileName));
    }

    public void readConfig() {
        String jsonConfig;

        try {
            FileInputStream inputStream = new FileInputStream(this.settingsFile);
            // Считать JSON из файла
            jsonConfig = "";
        } catch (FileNotFoundException e) {

            // Создать пустой JSON
            jsonConfig = "{\"sources\": [\"C:\\\\test\\\\audiobooks\\\\\", \"C:\\\\test\\\\music\\\\\", \"C:\\\\test\\\\podcasts\\\\\"], \"destinations\": [\"C:\\\\test\\\\player\\\\\"]}";
        }

        Session session;

        // Инициализировать объект конфига
        try {
            session = MAPPER.readValue(jsonConfig, Session.class);
        } catch (IOException e) {
            // TODO Throw an exception!
            e.printStackTrace();
            session = null;
        }

        this.session = session;
    }

    public void saveConfig(Session session) {

        MAPPER.enable(SerializationFeature.INDENT_OUTPUT);

        String jsonConfig = null;
        try {
            jsonConfig = MAPPER.writeValueAsString(session);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(jsonConfig);
    }

    public Session getSession() {
        if (this.session == null) {
            readConfig();
        }

        return this.session;
    }
}
