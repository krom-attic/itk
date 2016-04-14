package ru.grushetsky.itk.diskops;

import java.nio.file.Files;
import java.nio.file.Path;

public class FS {

    private Path path;

    public FS(Path path) {
        if (Files.isDirectory(path)) this.path = path;
        // TODO Is it possible?
//        else throw new Exception("Specified path is not a directory");
    }

//    public File[] listDir() {
//        return this.path.listFiles();
//    }
}