package org.example;

import org.example.System.Controller.SystemController;
import org.example.phrase.controller.PhraseController;
import org.example.phrase.controller.FileController;
import org.example.phrase.entity.Phrase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class App {
    public static LinkedList<Phrase> phraseList = new LinkedList<Phrase>();
    static int idx = 1;

    public static void run() throws IOException {
        FileController fc = new FileController();
        PhraseController phraseController = new PhraseController();
        SystemController systemController = new SystemController();
        System.out.println("==== 명언 앱====");
        fc.syncFromText();
        while (true) {
            System.out.print("명령) ");
            // trim() : 혹시 있을지 모를 좌우공백제거된 버전으로 주세요.
            String command = Container.getReader().readLine().trim();
            Rq rq = new Rq(command);

            switch (rq.getActionCode()) {
                case "종료":
                    systemController.exit();
                    return;
                case "등록":
                    phraseController.create();
                    break;
                case "목록":
                    phraseController.list();
                    break;
                case "수정":
                    phraseController.update(rq);
                    break;
                case "빌드":
                    phraseController.build();
                    break;
                case "삭제":
                    phraseController.delete(rq);
                    break;
                case "전체 삭제":
                    phraseController.deleteAll();
                    break;

            }

        }
    }

}

