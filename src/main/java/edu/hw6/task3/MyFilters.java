package edu.hw6.task3;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class MyFilters {
    private MyFilters() {
    }

    static AbstractFilter isRegularFile() {
        return Files::isRegularFile;
    }

    static AbstractFilter isReadable() {
        return Files::isReadable;
    }

    static AbstractFilter isWritable() {
        return Files::isWritable;
    }

    public static AbstractFilter largerThan(int min) {
        return path -> Files.size(path) >= min;
    }

    public static AbstractFilter magicNumber(char... bytes) {
        return path -> {
            var fileBytes = Files.readAllBytes(path);
            if (bytes.length > fileBytes.length) {
                return false;
            }

            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] != fileBytes[i]) {
                    return false;
                }
            }
            return true;
        };
    }

    public static AbstractFilter globMatcher(String glob) {
        return (Path path) -> {
            var realFileExtension = new File(path.toString()).getName().split("\\.")[1];

            return realFileExtension.equals(glob);
        };
    }

    public static AbstractFilter regexMatches(String regex) {
        return (Path path) -> {
            var pattern = Pattern.compile(regex);
            var fileName = new File(path.toString()).getName();
            var matcher = pattern.matcher(fileName);

            return matcher.matches();
        };
    }
}
