package ru.grushetsky.itk.config;

import com.sun.istack.internal.Nullable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.grushetsky.itk.diskops.AudioDir;

public class Settings {
    private String lastSessionId;

    private ObservableList<AudioDir> sources = FXCollections.observableArrayList();

    public ObservableList<AudioDir> getSources() {
        return this.sources;
    }

    public void setSources(String[] sources) {
        this.sources.clear();
        for (String sourcePath : sources) {
            this.sources.add(new AudioDir(sourcePath));
        }
    }

    @Nullable
    public String getLastSessionId() {
        return lastSessionId;
    }

    public void setLastSessionId(String lastSessionId) {
        this.lastSessionId = lastSessionId;
    }
}
