package ru.grushetsky.itk.main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.grushetsky.itk.MainApp;
import ru.grushetsky.itk.config.SessionConfig;
import ru.grushetsky.itk.diskops.AudioDir;

public class Session {
    private ObservableList<AudioDir> destinations = FXCollections.observableArrayList();
    private AudioDir selectedDestination;

    private MainApp mainApp;

    public Session(MainApp mainApp, SessionConfig sessionConfig) {
        this.mainApp = mainApp;

        this.destinations.setAll(sessionConfig.getDestinations());

    }

    public ObservableList<AudioDir> getDestinations() {
        return this.destinations;
    }

}
