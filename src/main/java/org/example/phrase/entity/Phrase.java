package org.example.phrase.entity;

import java.io.Serializable;

public class Phrase implements Serializable {
    private int id;
    private String content;
    private String author;
    static final long serialVersionUID = 1L;
    public Phrase(int index, String content, String author) {

        this.id = index;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return id + " / " + author + " / " + content ;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}