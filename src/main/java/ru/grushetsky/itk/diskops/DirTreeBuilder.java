package ru.grushetsky.itk.diskops;

import java.io.IOException;
import java.nio.file.*;

public class DirTreeBuilder extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.format("Folder: %s\n", dir);
        return FileVisitResult.CONTINUE;
    }

    // TODO убрать
    public static void main(String[] args) {
        DirTreeBuilder dirTreeBuilder = new DirTreeBuilder();
        try {
            Files.walkFileTree(Paths.get("C:\\jython2.7.0"), dirTreeBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
