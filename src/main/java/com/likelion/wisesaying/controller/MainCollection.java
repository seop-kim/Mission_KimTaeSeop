package com.likelion.wisesaying.controller;

import com.likelion.wisesaying.function.Build;
import com.likelion.wisesaying.function.Delete;
import com.likelion.wisesaying.function.End;
import com.likelion.wisesaying.function.Find;
import com.likelion.wisesaying.function.Register;
import com.likelion.wisesaying.function.Update;
import com.likelion.wisesaying.language.KoreaContent;

public enum MainCollection {
    RESISTER(KoreaContent.REGISTER, new Register()),
    UPDATE(KoreaContent.UPDATE, new Update()),
    LIST(KoreaContent.LIST, new Find()),
    DELETE(KoreaContent.DELETE, new Delete()),
    BUILD(KoreaContent.BUILD, new Build()),
    END(KoreaContent.END, new End());


    private final String path;
    private final IMainControllable function;

    MainCollection(String path, IMainControllable function) {
        this.path = path;
        this.function = function;
    }

    public static IMainControllable getFunction(String path) {
        for (MainCollection controller : values()) {
            if (controller.path.equals(path)) {
                return controller.function;
            }
        }
        throw new IllegalArgumentException(KoreaContent.NONE_COMMEND);
    }
}
