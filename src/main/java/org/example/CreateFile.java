package org.example;

import java.io.*;

public class CreateFile {
    static File file = new File("/Users/heegwonjo/Desktop/멋사/phraseApp/phrase.txt");
    public static void main(String[] args) throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file,true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void writeFile(String newPhrase) throws IOException {

        FileWriter fw =new FileWriter(file,true);
        PrintWriter writer = new PrintWriter(fw);
        writer.println(newPhrase);
        writer.close();

    }
}
