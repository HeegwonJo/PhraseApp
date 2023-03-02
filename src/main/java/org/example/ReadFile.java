package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("/Users/heegwonjo/Desktop/멋사/phraseApp/phrase.txt"));
        System.out.println(lines);
    }

    public static void readAll() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("/Users/heegwonjo/Desktop/멋사/phraseApp/phrase.txt"));
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static int readFileCount() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("/Users/heegwonjo/Desktop/멋사/phraseApp/phrase.txt"));
        return lines.size();
    }

    static public void readOne(int idx) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("/Users/heegwonjo/Desktop/멋사/phraseApp/phrase.txt"));
        System.out.println(lines.get(idx));
    }
}
