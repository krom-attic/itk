package ru.grushetsky.itk.config;

import com.sun.istack.internal.Nullable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.grushetsky.itk.diskops.AudioDir;
import ru.grushetsky.itk.io.StringFileReader;

import java.nio.file.Paths;

public class Settings {
    private static Settings ourInstance = new Settings();

    private ObservableList<AudioDir> sources = FXCollections.observableArrayList();

    private String lastSessionId;

    public static Settings getInstance() {
        return ourInstance;
    }

    public void loadSettings(ISettingsReader settingsReader) {
        String settingsJson = StringFileReader.readFile(Paths.get(".", "settings.json"));
//        String settingsJson = "{\"sources\": [\"C:\\\\test\\\\audiobooks\\\\\", \"C:\\\\test\\\\music\\\\\", \"C:\\\\test\\\\podcasts\\\\\"], \"destinations\": [\"C:\\\\test\\\\player\\\\\"]}";

        settingsReader.readSettings(settingsJson);
    }

    public void setSources(String[] sources) throws Exception {
        this.sources.clear();
        for (String sourcePath : sources) {
            this.sources.add(new AudioDir(sourcePath));
        }
    }

    public ObservableList<AudioDir> getSources() {
        return this.sources;
    }

    @Nullable
    public String getLastSessionId() {
        return lastSessionId;
    }

    public void setLastSessionId(String lastSessionId) {
        this.lastSessionId = lastSessionId;
    }
}
