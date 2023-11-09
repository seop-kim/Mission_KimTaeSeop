package com.likelion.wisesaying.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Saying {
    private Long id;
    private String content;
    private String author;

    public Saying() {
    }

    public Saying(String content, String author) {
        this.content = content;
        this.author = author;
    }

    public Saying(Long id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public void updateSaying(String content, String author) {
        this.content = content;
        this.author = author;
    }
    @Override
    public String toString() {
        return id + "\t/\t" + author + "\t/\t" + content;
    }
}
