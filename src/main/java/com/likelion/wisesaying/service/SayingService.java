package com.likelion.wisesaying.service;

import com.likelion.wisesaying.domain.Saying;
import com.likelion.wisesaying.repository.SayingRepository;
import com.likelion.wisesaying.util.convertor.RequestConverter;
import com.likelion.wisesaying.util.file.LocalDataLoad;
import com.likelion.wisesaying.util.file.LocalDataSave;
import com.likelion.wisesaying.util.generator.IdGenerator;
import com.likelion.wisesaying.util.gson.GsonDataConverter;
import java.util.Collections;
import java.util.List;

public class SayingService {
    private final SayingRepository repository = SayingRepository.getInstance();
    private final RequestConverter converter = new RequestConverter();
    private final LocalDataLoad localDataLoad = new LocalDataLoad();
    private final LocalDataSave localDataSave = new LocalDataSave();
    private final GsonDataConverter gson = new GsonDataConverter();
    private final IdGenerator generator = new IdGenerator();

    public Long save(Saying saying) {
        Long saveId = generator.createId();
        saying.setId(saveId);
        repository.save(saying);
        
        return saveId;
    }

    public List<Saying> findAllReverse() {
        List<Saying> sayings = repository.findAll();
        Collections.reverse(sayings);
        return sayings;
    }

    public List<Saying> findAll() {
        return repository.findAll();
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

    public void load(Saying saying) {
        repository.save(saying);
    }

    public void build() {
        String jsonStr = gson.sayingToJson(repository.findAll());
        localDataSave.saveJson(jsonStr);
    }

    public void txtSave() {
        localDataSave.saveTxt();
    }

    public void txtLoad() {
        List<Saying> loadDatas = localDataLoad.load();
        for (Saying saying : loadDatas) {
            repository.save(saying);
        }
        generator.updateId(loadDatas.get(loadDatas.size() - 1).getId() + 1);
    }

    private Long convertId(String request) {
        Long findId = converter.splitId(request);
        if (repository.findOne(findId) == null) {
            throw new IllegalArgumentException(findId + "번 명언은 존재하지 않습니다.");
        }
        return findId;
    }
}