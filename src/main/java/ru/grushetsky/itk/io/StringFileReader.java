package ru.grushetsky.itk.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StringFileReader {
    public static String readFile(Path filePath) {
        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            StringBuilder builder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            return builder.toString();

        } catch (IOException e) {
            // TODO handle non-existant (or?) file
            return null;
        }
    }

    public static String readJsonByName(String fileName) {
        Path filePath = Paths.get(".", fileName + ".json");
        String fileContent = readFile(filePath);
        if (fileContent == null) return "{}";
        else return fileContent;
    }
}
