package ru.grushetsky.itk.config;

import ru.grushetsky.itk.diskops.AudioDir;

public class Session {
    private AudioDir[] sources;
    private AudioDir[] destinations;

    public Session() {}

    public void setDestinations(String[] destinations) throws Exception {
        this.destinations = new AudioDir[destinations.length];
        for (int i = 0; i < this.destinations.length; i++) {
            this.destinations[i] = new AudioDir(destinations[i]);
        }
    }

    public void setSources(String[] sources) throws Exception {
        this.sources = new AudioDir[sources.length];
        for (int i = 0; i < this.sources.length; i++) {
            this.sources[i] = new AudioDir(sources[i]);
        }
    }

    public AudioDir[] getDestinations() {
        return destinations;
    }

    public AudioDir[] getSources() {
        return sources;
    }
}
