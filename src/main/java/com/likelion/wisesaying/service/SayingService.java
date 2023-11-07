package com.likelion.wisesaying.service;

import com.likelion.wisesaying.domain.Saying;
import com.likelion.wisesaying.repository.SayingRepository;
import com.likelion.wisesaying.util.convertor.RequestConverter;
import com.likelion.wisesaying.util.generator.IdGenerator;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SayingService {
    private final SayingRepository repository = SayingRepository.getInstance();
    private final IdGenerator generator = new IdGenerator();
    private final RequestConverter converter = new RequestConverter();

    public Long save(Saying saying) {
        Long saveId = generator.createId();
        saying.setId(saveId);
        repository.save(saying);
        
        return saveId;
    }

    public List<Saying> findAll() {
        List<Saying> sayings = repository.findAll();
        Collections.reverse(sayings);
        return sayings;
    }

    public Long delete(String request) {
        Long findId = convertId(request);
        repository.delete(findId);
        return findId;
    }

    public Saying update(String request) {
        Long findId = convertId(request);
        return repository.findOne(findId);
    }

    private Long convertId(String request) {
        Long findId = converter.splitId(request);
        if (repository.findOne(findId) == null) {
            throw new IllegalArgumentException(findId + "번 명언은 존재하지 않습니다.");
        }
        return findId;
    }
}