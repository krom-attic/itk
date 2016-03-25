package ru.grushetsky.itk.diskops;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AudioDir implements IDirLister {
    private ObjectProperty<Path> basedir;
    private ObjectProperty<FS> fs;

    public AudioDir(String path) throws Exception {
        this.basedir = new SimpleObjectProperty<>(Paths.get(path));
        this.fs = new SimpleObjectProperty<>(new FS(this.basedir.getValue()));
    }

    public Path getBasedir() {
        return this.basedir.get();
    }

    public ObjectProperty basedirProperty() {
        return this.basedir;
    }

    public FS getFs() {
        return fs.get();
    }

    public ObjectProperty fsProperty() {
        return fs;
    }

    public String toString() {
        return "AudioDir object with path: " + this.basedir.toString();
    }

    public String getShortName() {
        return getBasedir().getFileName().toString();
    }

    public void print() {
        System.out.println(this.toString());
    }
}