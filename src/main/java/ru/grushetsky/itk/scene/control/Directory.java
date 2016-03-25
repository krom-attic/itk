package ru.grushetsky.itk.scene.control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.nio.file.Path;

public class Directory implements IHierarchicalData<Directory> {
    private final Path path;
    private ObservableList<Directory> children = FXCollections.observableArrayList();

    /**
     * Stub constructor for root elemets
     */
    public Directory() {
        this.path = null;
    }

    public Directory(Path path) {
        this.path = path;
    }

    @Override
    public ObservableList<Directory> getChildren() {
        // TODO Possibly should be lazy
        return children;
    }

    public String getName() {
        return path.toString();
    }

    public Path getPath() {
        return path;
    }

    @Override
    public String toString() {
        return getName();
    }
}
