package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class App {
    static int idx = 1;

    public static void main(String[] args) throws IOException {}

    public static void run() throws IOException {
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
                CreateFile.writeFile(명언.toString());
            } else if (cmd.equals("종료")) {
                System.out.println("종료합니다.");
                break;
            } else if (cmd.equals("목록")) {
                if (ReadFile.readFileCount()==0) {
                    System.out.println("등록 된 명언이 없습니다.");
                    continue;
                }

                System.out.println(" 번호  /   작가   /    명언");
                System.out.println("-------------------------");
                ReadFile.readAll();
                for (int i=0; i<ReadFile.readFileCount(); i++) {
                    List.add(ReadFile.readOne(i));
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
            }
            else if(cmd.contains("수정")){
                int updateIdx=Integer.parseInt(cmd.split("=")[1]);
                String originContent=List.get(updateIdx-1).getContent();
                String originAuthor=List.get(updateIdx-1).getAuthor();
                System.out.println("명언 (기존) : " + originContent);
                System.out.printf("명언 : ");
                String newContent=br.readLine();
                List.get(updateIdx-1).setContent(newContent);
                System.out.println("작가 (기존) :" + originAuthor);
                System.out.printf("작가 : ");
                String newAuthor=br.readLine();
                List.get(updateIdx-1).setAuthor(newAuthor);
                System.out.println(updateIdx+ "번 명언이 수정 되었습니다");
            }


            else {
                System.out.println("잘못된 명령입니다");
            }
        }
    }

}