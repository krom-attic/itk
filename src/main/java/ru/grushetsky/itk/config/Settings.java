package ru.grushetsky.itk.config;

import com.sun.istack.internal.Nullable;

public class Settings {
    private static Settings ourInstance = new Settings();

    private String lastSessionId;

    public static Settings getInstance() {
        return ourInstance;
    }

    private Settings() {
        // TODO Init settings
    }

    @Nullable
    public String getLastSessionId() {
        return lastSessionId;
    }

    public void setLastSessionId(String lastSessionId) {
        this.lastSessionId = lastSessionId;
    }
}
