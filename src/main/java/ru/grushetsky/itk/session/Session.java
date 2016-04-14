package ru.grushetsky.itk.session;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.grushetsky.itk.diskops.AudioDir;

public class Session {
    private ObservableList<AudioDir> destinations = FXCollections.observableArrayList();

    private String sessionId;

    private AudioDir selectedDestination;

    public Session() {
    }

    public Session(String sessionId) {
        this.sessionId = sessionId;
    }

    public ObservableList<AudioDir> getDestinations() {
        return this.destinations;
    }

    public void setDestinations(String[] destinations) {
//        destinations = new String[]{"C:\\temp\\test_dest"};
        this.destinations.clear();
        for (String destPath : destinations) {
            this.destinations.add(new AudioDir(destPath));
        }
    }

}
