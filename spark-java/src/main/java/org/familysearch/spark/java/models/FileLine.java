package org.familysearch.spark.java.models;

import java.io.Serializable;

public class FileLine implements Serializable {
    private String word;
    private String book;
    private String testament;

    public FileLine(String word, String book, String testament) {
        this.word = word;
        this.book = book;
        this.testament = testament;
    }

    @Override
    public String toString() {
        return this.word + " " + this.book + " " + this.testament;
    }

    public String getWord() {
        return word;
    }

    public String getBook() {
        return book;
    }

    public String getTestament() {
        return testament;
    }
}