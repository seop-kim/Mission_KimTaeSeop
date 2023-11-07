package com.likelion.wisesaying.service;

import com.likelion.wisesaying.domain.Saying;
import com.likelion.wisesaying.repository.SayingRepository;
import com.likelion.wisesaying.util.convertor.RequestConverter;
import com.likelion.wisesaying.util.generator.IdGenerator;
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
        return repository.findAll();
    }

    public Long delete(String request) {
        Long deleteId = converter.splitId(request);

        if (repository.findOne(deleteId) == null) {
            throw new IllegalArgumentException(deleteId + "번 명언은 존재하지 않습니다.");
        }

        repository.delete(deleteId);
        return deleteId;
    }
}