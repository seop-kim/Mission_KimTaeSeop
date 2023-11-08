package com.likelion.wisesaying.service;

import com.likelion.wisesaying.repository.AdapterCollection;
import com.likelion.wisesaying.repository.IAdapter;
import com.likelion.wisesaying.repository.jdbc.SayingDAO;
import com.likelion.wisesaying.domain.Saying;
import com.likelion.wisesaying.language.KoreaContent;
import com.likelion.wisesaying.repository.obj.SayingRepository;
import com.likelion.wisesaying.util.convertor.TypeConverter;
import com.likelion.wisesaying.util.file.LocalDataLoad;
import com.likelion.wisesaying.util.file.LocalDataSave;
import com.likelion.wisesaying.util.generator.IdGenerator;
import com.likelion.wisesaying.util.gson.GsonDataConverter;
import java.util.Collections;
import java.util.List;

public class SayingService {
    private final LocalDataLoad localDataLoad = new LocalDataLoad();
    private final LocalDataSave localDataSave = new LocalDataSave();
    private final GsonDataConverter gson = new GsonDataConverter();
    private final IdGenerator generator = new IdGenerator();
    private final TypeConverter typeConverter = new TypeConverter();
    private final IAdapter dbType = AdapterCollection.getFunction("JDBC");

    public SayingService() {
        // txtLoad(); DB 저장으로 인한 주석
    }

    public Long save(Saying saying) {
        Long saveId = generator.createId();
        saying.setId(saveId);
        dbType.save(saying);

        return saveId;
    }

    public List<Saying> findAllReverse() {
        List<Saying> sayings = dbType.findAll();
        Collections.reverse(sayings);
        return sayings;
    }

    public List<Saying> findAll() {
        return dbType.findAll();
    }

    public Saying findOne(Long id) {
        return dbType.findOne(id);
    }

    public Long delete(String id) {
        Long convertId = convertId(id);
        dbType.delete(convertId);
        return convertId;
    }

    public Saying updateConfirm(String id) {
        Long convertId = convertId(id);
        return dbType.findOne(convertId);
    }

    public void update(Saying saying) {
        dbType.update(saying);
    }

    public void build() {
        String jsonStr = gson.sayingToJson(dbType.findAll());
        localDataSave.saveJson(jsonStr);
    }

    public void txtSave() {
        localDataSave.saveTxt();
    }

    public void txtLoad() {
        List<Saying> loadSayings = localDataLoad.load();
        for (Saying saying : loadSayings) {
            dbType.save(saying);
        }

        generator.updateId(loadSayings.get(0).getId());
    }

    private Long convertId(String request) {
        Saying saying = dbType.findOne(typeConverter.strToLong(request));
        if (saying == null) {
            throw new IllegalArgumentException(request + KoreaContent.NONE_FIND_DATA);
        }
        return saying.getId();
    }
}