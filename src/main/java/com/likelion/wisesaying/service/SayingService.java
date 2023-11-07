package com.likelion.wisesaying.service;

import com.likelion.wisesaying.domain.Saying;
import com.likelion.wisesaying.repository.SayingRepository;
import com.likelion.wisesaying.util.generator.IdGenerator;

public class SayingService {
    private final SayingRepository repository = SayingRepository.getInstance();
    private final IdGenerator generator = new IdGenerator();

    public Long save(Saying saying) {
        Long saveId = generator.createId();
        saying.setId(saveId);
        repository.save(saying);
        return saveId;
    }
}