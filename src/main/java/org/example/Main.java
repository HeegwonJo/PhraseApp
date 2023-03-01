package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int idx = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Phrase> List = new LinkedList<Phrase>();
        System.out.println("==== 명언 앱====");
        Phrase 명언;
        while (true) {
            System.out.printf("명령 )");
            String cmd = br.readLine();
            if (cmd.equals("등록")) {

                System.out.printf("명언 : ");
                String tmpPhrase = br.readLine();
                System.out.printf("작가 :");
                String tmpAuthor = br.readLine();
                명언 = new Phrase(idx, tmpPhrase, tmpAuthor);
                List.add(명언);
                System.out.println(idx + " 번 명언이 등록 되었습니다.");
                idx++;
            } else if (cmd.equals("종료")) {
                System.out.println("종료합니다.");
                break;
            }
            else if (cmd.equals("목록")){
                System.out.println("번호  /   작가   /    명언");
                for(int i=0; i<List.size(); i++){
                    명언.조회();
                }
            }
            else {
                System.out.println("잘못된 명령입니다");
            }
        }


    }

    static class Phrase {
        private int index;
        private String phrase;
        private String author;

        public Phrase(int index, String phrase, String author) {
            this.index = index;
            this.phrase = phrase;
            this.author = author;
        }

        @Override
        public String toString() {
            return "Phrase{" +
                    "명언='" + phrase + '\'' +
                    ", 작가='" + author + '\'' +
                    '}';
        }
        public void 조회(){
            System.out.println(this.index + "/" + this.author + " : " + this.phrase);
        }
        public String getPhrase() {
            return phrase;
        }

        public void setPhrase(String phrase) {
            this.phrase = phrase;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
}