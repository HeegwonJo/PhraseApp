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

        while (true) {
            System.out.printf("명령 )");
            String cmd = br.readLine();
            if (cmd.equals("등록")) {

                System.out.printf("명언 : ");
                String tmpPhrase = br.readLine();
                System.out.printf("작가 :");
                String tmpAuthor = br.readLine();
                Phrase 명언 = new Phrase(idx, tmpPhrase, tmpAuthor);
                List.add(명언);
                System.out.println(idx + " 번 명언이 등록 되었습니다.");
                idx++;
            } else if (cmd.equals("종료")) {
                System.out.println("종료합니다.");
                break;
            } else if (cmd.equals("목록")) {
                if (List.isEmpty()) {
                    System.out.println("등록 된 명언이 없습니다.");
                    continue;
                }

                System.out.println(" 번호  /   작가   /    명언");
                System.out.println("-------------------------");
                for (int i = 0; i < List.size(); i++) {
                    System.out.println(List.get(i));
                }
            } else if (cmd.contains("삭제")) {
                int deleteIdx = Integer.parseInt(cmd.split("=")[1]);
                ;

                try {
                    List.remove(deleteIdx - 1);
                    System.out.println(deleteIdx + "번 명언이 삭제 되었습니다.");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(deleteIdx + " 번 명언은 존재하지 않습니다.");
                }


            } else {
                System.out.println("잘못된 명령입니다");
            }
        }


    }

}