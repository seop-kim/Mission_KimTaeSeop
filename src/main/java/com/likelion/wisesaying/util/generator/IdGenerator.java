package com.likelion.wisesaying.util.generator;

public class IdGenerator {
    private Long id = 0L;
    public Long createId() {
        return ++id;
    }
}