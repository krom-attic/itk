package ru.grushetsky.itk.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import ru.grushetsky.itk.FS;

import java.io.File;

public class AudioDir {
    private ObjectProperty<File> basedir;
    private ObjectProperty<FS> fs;

    public AudioDir(String path) throws Exception {
        this.basedir = new SimpleObjectProperty<File>(new File(path));
        this.fs = new SimpleObjectProperty<FS>(new FS(this.basedir.getValue()));
    }

    public File getBasedir() {
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

    public void print() {
        System.out.println(this.toString());
    }
}