package com.likelion.wisesaying.repository;

import com.likelion.wisesaying.language.KoreaContent;
import com.likelion.wisesaying.repository.jdbc.SayingDAO;
import com.likelion.wisesaying.repository.obj.SayingRepository;

public enum AdapterCollection {
    JDBC("JDBC",new SayingDAO()),
    OBJ("OBJ", new SayingRepository());
    private final String type;
    private final IAdapter function;

    AdapterCollection(String type, IAdapter function) {
        this.type = type;
        this.function = function;
    }

    public static IAdapter getFunction(String type) {
        for (AdapterCollection collection : values()) {
            if (collection.type.equals(type)) {
                return collection.function;
            }
        }
        throw new IllegalArgumentException(KoreaContent.NONE_REPO_ADAPTER);
    }
}
