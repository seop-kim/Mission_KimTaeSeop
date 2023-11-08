package com.likelion.wisesaying.repository;

import com.likelion.wisesaying.domain.Saying;
import java.sql.Connection;
import java.util.List;

public interface IRepoAdapter {
    void save(Saying saying);

    List<Saying> findAll();

    Saying findOne(Long id);

    void delete(Long id);

    default void update(Saying saying) {}

    default Long maxId() {
        return 0L;
    }

    default Connection open() {
        return null;
    }

    default void close() {}




}
