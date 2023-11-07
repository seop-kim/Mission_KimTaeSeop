package com.likelion.wisesaying.repository;

import com.likelion.wisesaying.domain.Saying;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;

public class SayingRepository {
    @Getter
    private static final SayingRepository instance = new SayingRepository();
    private final Map<Long, Saying> sayings = new HashMap<>();
    private SayingRepository() {
    }

    public void save(Saying saying) {
        sayings.put(saying.getId(), saying);
    }

    public List<Saying> findAll() {
        return new ArrayList<>(sayings.values());
    }

    public Saying findOne(Long id) {
        return sayings.get(id);
    }
    public void delete(Long id) {
        sayings.remove(id);
    }
}