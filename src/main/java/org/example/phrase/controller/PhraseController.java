package org.example.phrase.controller;
import org.example.Rq;
import org.example.phrase.entity.Phrase;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.example.App.phraseList;
import static org.example.Container.br;

public class PhraseController {
    private int idx;
    private List<Phrase> PhraseList;
    FileController fc;
    public PhraseController() {
        this.PhraseList=new LinkedList<>();
    }


    public void create() throws IOException {

        System.out.printf("명언 : ");
        String tmpPhrase = br.readLine();
        System.out.printf("작가 :");
        String tmpAuthor = br.readLine();
        Phrase 명언 = new Phrase(idx, tmpPhrase, tmpAuthor);
        phraseList.add(명언);
        System.out.println(idx + " 번 명언이 등록 되었습니다.");
        idx++;
        fc.writeFile(명언);
    }

    public void list() throws IOException {

        if (FileController.readFileCount()==0) {
            System.out.println("등록 된 명언이 없습니다.");
            return;
        }

        System.out.println(" 번호  /   작가   /    명언");
        System.out.println("-------------------------");
        FileController.readAll();

    }
    public void delete(Rq rq){
        int deleteIdx = rq.getIntParam("id", -1);

        try {
            phraseList.remove(deleteIdx - 1);
            System.out.println(deleteIdx + "번 명언이 삭제 되었습니다.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(deleteIdx + " 번 명언은 존재하지 않습니다.");
        }
    }
    public void update(Rq rq) throws IOException {
        int updateIdx = rq.getIntParam("id", -1);
        String originContent=phraseList.get(updateIdx-1).getContent();
        String originAuthor=phraseList.get(updateIdx-1).getAuthor();
        System.out.println("명언 (기존) : " + originContent);
        System.out.printf("명언 : ");
        String newContent=br.readLine();
        phraseList.get(updateIdx).setContent(newContent);
        System.out.println("작가 (기존) :" + originAuthor);
        System.out.printf("작가 : ");
        String newAuthor=br.readLine();
        phraseList.get(updateIdx).setAuthor(newAuthor);
        System.out.println(updateIdx+ "번 명언이 수정 되었습니다");
    }
    public void build() throws IOException {
        JSONArray outer = new JSONArray();
        for(Phrase p: phraseList) {
            JSONObject inner = new JSONObject();
            inner.put("id", p.getId());
            inner.put("content", p.getContent());
            inner.put("author", p.getAuthor());
            outer.add(inner);
        }

        String fileName = "data.json";
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(outer.toJSONString());
        fileWriter.flush();
        fileWriter.close();

        System.out.printf("%s 파일의 내용이 갱신되었습니다.\n", fileName);
    }
}
