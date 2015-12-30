package ru.grushetsky.itk;

import java.io.File;

public class FS {

    private File path;

    public FS(File path) throws Exception {
        if (path.isDirectory()) this.path = path;
        else throw new Exception("Specified path is not a directory");
    }

    public File[] listDir() {
        return this.path.listFiles();
    }
}