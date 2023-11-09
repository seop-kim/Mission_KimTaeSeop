package com.likelion.wisesaying.service;

import com.likelion.wisesaying.domain.Saying;
import com.likelion.wisesaying.language.KoreaConstContent;
import com.likelion.wisesaying.repository.AdapterCollection;
import com.likelion.wisesaying.repository.IRepoAdapter;
import com.likelion.wisesaying.repository.jdbc.SayingDAO;
import com.likelion.wisesaying.repository.obj.SayingRepository;
import com.likelion.wisesaying.util.convertor.TypeConverter;
import com.likelion.wisesaying.util.file.LocalDataLoad;
import com.likelion.wisesaying.util.file.LocalDataSave;
import com.likelion.wisesaying.util.generator.IdGenerator;
import com.likelion.wisesaying.util.gson.GsonDataConverter;
import java.util.Collections;
import java.util.List;

public class SayingService {
    private static final LocalDataLoad LOCAL_DATA_LOAD = new LocalDataLoad();
    private static final LocalDataSave LOCAL_DATA_SAVE = new LocalDataSave();
    private static final GsonDataConverter GSON_DATA_CONVERTER = new GsonDataConverter();
    private static  final IdGenerator GENERATOR = new IdGenerator();
    private static final TypeConverter TYPE_CONVERTER = new TypeConverter();
    private static final IRepoAdapter DB_TYPE = AdapterCollection.getFunction("JDBC");

    public SayingService() {
        // jdbc 저장 방식의 경우 db에서 마지막 게시글의 id 조회 후 업데이트
        if(DB_TYPE instanceof SayingDAO){
            GENERATOR.updateId(DB_TYPE.maxId());
        }


        // obj 저장 방식의 경우 txt파일 로드
        if (DB_TYPE instanceof SayingRepository) {
            txtLoad();
        }
    }

    public static IRepoAdapter getDBType() {
        return DB_TYPE;
    }

    public Long save(Saying saying) {
        Long saveId = GENERATOR.createId();
        saying.addId(saveId);
        DB_TYPE.save(saying);

        return saveId;
    }

    public List<Saying> findAllReverse() {
        List<Saying> sayings = DB_TYPE.findAll();
        Collections.reverse(sayings);
        return sayings;
    }

    public List<Saying> findAll() {
        return DB_TYPE.findAll();
    }

    public Saying findOne(Long id) {
        return DB_TYPE.findOne(id);
    }

    public Long delete(String id) {
        Long convertId = convertId(id);
        DB_TYPE.delete(convertId);
        return convertId;
    }

    public Saying updateConfirm(String id) {
        Long convertId = convertId(id);
        return DB_TYPE.findOne(convertId);
    }

    public void update(Saying saying) {
        DB_TYPE.update(saying);
    }

    public void build() {
        String jsonStr = GSON_DATA_CONVERTER.sayingToJson(DB_TYPE.findAll());
        LOCAL_DATA_SAVE.saveJson(jsonStr);
    }

    public void txtSave() {
        LOCAL_DATA_SAVE.saveTxt();
    }

    public void txtLoad() {
        List<Saying> loadSayings = LOCAL_DATA_LOAD.load();
        for (Saying saying : loadSayings) {
            DB_TYPE.save(saying);
        }

        GENERATOR.updateId(loadSayings.get(0).getId());
    }

    private Long convertId(String request) {
        Saying saying = DB_TYPE.findOne(TYPE_CONVERTER.strToLong(request));
        if (saying == null) {
            throw new IllegalArgumentException(request + KoreaConstContent.NONE_FIND_DATA);
        }
        return saying.getId();
    }
}