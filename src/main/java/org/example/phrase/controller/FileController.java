package org.example.phrase.controller;

import org.example.phrase.entity.Phrase;

import java.io.*;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class FileController{
    static List<String> lines;

    static {
        try {
            lines = readAllLines(Paths.get("/Users/heegwonjo/Desktop/멋사/phraseApp/phrase.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static File file = new File("/Users/heegwonjo/Desktop/멋사/phraseApp/phrase.txt");

    public static void writeFile(Phrase newPhrase) throws IOException {
        try {
           FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(newPhrase);
            fos.close();
            oos.close();


        }catch (IOException e){
            e.printStackTrace();
        }


    }
    public static void readAll() throws IOException {
        try{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            lines = (List<String>) ois.readObject();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static int readFileCount() throws IOException {
        return lines.size();
    }

    static public void readOne(int idx) throws IOException {
        System.out.println(lines.get(idx));
    }
}
