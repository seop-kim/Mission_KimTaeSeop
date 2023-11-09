package com.likelion.wisesaying.repository;

import com.likelion.wisesaying.language.KoreaConstContent;
import com.likelion.wisesaying.repository.jdbc.SayingDAO;
import com.likelion.wisesaying.repository.obj.SayingRepository;

public enum AdapterCollection {
    JDBC("JDBC",new SayingDAO()),
    OBJ("OBJ", new SayingRepository());
    private final String type;
    private final IRepoAdapter function;

    AdapterCollection(String type, IRepoAdapter function) {
        this.type = type;
        this.function = function;
    }

    public static IRepoAdapter getFunction(String type) {
        for (AdapterCollection collection : values()) {
            if (collection.type.equals(type)) {
                return collection.function;
            }
        }
        throw new IllegalArgumentException(KoreaConstContent.NONE_REPO_ADAPTER);
    }
}
