package ru.grushetsky.itk.config;

import ru.grushetsky.itk.diskops.AudioDir;

public class SessionConfig {
    private AudioDir[] destinations;

    public SessionConfig() {}

    public void setDestinations(String[] destinations) throws Exception {
        this.destinations = new AudioDir[destinations.length];
        for (int i = 0; i < this.destinations.length; i++) {
            this.destinations[i] = new AudioDir(destinations[i]);
        }
    }

    public AudioDir[] getDestinations() {
        return new String[]{"C:\\temp\\test_dest"};
    }

}
