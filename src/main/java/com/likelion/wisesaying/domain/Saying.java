package com.likelion.wisesaying.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Saying {
    private Long id;
    private String content;
    private String author;

    @Override
    public String toString() {
        return id + "\t/\t" + author + "\t/\t" + content;

    }
}
