package com.likelion.wisesaying.service;

import com.likelion.wisesaying.domain.Saying;
import com.likelion.wisesaying.language.KoreaContent;
import com.likelion.wisesaying.repository.SayingRepository;
import com.likelion.wisesaying.util.convertor.TypeConverter;
import com.likelion.wisesaying.util.file.LocalDataLoad;
import com.likelion.wisesaying.util.file.LocalDataSave;
import com.likelion.wisesaying.util.generator.IdGenerator;
import com.likelion.wisesaying.util.gson.GsonDataConverter;
import java.util.Collections;
import java.util.List;

public class SayingService {
    private final SayingRepository repository = SayingRepository.getInstance();
    private final LocalDataLoad localDataLoad = new LocalDataLoad();
    private final LocalDataSave localDataSave = new LocalDataSave();
    private final GsonDataConverter gson = new GsonDataConverter();
    private final IdGenerator generator = new IdGenerator();
    private final TypeConverter typeConverter = new TypeConverter();

    public SayingService() {
        txtLoad();
    }

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

    public Saying findOne(Long id) {
        return repository.findOne(id);
    }

    public Long delete(String id) {
        Long convertId = convertId(id);
        repository.delete(convertId);
        return convertId;
    }

    public Saying update(String id) {
        Long convertId = convertId(id);
        return repository.findOne(convertId);
    }

    public void build() {
        String jsonStr = gson.sayingToJson(repository.findAll());
        localDataSave.saveJson(jsonStr);
    }

    public void txtSave() {
        localDataSave.saveTxt();
    }

    public void txtLoad() {
        List<Saying> loadSayings = localDataLoad.load();
        for (Saying saying : loadSayings) {
            repository.save(saying);
        }

        generator.updateId(loadSayings.get(0).getId());
    }

    private Long convertId(String request) {
        Saying saying = repository.findOne(typeConverter.strToLong(request));
        if (saying == null) {
            throw new IllegalArgumentException(request + KoreaContent.NONE_FIND_DATA);
        }
        return saying.getId();
    }
}