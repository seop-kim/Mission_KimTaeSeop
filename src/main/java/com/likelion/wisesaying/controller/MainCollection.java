package com.likelion.wisesaying.controller;

import com.likelion.wisesaying.function.saying.Build;
import com.likelion.wisesaying.function.saying.Delete;
import com.likelion.wisesaying.function.saying.End;
import com.likelion.wisesaying.function.saying.Find;
import com.likelion.wisesaying.function.IMainControllable;
import com.likelion.wisesaying.function.saying.Register;
import com.likelion.wisesaying.function.saying.Update;
import com.likelion.wisesaying.language.KoreaConstContent;

public enum MainCollection {
    RESISTER(KoreaConstContent.REGISTER, new Register()),
    UPDATE(KoreaConstContent.UPDATE, new Update()),
    LIST(KoreaConstContent.LIST, new Find()),
    DELETE(KoreaConstContent.DELETE, new Delete()),
    BUILD(KoreaConstContent.BUILD, new Build()),
    END(KoreaConstContent.END, new End());


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
        throw new IllegalArgumentException(KoreaConstContent.NONE_COMMEND);
    }
}
