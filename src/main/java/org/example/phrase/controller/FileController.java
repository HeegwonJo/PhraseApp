package org.example.phrase.controller;

import org.example.Path;
import org.example.phrase.entity.Phrase;

import java.io.*;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import static java.nio.file.Files.readAllLines;
import static org.example.App.phraseList;

public class FileController {

    int lastCnt;

    public FileController() throws IOException {
        lastCnt = 0;
        this.syncFromText();
    }

    public static void writeFile(Phrase newPhrase) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream(Path.textPath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(newPhrase);
            fos.close();
            oos.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAll() throws IOException {

        for (Phrase line : phraseList) {
            System.out.println(line);
        }
    }

    public static int readFileCount() throws IOException {
        return phraseList.size();
    }

    static public void readOne(int idx) throws IOException {
        System.out.println(phraseList.get(idx));
    }

    public void syncFromText() throws IOException {
        File file = new File(Path.textPath);
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(Path.textPath));
        }

            FileInputStream fis = new FileInputStream(Path.textPath);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    phraseList.add((Phrase) ois.readObject());
                } catch (EOFException e) {
                    break;
                } catch (IOException | ClassNotFoundException e) {
                    break;
                }
            }
        lastCnt = phraseList.size();
    }
    public void deleteAll() throws IOException {
        File file = new File(Path.textPath);
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(Path.textPath));
        }
        FileOutputStream fos = new FileOutputStream(Path.textPath);
        fos.write("".getBytes());
        fos.close();
        System.out.println(phraseList);
    }

}
