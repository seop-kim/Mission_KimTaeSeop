package com.likelion.wisesaying.repository;

import com.likelion.wisesaying.domain.Saying;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SayingRepository {
    private static final SayingRepository instance = new SayingRepository();
    private final Map<Long, Saying> sayings = new HashMap<>();
    private SayingRepository() {
    }

    public static SayingRepository getInstance() {
        return instance;
    }

    public void save(Saying saying) {
        sayings.put(saying.getId(), saying);
    }

    public List<Saying> findAll() {
        return new ArrayList<>(sayings.values());
    }
}